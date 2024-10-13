package restaurant;

public class CreateProduct {
	private    static int CodeCountFoods = 103;
	private   static int CodeCountDrinks = 3;

    // Method สำหรับสร้างสินค้า Drinks
    public static Products createDrink(String name, int price, String expiryDate, String company) {
        String code = "" + ++CodeCountDrinks;  // สร้างรหัสสินค้าใหม่
        Drinks newDrink = new Drinks(code, name, price, expiryDate, company);
        
        // เพิ่มสินค้าใหม่ใน drinksList ของ Drinks
        Drinks.addDrink(newDrink);  // เพิ่มลงใน drinksList
        
        return newDrink;  // คืนค่าผลลัพธ์เป็น Products (Drinks)
    }

    // Method สำหรับสร้างสินค้า Food
    public static Products createFood(String name, int price, String typeFood) {
        String code = "" + ++CodeCountFoods;  // สร้างรหัสสินค้าใหม่
        Food newFood = new Food(code, name, price, typeFood);
        // เพิ่มสินค้าใหม่ใน foodList ของ Food
        Food.addFood(newFood);  // เพิ่มสินค้าใหม่ใน foodList
        return newFood;  // คืนค่าผลลัพธ์เป็น Products (Food)
    }
}
