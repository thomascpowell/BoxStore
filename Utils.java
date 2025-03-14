import java.util.Scanner;

public class Utils {

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
        System.out.print(prompt + " [Y/N] ");
        String res = in.next();
        if (res.equalsIgnoreCase("y")) {
          in.nextLine();
          return true;
        }
        if (res.equalsIgnoreCase("n")) {
          in.nextLine();
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
}
