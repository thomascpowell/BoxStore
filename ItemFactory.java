import java.util.Scanner;


public class ItemFactory {

  public static Item createItem(String type) {
    Scanner in = new Scanner(System.in);
    try {
      return createItemHelper(type);
    } catch (Throwable e) {
      e.printStackTrace();
      System.out.println("Item factory error: " + e.getMessage());
      return null;
    }
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

    System.out.print("Name: ");
    name = in.next();
    System.out.print("Price: ");
    price = in.nextInt();

    switch (type) {

      case "Fruit":
        System.out.print("Is the item citrus [Y/N]: ");
        citrus = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Expiration: ");
        expiration = in.next();
        res = new Fruit(name, price, expiration, citrus);
        break;
      
      case "Furniture":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Material: ");
        material = in.next();
        System.out.print("Legs: ");
        legs = in.nextInt();
        res = new Furniture(name, price, fragile, material, legs);
        break;

      case "Laptop":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Processor: ");
        processor = in.next();
        System.out.print("Release Year: ");
        releaseYear = in.nextInt();
        res = new Laptop(name, price, fragile, releaseYear, processor);
        break;

      case "Phone":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Form Factor: ");
        formFactor = in.next();
        System.out.print("Release Year: ");
        releaseYear = in.nextInt();
        res = new Phone(name, price, fragile, releaseYear, formFactor);
        break;

      case "Shirt":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Size: ");
        size = in.nextInt();
        System.out.print("Color: ");
        color = in.next();
        res = new Shirt(name, price, fragile, size, color);
        break;

      case "Shoe":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Size: ");
        size = in.nextInt();
        System.out.print("Is the item a hightop? [Y/N]: ");
        hightop = (in.next().equalsIgnoreCase("y") ? false : true);
        res = new Shoe(name, price, fragile, size, hightop);
        break;

      case "TV":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Resolution: ");
        resolution = in.next();
        System.out.print("Release Year: ");
        releaseYear = in.nextInt();
        res = new TV(name, price, fragile, releaseYear, resolution);
        break;

      case "Vegetable":
        System.out.print("Is the item green? [Y/N]: ");
        green = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Expiration: ");
        expiration = in.next();
        res = new Vegetable(name, price, expiration, green);
        break;

      default:
        throw new Exception("Unknown Item Type");
    }
    return res;

  }
}
