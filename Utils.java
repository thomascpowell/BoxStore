/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Utility class containing methods for getting user input.
 * */

import java.util.Scanner;

public class Utils {

  /**
   * Gets validated user input.
   * @param in
   * @param prompt The prompt that will be displayed to the user.
   * @return Valid String
   * */
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

  /**
   * Gets validated user input.
   * @param in
   * @param prompt The prompt that will be displayed to the user.
   * @return Valid int
   * */
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

  /**
   * Gets validated user input.
   * @param in
   * @param prompt The prompt that will be displayed to the user.
   * @return Valid boolean
   * */
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
