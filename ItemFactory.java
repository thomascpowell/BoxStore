import java.util.Scanner;

public class ItemFactory {

  public static Item createItem(String type) {
    try {
      return createItemHelper(type);
    } catch (Throwable e) {
      e.printStackTrace();
      System.out.println("Item factory error: " + e.getMessage());
      return null;
    }
  }

  public static void main(String[] args) {
    System.out.println("TEST DRIVER");
    Item test = createItem("Fruit");
    System.out.println(test);
  }

  private static Item createItemHelper(String type) throws Exception {
    Scanner in = new Scanner(System.in);
    Item res;
    String name;
    double price;
    String expiration;
    boolean citrus;
    boolean fragile;
    String material;
    int legs;
    int releaseYear;
    String processor;
    String formFactor;
    int size;
    String color;
    boolean hightop;
    String resolution;
    boolean green;
    String brand;
    String description;

    name = Utils.getString(in, "Name: ");
    price = Utils.getInt(in, "Price: ");
    brand = Utils.getString(in, "Brand: ");
    description = Utils.getString(in, "Description: ");

    switch (type) {
      case "Fruit":
        citrus =  Utils.getBool(in, "Is the item citrus?");
        expiration = Utils.getString(in, "Expiration: ");
        res = new Fruit(name, price, brand, description, expiration, citrus);
        break;
      case "Furniture":
        fragile = Utils.getBool(in, "Is the item fragile?");
        material = Utils.getString(in, "Material: ");
        legs = Utils.getInt(in, "Legs: ");
        res = new Furniture(name, price, brand, description, fragile, material, legs);
        break;
      case "Laptop":
        fragile = Utils.getBool(in, "Is the item fragile?");
        processor = Utils.getString(in, "Processor: ");
        releaseYear = Utils.getInt(in, "Release Year: ");
        res = new Laptop(name, price, brand, description, fragile, releaseYear, processor);
        break;
      case "Phone":
        fragile = Utils.getBool(in, "Is the item fragile?");
        formFactor = Utils.getString(in, "Form Factor: ");
        releaseYear = Utils.getInt(in, "Release Year: ");
        res = new Phone(name, price, brand, description, fragile, releaseYear, formFactor);
        break;
      case "Shirt":
        fragile = Utils.getBool(in, "Is the item fragile?");
        size = Utils.getInt(in, "Size: ");
        color = Utils.getString(in, "Color: ");
        res = new Shirt(name, price, brand, description, fragile, size, color);
        break;
      case "Shoe":
        fragile = Utils.getBool(in, "Is the item fragile?");
        size = Utils.getInt(in, "Size: ");
        hightop = Utils.getBool(in, "Is the shoe a hightop?");
        res = new Shoe(name, price, brand, description, fragile, size, hightop);
        break;
      case "TV":
        fragile = Utils.getBool(in, "Is the item fragile?");
        resolution = Utils.getString(in, "Resolution: ");
        releaseYear = Utils.getInt(in, "Release Year: ");
        res = new TV(name, price, brand, description, fragile, releaseYear, resolution);
        break;
      case "Vegetable":
        green = Utils.getBool(in, "Is the vegetable green?");
        expiration = Utils.getString(in, "Expiration: ");
        res = new Vegetable(name, price, brand, description, expiration, green);
        break;
      default:
        throw new Exception("Unknown Item Type");
    }
    return res;
  }
}
