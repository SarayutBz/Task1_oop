package restaurant;

import java.util.ArrayList;

public class Drinks extends Products {
private   String expired;
private   String company;

    // สร้าง ArrayList สำหรับเก็บข้อมูลเครื่องดื่มทั้งหมดใน Drinks
    private static ArrayList<Drinks> drinksList = new ArrayList<>();

    public Drinks(String code, String name, int price, String expired, String company) {
        super(code, name, price);
        this.expired = expired;
        this.company = company;
    }

    public String getExpired() {
        return expired;
    }

    public String getCompany() {
        return company;
    }

    // Method สำหรับเพิ่มสินค้าใหม่ใน ArrayList ภายใน Drinks
    public static void addDrink(Drinks drink) {
        drinksList.add(drink);  // เพิ่มสินค้าเครื่องดื่มใหม่
    }

    // Method สำหรับดึงข้อมูลสินค้าเครื่องดื่มทั้งหมด
    public static ArrayList<Drinks> getDrinksList() {
        return drinksList;
    }

    // Method เพื่อดึงข้อมูลสินค้าประเภท Drinks ที่สร้างไว้ล่วงหน้า
    public static ArrayList<Drinks> getPredefinedDrinks() {
        drinksList.add(new Drinks("3", "โค้ก", 25, "2025-05-12", "โคคาโคล่า"));
        drinksList.add(new Drinks("2", "น้ำเปล่า", 20, "2025-08-24", "สิงห์พัฒน์"));
        drinksList.add(new Drinks("1", "แฟนต้า", 25, "2026-03-26", "โคคาโคล่า"));
        return drinksList;
    }

    // Method เพื่อแสดงข้อมูลเครื่องดื่ม
    @Override
    public String toString() {
        // ใช้ getter methods เพื่อเข้าถึงตัวแปร private ในคลาส Products
        return "รหัสสินค้า : " + getCode() + ", ชื่อ : " + getName() + ", ราคา : " + getPrice() +
                ", วันที่หมดอายุ : " + expired + ", บริษัท : " + company;
    }
}
