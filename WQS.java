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
    // loop until user is done
    while (true) {
      // get item type to display
      System.out.print("\nInput FoodItem, ElectronicItem, Outerwear, HouseholdItem or 0 to exit: ");
      String target = in.next();
      if (target.equals("0")) {
        System.out.println("Exiting. Updated Inventory:");
        this.printItems(inventory);
        break;
      }
      // print items of specified ancestor class
      ArrayList<Item> items = getItemsWithInstanceOf(target);
      if (items.size() == 0) {
        System.out.println("No items right now.");
        continue;
      } else {
        this.printItems(items);
      }
      // get item to add
      System.out.print("Input an item number to add to, -1 to add a new type of item, or 0 to exit: ");
      try {
        choice = in.nextInt();
      } catch (Exception InputMismatchException) {
        System.out.println("Invalid input.");
        continue;
      }
      // case: add to current item
      if (0 < choice && choice < items.size()+1) {
        Item selection = items.get(choice-1);
        System.out.printf("How many %ss should be added? ", selection.getName());
        selection.setQuantity(selection.getQuantity() + in.nextInt());
        continue;
      }
      // case: exit current item type
      if (choice == 0) {
        continue;
      }
      // case: add new item type
      if (choice == -1) {
        // ItemFactory abstracts most of this
        System.out.print("Input item type: [Fruit, Laptop, Outerwear, Phone, Shirt, TV, Vegetable, Furniture]: ");
        try {
          Item res = ItemFactory.createItem(in.next());
          if (res == null) {throw new Exception();}
          inventory.add(res);
          continue;
        } catch (Exception e) {
          System.out.println("Error creating new item.");
          in.nextLine();
          continue;
        }
      }
      System.out.println("Invalid input.");
      in.nextLine();
    }
  }




  private void generateTable(ArrayList<Item> items) {
    // TODO: For sellItem
    // "Displays available options in a table format for the selected category, 
    // including details such as the item name, price, brand (if applicable),
    // description, and return policy."
    for (Item item: items){
      System.out.printf("%s: %s%n%s: %f%n%s: %s%n%s: %s%n%s: %d", "Name", item.getName(), "Price", item.getPrice(),
              "Brand", item.getBrand(), "Description", item.getDescription(), "Return Policy", item.getReturnPolicy());
    }
  }





  private String generateOrderSummary(ArrayList<Item> items) {
    // TODO: For sellItem
    // "Displays an order summary (group item types together in output)"
    return "";
  }








  private void sellItem(Scanner in) {//Scanner in
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
