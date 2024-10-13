package restaurant;

public class Products {
    private String code;  // รหัสสินค้า
    private String name;  // ชื่อสินค้า
    private int price;    // ราคาสินค้า

    // Constructor 
    public Products(String code, String name, int price) {
        this.code = code;  // กำหนดรหัสสินค้า
        this.name = name;  // กำหนดชื่อสินค้า
        this.price = price;  // กำหนดราคาสินค้า
    }

    // Getter สำหรับดึงค่ารหัสสินค้า
    public String getCode() {
        return code;
    }

    // Getter สำหรับดึงค่าชื่อสินค้า
    public String getName() {
        return name;
    }

    // Getter สำหรับดึงค่าราคาสินค้า
    public int getPrice() {
        return price;
    }

}
