import java.util.ArrayList;
import java.util.Scanner;

// TODO: Change this name to include our last names

public class WQS {

  ArrayList<Item> inventory;

  public WQS() {
    inventory = new ArrayList<Item>();
  }

  private int menu(Scanner in) {
    System.out.print("\n\nWQS Store Menu: \n1: Add Item \n2: Sell Item \n0: Exit Program \nInput: ");
    try {
      int res = in.nextInt();
      return res;
    } catch (Exception InputMismatchException) {
      return 42;
    }

  }

  private void addItem(Scanner in) {
    System.out.println("\n Add Item:");

    System.out.println("Food (1), Electronics (2), Clothing (3), Household (3): ");
    int type = in.nextInt();
  }

  private void sellItem(Scanner in) {

    // instanceof

  }

  public static void main(String[] args) {

    WQS store = new WQS();
    Scanner in = new Scanner(System.in);
    int choice = 42;
    while (true) {
      choice = store.menu(in);
      switch (choice) {
        case 1:
          store.addItem(in);
          break;
        case 2:
          store.sellItem(in);
          break;
        case 0:
          System.out.println("\nExiting.");
          break;
        default:
          System.out.println("\nInvalid input."); 
          break;
      }
      in.close();
    }

  }
}
