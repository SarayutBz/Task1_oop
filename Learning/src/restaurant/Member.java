package restaurant;
import java.time.LocalDate;  // ใช้สำหรับการจัดการวันที่
import java.time.format.DateTimeFormatter;  // ใช้สำหรับการจัดรูปแบบวันที่
import java.util.ArrayList;  // ใช้ในการจัดการรายการสินค้า

// คลาสสำหรับสมาชิก (Member)
public class Member {
    private String memberID = generateMemberID();  // เก็บรหัสสมาชิก
    private String userName;  // ชื่อของสมาชิก
    private boolean isVIP;  // สถานะ VIP ของสมาชิก
    private String applicationDate;  // วันที่สมัครสมาชิก
    private int points = 0;  // คะแนนสะสม
    private boolean isExpired = false;  // สถานะการหมดอายุของสมาชิก

    // Constructor สำหรับสร้างสมาชิกใหม่
    public Member(String userName, boolean isVIP, String applicationDate) {
        this.userName = userName;
        this.isVIP = isVIP;
        this.applicationDate = applicationDate;
    }

    // สร้างรหัสสมาชิกแบบสุ่ม
    public String generateMemberID() {
        return "" + (int) (Math.random() * 10000);  // รหัสสมาชิกเป็นเลข 4 หลักสุ่ม
    }

    // เมธอดสำหรับเพิ่มคะแนนสะสม
    private void addPoint(double totalPrice, int classPoint) {
        points += (int) (totalPrice / classPoint);  // คำนวณคะแนนจากยอดซื้อ
    }

    // Getter สำหรับคะแนนสะสม
    public int getPoints() {
        return points;
    }

    // Setter สำหรับกำหนดวันที่สมัครสมาชิกใหม่
    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    // คำนวณราคาสำหรับลูกค้าทั่วไป
    public double normalPeople(ArrayList<Products> items) {
        double totalPrice = 0;
        for (Products item : items) {
            totalPrice += item.getPrice();  // รวมราคาของสินค้าทั้งหมด
        }
        return totalPrice;
    }

    // คำนวณราคาสำหรับสมาชิกและลูกค้าทั่วไป
    double calculatePrice(ArrayList<Products> items) {
        checkMembership();  // ตรวจสอบว่าสมาชิกหมดอายุหรือไม่
        if (isExpired == false) {
            System.out.println("สมาชิกหมดอายุ! จ่ายราคาปกติ.");
            normalPeople(items);  // ถ้าหมดอายุให้จ่ายราคาปกติ
        }

        // ดึงข้อมูลสินค้าและคำนวณราคารวม
        double totalPrice = 0;
        for (Products item : items) {
            totalPrice += item.getPrice();
        }

        // ถ้าเป็นสมาชิก VIP จะได้รับส่วนลด 10%
        if (isVIP == true) {
            totalPrice *= 0.9;  // ลดราคา 10%
            addPoint(totalPrice, 20);  // ทุกการใช้จ่าย 20 บาท ได้ 1 คะแนนสะสม
        }
        // ถ้าเป็นสมาชิกปกติ
        else if (applicationDate != null) {
            for (Products item : items) {
                if (!(item instanceof Drinks)) {  // ส่วนลด 5% สำหรับอาหาร (ไม่รวมเครื่องดื่ม)
                    totalPrice -= item.getPrice() * 0.05;
                }
            }
            addPoint(totalPrice, 25);  // ทุก 25 บาทได้ 1 คะแนนสะสม
        }
        return totalPrice;  // คืนค่าราคาหลังจากคิดส่วนลดแล้ว
    }

    // เมธอดตรวจสอบสถานะการหมดอายุของสมาชิก
    private void checkMembership() {
        if (applicationDate == null) {
            isExpired = false;  // ลูกค้าทั่วไปไม่มีวันหมดอายุ
            return;
        }

        // แปลงวันที่สมัครสมาชิกจาก String เป็น LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate applicationLocalDate = LocalDate.parse(applicationDate, formatter);
        LocalDate currentDate = LocalDate.now();

        // ถ้าสมัครสมาชิกมาแล้วเกิน 1 ปี สมาชิกจะหมดอายุ
        if (applicationLocalDate.plusYears(1).isBefore(currentDate)) {
            isExpired = true;
        }
    }

    // Override เมธอด toString สำหรับแสดงรายละเอียดของสมาชิก
    @Override
    public String toString() {
        String expirationStatus = isExpired ? " (สมาชิกหมดอายุ)" : "";
        if (isVIP) {
            return "รหัสสมาชิก: " + memberID + ", ชื่อ: " + userName + ", VIP: " + isVIP + ", วันที่สมัคร: " + applicationDate + ", คะแนนสะสม: " + points + expirationStatus;
        } else if (applicationDate == null) {
            return "ลูกค้าทั่วไป: " + userName;  // ถ้าไม่ใช่สมาชิก ให้แสดงว่าเป็นลูกค้าทั่วไป
        } else {
            return "รหัสสมาชิก: " + memberID + ", ชื่อ: " + userName + ", VIP: " + isVIP + ", วันที่สมัคร: " + applicationDate + ", คะแนนสะสม: " + points + expirationStatus;
        }
    }
}

// คลาสสำหรับจัดการการชำระเงิน
class Payment {
    public static void processPayment(Member member, ArrayList<Products> items) {
        double totalPrice = member.calculatePrice(items);  // คำนวณราคาหลังจากคิดส่วนลด
        System.out.println("ชำระเงินจำนวน: " + totalPrice + " บาท");

        // ถ้าสมาชิกไม่ใช่ลูกค้าทั่วไป แสดงคะแนนสะสม
        if (!member.toString().contains("ลูกค้าทั่วไป")) {
            System.out.println("คะแนนสะสมปัจจุบัน: " + member.getPoints());
        }
    }
}
