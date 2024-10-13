package restaurant;

import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {
    	System.out.println("*********** การเพิ่มสินค้า ***********");
        // เพิ่ม เครื่องดื่ม
        Products drink1 = CreateProduct.createDrink("น้ำใจ", 15, "2024-12-31", "นักกีฬา");
        // เพิ่ม อาหาร
        Products food1 = CreateProduct.createFood("ขนมปัง", 35, "ต้ม");
        
        // ดึงข้อมูล เครื่องดื่ม
        System.out.println("-------- เครื่องดื่มทั้งหมด --------");
        ArrayList<Drinks> drinksList = Drinks.getPredefinedDrinks();
        for (Drinks drink : drinksList) {
            System.out.println(drink.toString());
        }

        // ดึงข้อมูล อาหาร
        System.out.println("-------- เครื่องอาหารทั้งหมด --------");
        ArrayList<Food> foodList = Food.getPredefinedFoods();  
        for (Food food : foodList) {
            System.out.println(food.toString());
        }
        
        
    	System.out.println("*********** แต้มลูกค้า ***********");

            
    	 // สร้างสมาชิก VIP ที่หมดอายุ
        Member expiredVIPMember = new Member("Jane", true, "2022-08-01");  // สมาชิก VIP หมดอายุ

        // สร้างสมาชิกปกติ ที่ยังไม่หมดอายุ
        Member regularMember = new Member("John", false, "2024-01-01");  // สมาชิกปกติ

        // สร้างลูกค้าทั่วไป
        Member nonMember = new Member("Mark", false, null);  // ลูกค้าทั่วไป

        // สร้างรายการสินค้า
        ArrayList<Products> items = new ArrayList<>();
        items.add(drink1);
        items.add(food1);

        // การชำระเงินสำหรับสมาชิก VIP ที่หมดอายุ
        System.out.println("----- ลูกค้า  สมาชิก VIP -----");
        System.out.println(expiredVIPMember.toString());
        Payment.processPayment(expiredVIPMember, items);  // ส่งรายการสินค้าไปที่ Payment

        // การชำระเงินสำหรับสมาชิกปกติ
        System.out.println("----- ลูกค้า สมาชิก ปกติ -----");
        System.out.println(regularMember.toString());
        Payment.processPayment(regularMember, items);  // ส่งรายการสินค้าไปที่ Payment

        // การชำระเงินสำหรับลูกค้าทั่วไป
        System.out.println("----- ลูกค้า ทั่วไป -----");
        System.out.println(nonMember.toString());
        Payment.processPayment(nonMember, items);  // ส่งรายการสินค้าไปที่ Payment
    }
}
