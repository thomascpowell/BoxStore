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

  private ArrayList<Item> getItemsByClass(String target) {
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
        Item res = ItemFactory.createItem(Utils.getString(in, "New Item Type: "));
        if (res != null) {
          inventory.add(res);
        }
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
      ArrayList<Item> items = getItemsByClass(type);

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
    System.out.printf("%-10s%-15s%-15s%-15s%-20s%-15s%-15s\n","Item", "Name", "Price", "Brand", "Description", "Return Policy", "Quantity");
    String str = "-";
    System.out.println(str.repeat(99));
    int count = 1;
    for (Item item : items) {
      System.out.printf("%-10d%-15s%-15.2f%-15s%-25s%-15d%-15s\n",count++, item.getName(), item.getPrice(), item.getBrand(), item.getDescription(), item.getReturnPolicy(), item.getQuantity());
    }
    System.out.println();
  }

  private void printOrderSummary(ArrayList<Item> items) {
    // "Displays an order summary (group item types together in output)"
    int count = 0;
    double subtotal = 0;
    double taxes = 0;
    for (Item item : items) {
      count += 1 * item.getQuantity();
      subtotal += item.getPrice() * item.getQuantity();
      taxes += item.getPrice() * item.getTax() * item.getQuantity();
    }
    double totalPrice = taxes + subtotal;
    System.out.println("\nCart:");
    printTable(items);
    System.out.printf("Order Summary: \nTotal Items: %d \nSubtotal: $%.2f \nTaxes: $%.2f \nTotal Price: $%.2f\n", count, subtotal, taxes, totalPrice);
  }

  private void addToCart(ArrayList<Item> cart, Item selection) {
    // remove one item from inventory
    int index = inventory.indexOf(selection);
    if (selection.getQuantity() == 1) {
      inventory.remove(index);
    } else {
      inventory.get(index).setQuantity(selection.getQuantity()-1);
    } 
    // copy to ancestor
    Item copy = new Item(
      selection.getName(),
      selection.getPrice(),
      selection.getBrand(),
      selection.getDescription()
    );
    copy.setTax(selection.getTax());
    // check if item type is already in cart
    for (Item item : cart) {
      if (copy.equals(item)) {
        item.setQuantity(item.getQuantity()+1);
        return;
      }
    }
    cart.add(copy);
  }

  private void sellItem(Scanner in) {
    ArrayList<Item> cart = new ArrayList<Item>();
    int choice;
    while (true) {
      // menu, input validation
      System.out.println("\nSell Item Menu: \n1: Food \n2: Electronic \n3: Outerwear \n4: Household \n0: Checkout");
      while (true) {
        choice = Utils.getInt(in, "Input: ");
        if (0 <= choice && choice <= 5) { 
          break; 
        } 
        System.out.println("Expected value between 0 and 5.");
      }
      // checkout
      if (choice == 0) {
        this.printOrderSummary(cart);
        break;
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
      ArrayList<Item> items = getItemsByClass(type);
      if (items.size() == 0) {
        System.out.println("No items right now.");
        continue;
      } else {
        System.out.println("\nAvailable Items: ");
        this.printTable(items);
      }
      // add item to cart
      choice = Utils.getInt(in, "Input an item number to add to cart, or 0 to exit: ");
      if (0 < choice && choice < items.size()+1) {
        Item selection = items.get(choice-1);
        addToCart(cart, selection);
      }
    }
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
