package restaurant;

import java.util.ArrayList;

public class Food extends Products {
    private String TypeFood;  // เก็บประเภทอาหาร เช่น ต้ม, ผัด ฯลฯ

    // Constructor สำหรับกำหนดค่าเริ่มต้นของสินค้าอาหาร
    public Food(String code, String name, int price, String TypeFood) {
        super(code, name, price);  // เรียกใช้ Constructor ของคลาส Products
        this.TypeFood = TypeFood;  // กำหนดประเภทอาหาร
    }

    // Getter สำหรับดึงข้อมูลประเภทอาหาร
    public String getTypeFood() {
        return TypeFood;
    }

    // Method สำหรับเพิ่มสินค้าใหม่ลงใน foodList
    public static void addFood(Food food) {
        foodList.add(food);  // เพิ่มสินค้าอาหารใหม่ลงในรายการ foodList
    }

    // สร้าง ArrayList เพื่อเก็บข้อมูลสินค้าอาหาร
    private static ArrayList<Food> foodList = new ArrayList<>();

    // Method สำหรับดึงรายการอาหารที่ถูกกำหนดไว้ล่วงหน้า 
    public static ArrayList<Food> getPredefinedFoods() {
        // เพิ่มอาหารตัวอย่างลงในรายการ foodList
        foodList.add(new Food("103", "ต้มยำกุ้ง", 300, "ต้ม"));  // อาหารต้มยำกุ้ง ราคา 300 บาท
        foodList.add(new Food("102", "ต้มโคล้งปลา", 250, "ต้ม"));  // อาหารต้มโคล้งปลา ราคา 250 บาท
        foodList.add(new Food("101", "ผัดเผ็ดปลากราย", 250, "ผัด"));  // อาหารผัดเผ็ดปลากราย ราคา 250 บาท
        return foodList;  // คืนค่ารายการอาหารทั้งหมด
    }

    // Override เมธอด toString สำหรับแสดงข้อมูลสินค้าอาหารในรูปแบบข้อความ
    @Override
    public String toString() {
        return "รหัสสินค้า: " + getCode() + ", ชื่อ: " + getName() + ", ราคา: " + getPrice() +
                ", ประเภท: " + TypeFood;  // แสดงรหัส, ชื่อ, ราคา และประเภทอาหาร
    }
}
