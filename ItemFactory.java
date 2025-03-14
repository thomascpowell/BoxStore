import java.util.Scanner;

public class ItemFactory {

  public static void main(String[] args) {
    System.out.println("TEST DRIVER");
    Item test = createItem("TV");
    System.out.println(test);
  }


  public static Item createItem(String type) {
    try {
      return createItemHelper(type);
    } catch (Throwable e) {
      e.printStackTrace();
      System.out.println("Item factory error: " + e.getMessage());
      return null;
    }
  }

  public static String getString(Scanner in, String prompt) {
    String res;
    while (true) {
      try {
        System.out.print(prompt);
        res = in.nextLine();
        break;
      } catch (Exception e) {
        System.out.println("Expected string.");
      }
    }
    return res;
  }

  public static int getInt(Scanner in, String prompt) {
    int res;
    while (true) {
      try {
        System.out.print(prompt);
        res = in.nextInt();
        break;
      } catch (Exception e) {
        System.out.println("Expected int.");
        in.nextLine();
      }
    }
    in.nextLine();
    return res;
  }

  public static boolean getBool(Scanner in, String prompt) {
    while (true) {
      try {
        System.out.print(prompt + " [Y/N]");
        String res = in.next();
        if (res.equalsIgnoreCase("y")) {
          return true;
        }
        if (res.equalsIgnoreCase("n")) {
          return false;
        }
        else {
          throw new Exception("Expected y or n.");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
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
    String brand;
    String description;

    name = getString(in, "Name: ");
    price = getInt(in, "Price: ");
    brand = getString(in, "Brand: ");
    description = getString(in, "Description: ");

    switch (type) {

      case "Fruit":
        System.out.print("Is the item citrus [Y/N]: ");
        citrus = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Expiration: ");
        expiration = in.next();
        res = new Fruit(name, price, brand, description, expiration, citrus);
        break;
      
      case "Furniture":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Material: ");
        material = in.next();
        System.out.print("Legs: ");
        legs = in.nextInt();
        in.nextLine();
        res = new Furniture(name, price, brand, description, fragile, material, legs);
        break;

      case "Laptop":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Processor: ");
        processor = in.next();
        System.out.print("Release Year: ");
        releaseYear = in.nextInt();
        in.nextLine();
        res = new Laptop(name, price, brand, description, fragile, releaseYear, processor);
        break;

      case "Phone":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Form Factor: ");
        formFactor = in.next();
        System.out.print("Release Year: ");
        releaseYear = in.nextInt();
        in.nextLine();
        res = new Phone(name, price, brand, description, fragile, releaseYear, formFactor);
        break;

      case "Shirt":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Size: ");
        size = in.nextInt();
        in.nextLine();
        System.out.print("Color: ");
        color = in.next();
        res = new Shirt(name, price, brand, description, fragile, size, color);
        break;

      case "Shoe":
        System.out.print("Is the item fragile? [Y/N]: ");
        fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Size: ");
        size = in.nextInt();
        in.nextLine();
        System.out.print("Is the item a hightop? [Y/N]: ");
        hightop = (in.next().equalsIgnoreCase("y") ? false : true);
        res = new Shoe(name, price, brand, description, fragile, size, hightop);
        break;

      case "TV":
        //System.out.print("Is the item fragile? [Y/N]: ");
        //fragile = (in.next().equalsIgnoreCase("y") ? false : true);
        fragile = getBool(in, "Is the item fragile?");
        System.out.print("Resolution: ");
        resolution = in.next();
        System.out.print("Release Year: ");
        releaseYear = in.nextInt(); // do not consume newline character here?
        res = new TV(name, price, brand, description, fragile, releaseYear, resolution);
        break;

      case "Vegetable":
        System.out.print("Is the item green? [Y/N]: ");
        green = (in.next().equalsIgnoreCase("y") ? false : true);
        System.out.print("Expiration: ");
        expiration = in.next();
        res = new Vegetable(name, price, brand, description, expiration, green);
        break;

      default:
        throw new Exception("Unknown Item Type");
    }
    return res;

  }
}
