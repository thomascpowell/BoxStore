import java.util.ArrayList;
import java.util.Scanner;
// TODO: Change the file name to include names
// TODO: Document code

public class WQS {

  ArrayList<Item> inventory;

  public WQS() {
    inventory = new ArrayList<Item>();
  }

  private void generateInventory() {
    this.inventory.add(new Fruit("apple", 2, "3/1/25", false));
    this.inventory.add(new Fruit("lemon", 2, "3/1/25", true));
    this.inventory.add(new Furniture("table", 200, true, "glass", 4));
    this.inventory.add(new Laptop("macbook", 7, true, 2010, "pentium dual core"));
    this.inventory.add(new Phone("nokia", 23, false, 2000, "brick"));
    this.inventory.add(new Shirt("nike shirt", 40, false, 2, "gray"));
    this.inventory.add(new Shoe("nike shoe", 400, false, 2, false));
    this.inventory.add(new TV("samsung tv", 75, true, 2022, "720p"));
    this.inventory.add(new Vegetable("carrot", 2, "3/2/25", false));
  }

  private int menu(Scanner in) {
    System.out.print("\n\nWQS Store Menu: \n1: Add Item \n2: Sell Item \n3: Display Inventory \n0: Exit Program \nInput: ");
    try {
      int res = in.nextInt();
      return res;
    } catch (Exception InputMismatchException) {
      in.nextLine();
      return 42;
    }

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
      System.out.print("\nInput FoodItem, ElectronicItem, Outerwear, HouseholdItem or 0 to exit: ");
      String target = in.next();
      if (target.equals("0")) {
        System.out.println("Exiting.");
        break;
      }
      ArrayList<Item> items = getItemsWithInstanceOf(target);
      if (items.size() == 0) {
        continue;
      }

      this.printItems(items);
      System.out.print("Input an item number to add to, -1 to add a new type of item, or 0 to exit: ");

      try {
        choice = in.nextInt();
      } catch (Exception InputMismatchException) {
        System.out.println("Invalid input.");
        return;
      }

      if (0 < choice && choice < items.size()) {
        Item selection = items.get(choice);
        System.out.printf("How many %ss should be added? ", selection.getName());
        items.get(choice).setQuantity(selection.getQuantity() + in.nextInt());
      }
      if (choice == 0) {
        break;
      }
      if (choice == -1) {
        // TODO: Handle new object creation, reflection helper class?
      } else {
        System.out.println("Invalid input.");
      }
    }
  }

  private String generateTable(ArrayList<Item> items) {
    // TODO: For sellItem
    // "Displays available options in a table format for the selected category, 
    // including details such as the item name, price, brand (if applicable),
    // description, and return policy."
    return "";
  }

  private String generateOrderSummary(ArrayList<Item> items) {
    // TODO: For sellItem
    // "Displays an order summary (group item types together in output)"
    return "";
  }

  private void sellItem(Scanner in) {
    // TODO: Basically copy addItem, but use generateTable to display info
  }

  public static void main(String[] args) {
    WQS store = new WQS();
    store.generateInventory();
    Scanner in = new Scanner(System.in);
    int choice = 42;
    loop: while (true) {
      choice = store.menu(in);
      switch (choice) {
        case 1:
          store.addItem(in);
          break;
        case 2:
          store.sellItem(in);
          break;
        case 3:
          store.printItems(store.inventory);
          break;
        case 0:
          System.out.println("Exiting.");
          break loop;
        default:
          System.out.println("Invalid input."); 
          break;
      }
    }
    in.close();
  }
}
