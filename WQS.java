import java.util.ArrayList;
import java.util.Scanner;

public class WQS {

  ArrayList<Item> inventory;

  public WQS() {
    inventory = new ArrayList<Item>();
  }

  private void generateInventory() {
    this.inventory.add(new Fruit("apple", 2, "", "desc", "3/1/25", false)); // brand can be blank/empty
    this.inventory.add(new Fruit("lemon", 2, "", "desc", "3/1/25", true)); 
    this.inventory.add(new Furniture("table", 400, "wayfair", "desc", false, "glass", 4));
    this.inventory.add(new Laptop("macbook", 7, "apple", "desc", true, 2010, "pentium dual core"));
    this.inventory.add(new Phone("3310", 23, "nokia", "desc", false, 2000, "brick"));
    this.inventory.add(new Shirt("shirt", 30, "nike", "desc", false, 2, "gray"));
    this.inventory.add(new Shoe("shoe", 400, "adidas", "desc", false, 2, false));
    this.inventory.add(new TV("tv", 75, "samsung", "desc", true, 2022, "720p"));
    this.inventory.add(new Vegetable("carrot", 2, "", "desc", "3/2/11", false));
  }

  private int menu(Scanner in) {
    System.out.print("\n\nWQS Store Menu: \n1: Add Item \n2: Sell Item \n3: Display Inventory \n0: Exit Program \n");
    return Utils.getInt(in, "Input: ");
  }

  private void printItems(ArrayList<Item> items) {
    System.out.println();
    int index = 1;
    for (Item item : items) {
      System.out.println("Item #" + index + ": " + item);
      index++;
    }
  }

  private ArrayList<Item> getItemsWithInstanceOf(String target) {
    ArrayList<Item> res = new ArrayList<Item>();
    Class<?> targetclass;
    try {
      targetclass = Class.forName(target);
    } catch (ClassNotFoundException e) {
      System.out.println("Invalid target.");
      return res;
    }
    for (Item item : this.inventory) {
      if (targetclass.isInstance(item)) {
        res.add(item);
      }
    }
    return res;
  }

  private void addItem(Scanner in) {
    int choice;
    while (true) {
      // menu, input validation
      System.out.println("\nAdd Item Menu: \n1: Food \n2: Electronic \n3: Outerwear \n4: Household \n5: New Item \n0: Exit");
      while (true) {
        choice = Utils.getInt(in, "Input: ");
        if (0 <= choice && choice <= 5) { break; } 
        System.out.println("Expected value between 0 and 5.");
      }
      // exit
      if (choice == 0) {
        System.out.println("Exiting and displaying updated inventory.");
        this.printItems(inventory);
        break;
      }
      // add new
      if (choice == 5) {
        inventory.add(ItemFactory.createItem(Utils.getString(in, "New Item Type: ")));
        continue;
      }
      // match numbers to types
      String type = switch (choice) {
        case 1 -> "FoodItem";
        case 2 -> "ElectronicItem";
        case 3 -> "Outerwear";
        case 4 -> "HouseholdItem";
        default -> "";
      };
      // print items of type
      ArrayList<Item> items = getItemsWithInstanceOf(type);
      if (items.size() == 0) {
        System.out.println("No items right now.");
        continue;
      } else {
        this.printItems(items);
      }
      // add to an item
      choice = Utils.getInt(in, "Input an item number to add to, or 0 to exit: ");
      if (0 < choice && choice < items.size()+1) {
        Item selection = items.get(choice-1);
        selection.setQuantity(
          selection.getQuantity() + 
          Utils.getInt(in, String.format("How many %ss should be added? ", selection.getName()))
        );
      }
    }
  }

  private void printTable(ArrayList<Item> items) {
    // Prints a table of items (name, price, brand, desc, return policy)
    // "Displays available options in a table format for the selected category, 
    // including details such as the item name, price, brand (if applicable),
    // description, and return policy."
    // TODO: Format as table
    for (Item item : items) {
      System.out.printf("%s: %s%n%s: %.2f%n%s: %s%n%s: %s%n%s: %d%n%n", "Name", item.getName(), "Price", item.getPrice(),
              "Brand", item.getBrand(), "Description", item.getDescription(), "Return Policy", item.getReturnPolicy());
    }
  }

  private void printOrderSummary(ArrayList<Item> items) {
    // "Displays an order summary (group item types together in output)"
    int count = 0;
    double totalPrice = 0;
    for (Item item : items){
      count += 1;
      totalPrice += item.getPrice();
    }
    System.out.println();
    printTable(items);
    System.out.printf("%s: %n%s: %d%n%s: %.2f\n", "Item Order Summary", "Total items", count, "Total Price", totalPrice);
  }

  private void sellItem(Scanner in) {
    // TODO: implement this
  }

  public static void main(String[] args) {
    WQS store = new WQS();
    store.generateInventory();
    Scanner in = new Scanner(System.in);
    int choice;
    loop: while (true) {
      choice = store.menu(in);
      switch (choice) {
        case 1 -> store.addItem(in);
        case 2 -> store.sellItem(in);
        case 3 -> store.printItems(store.inventory);
        case 7 -> store.printOrderSummary(store.inventory); // test choice for tables 
        case 0 ->  {
          System.out.println("Exiting.");
          in.close();
          break loop;
        }
        default -> System.out.println("Invalid input.");
      }
    }
  }
}
