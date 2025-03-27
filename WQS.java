/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Manage inventory for the Wilmington Quick Shop.
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class WQS {

  ArrayList<Item> inventory;


  /**
   * Creates an instance of WQS.
   * */
  public WQS() {
    inventory = new ArrayList<Item>();
  }

  /**
   * Generates sample inventory items.
   * */
  private void generateInventory() {
    this.inventory.add(new Fruit("Apple", 2, "", "Honeycrisp", "3/1/25", false));
    this.inventory.add(new Fruit("Lemon", 2, "", "", "3/1/25", true));
    this.inventory.add(new Furniture("Table", 400, "Wayfair", "Modern design", true, "Glass", 4));
    this.inventory.add(new Laptop("Macbook", 700, "Apple", "Space gray", true, 2021, "M1"));
    this.inventory.add(new Phone("3310", 23, "Nokia", "Cell", false, 200, "Brick"));
    this.inventory.add(new Shirt("Shirt", 30, "Nike", "Dry Fit", false, 2, "Gray"));
    this.inventory.add(new Shoe("Shoe", 400, "Adidas", "Running shoes", false, 2, false));
    this.inventory.add(new TV("TV", 60, "Samsung", "Smart TV", true, 2010, "720p"));
    this.inventory.add(new Vegetable("carrot", 2, "", "", "3/2/11", false));
  }

  /**
   * Prints the main menu and returns user input.
   *
   * @param in A scanner object
   * @return The user's selection
   * */
  private int menu(Scanner in) {
    UIHelper.printHeader("WQS STORE MENU");
    String[] options = {
            "1: Add Item",
            "2: Sell Item",
            "3: Display Inventory",
            "0: Exit Program"
    };
    UIHelper.printBoxedMenu("Main Menu", options);
    return Utils.getInt(in, "Input: ");
  }

  /**
   * Prints items.
   * Uses polymorphism in the form of toString overrides.
   * The ArrayList<Item> also polymorphically handles
   * all subtypes of Item.
   * @param items A list of items to be printed.
   * */
  private void printItems(ArrayList<Item> items) {
    UIHelper.printHeader("INVENTORY ITEMS");
    if (items.isEmpty()) {
      System.out.println("No items available.");
      return;
    }
    int index = 1;
    for (Item item : items) {
      System.out.println("Item #" + index + ": " + item);
      System.out.println(UIHelper.THIN_DIVIDER);
      index++;
    }
  }

  /**
   * Returns an arraylist of items in the inventory
   * that are an instance of the target classname.
   *
   * @param target
   * @return Matching items
   * */
  private ArrayList<Item> getItemsByClass(Class<?> type) {
    ArrayList<Item> res = new ArrayList<Item>();
    for (Item item : this.inventory) {
      if (type.isInstance(item)) {
        res.add(item);
      }
    }
    return res;
  }

  /**
   * Handles logic for adding items to the inventory.
   * Takes user input and either adds to an existing item,
   * or calls ItemFactory.createItem() to create an entirely
   * new item.
   *
   * @param in
   * */
  private void addItem(Scanner in) {
    int choice;
    while (true) {
      // menu, input validation
      UIHelper.printHeader("ADD ITEM MENU");
      String[] options = {
              "1: Food",
              "2: Electronic",
              "3: Outerwear",
              "4: Household",
              "5: New Item",
              "0: Exit"
      };
      UIHelper.printBoxedMenu("Select Item Type", options);

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
          System.out.println("\n" + UIHelper.BOX_VERTICAL + " Item added successfully! " + UIHelper.BOX_VERTICAL);
        }
        continue;
      }
      // match numbers to types
      Class<?> type = switch (choice) {
        case 1 -> FoodItem.class;
        case 2 -> ElectronicItem.class;
        case 3 -> Outerwear.class;
        case 4 -> HouseholdItem.class;
        default -> Item.class;
      };
      String friendlyName = switch (choice) {
        case 1 -> "FOOD";
        case 2 -> "ELECTRONIC";
        case 3 -> "OUTERWEAR";
        case 4 -> "HOUSEHOLD";
        default -> "ITEM";
      };
      // print items of type
      ArrayList<Item> items = getItemsByClass(type);

      if (items.size() == 0) {
        System.out.println("\n" + UIHelper.BOX_VERTICAL + " No items available for this category. " + UIHelper.BOX_VERTICAL);
        continue;
      } else {
        UIHelper.printHeader("AVAILABLE " + friendlyName + " ITEMS");
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
        System.out.println("\n" + UIHelper.BOX_VERTICAL + " Quantity updated successfully! " + UIHelper.BOX_VERTICAL);
      }
    }
  }

  /**
   * Prints items in a table format.
   *
   * @param items
   * */
  private void printTable(ArrayList<Item> items) {
    // Convert items to table data format
    String[] headers = {"Item", "Name", "Price", "Brand", "Description", "Return Policy", "Quantity"};
    ArrayList<String[]> data = new ArrayList<>();

    int count = 1;
    for (Item item : items) {
      String returnPolicy = item.getReturnPolicy() > 0 ? item.getReturnPolicy() + " days" : "None";
      String[] row = {
              String.valueOf(count++),
              item.getName(),
              String.format("$%.2f", item.getPrice()),
              item.getBrand(),
              item.getDescription(),
              returnPolicy,
              String.valueOf(item.getQuantity())
      };
      data.add(row);
    }

    // Define column widths
    int[] columnWidths = {6, 12, 10, 12, 20, 15, 10};

    // Print the formatted table
    UIHelper.printTable(headers, data, columnWidths);
  }

  /**
   * Calculates tax, subtotal and final total.
   * Prints an order summary.
   *
   * @param items
   * */
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

    UIHelper.printHeader("YOUR CART");
    printTable(items);
    UIHelper.printOrderSummaryBox(count, subtotal, taxes, totalPrice);
  }


  /**
   * Handles logic for adding an item to the cart in sellItem()
   * Copies information over to common ancestor (Item)
   * to avoid unwanted side effects.
   *
   * @param cart The items in the user's cart
   * @param selection The item being added
   * */
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
        System.out.println("\n" + UIHelper.BOX_VERTICAL + " Item added to cart! " + UIHelper.BOX_VERTICAL);
        return;
      }
    }
    cart.add(copy);
    System.out.println("\n" + UIHelper.BOX_VERTICAL + " Item added to cart! " + UIHelper.BOX_VERTICAL);
  }

  /**
   * Handles logic for selling items. Takes user input and
   * adds the selected items to the cart using addToCart().
   * Displays the order summary when the user decides to
   * checkout.
   *
   * @param in
   * */
  private void sellItem(Scanner in) {
    ArrayList<Item> cart = new ArrayList<Item>();
    int choice;
    while (true) {
      // menu, input validation
      UIHelper.printHeader("SELL ITEM MENU");
      String[] options = {
              "1: Food",
              "2: Electronic",
              "3: Outerwear",
              "4: Household",
              "0: Checkout"
      };
      UIHelper.printBoxedMenu("Select Category", options);

      while (true) {
        choice = Utils.getInt(in, "Input: ");
        if (0 <= choice && choice <= 4) { 
          break; 
        } 
        System.out.println("Expected value between 0 and 4.");
      }
      // checkout
      if (choice == 0) {
        this.printOrderSummary(cart);
        break;
      }
      // match numbers to types
      Class<?> type = switch (choice) {
        case 1 -> FoodItem.class;
        case 2 -> ElectronicItem.class;
        case 3 -> Outerwear.class;
        case 4 -> HouseholdItem.class;
        default -> Item.class;
      };
      String friendlyName = switch (choice) {
        case 1 -> "FOOD";
        case 2 -> "ELECTRONIC";
        case 3 -> "OUTERWEAR";
        case 4 -> "HOUSEHOLD";
        default -> "ITEM";
      };
      // print items of type
      ArrayList<Item> items = getItemsByClass(type);
      if (items.size() == 0) {
        System.out.println("\n" + UIHelper.BOX_VERTICAL + " No items available for this category. " + UIHelper.BOX_VERTICAL);
        continue;
      } else {
        UIHelper.printHeader("AVAILABLE " + friendlyName + " ITEMS");
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

  /**
   * Creates an instance of WQS. Takes user input in a loop.
   * Runs functions to handle each option.
   * */
  public static void main(String[] args) {
    WQS store = new WQS();
    store.generateInventory();
    Scanner in = new Scanner(System.in);

    UIHelper.printHeader("WELCOME TO WQS STORE");
    System.out.println(UIHelper.centerText("Your one-stop shop for all your needs", UIHelper.DIVIDER.length()));
    System.out.println();

    int choice;
    loop: while (true) {
      choice = store.menu(in);
      switch (choice) {
        case 1 -> store.addItem(in);
        case 2 -> store.sellItem(in);
        case 3 -> store.printItems(store.inventory);
        case 0 ->  {
          UIHelper.printHeader("THANK YOU FOR SHOPPING WITH US");
          System.out.println(UIHelper.centerText("Goodbye!", UIHelper.DIVIDER.length()));
          in.close();
          break loop;
        }
        default -> System.out.println("Invalid input.");
      }
    }
  }
}
