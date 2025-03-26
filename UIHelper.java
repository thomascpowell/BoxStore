/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define user interface function.
 * */

import java.util.ArrayList;

/**
 * Helper class for improving terminal UI display
 */
public class UIHelper {
    // Constants for formatting
    public static final String DIVIDER = "═══════════════════════════════════════════════════════════════";
    public static final String THIN_DIVIDER = "───────────────────────────────────────────────────────────────";
    public static final String BOX_HORIZONTAL = "═";
    public static final String BOX_VERTICAL = "║";
    public static final String BOX_TOP_LEFT = "╔";
    public static final String BOX_TOP_RIGHT = "╗";
    public static final String BOX_BOTTOM_LEFT = "╚";
    public static final String BOX_BOTTOM_RIGHT = "╝";

    /**
     * Print a centered header with decorative borders
     * @param title The title to display
     */
    public static void printHeader(String title) {
        System.out.println();
        System.out.println(DIVIDER);
        System.out.println(centerText(title, DIVIDER.length()));
        System.out.println(DIVIDER);
    }

    /**
     * Print a menu option with formatting
     * @param option The option number or key
     * @param description The description of the option
     */
    public static void printMenuOption(String option, String description) {
        System.out.println(BOX_VERTICAL + " " + option + ": " + description);
    }

    /**
     * Print a boxed menu with a title
     * @param title The menu title
     * @param options Array of option descriptions
     */
    public static void printBoxedMenu(String title, String[] options) {
        // Find the longest line for proper box sizing
        int maxLength = title.length();
        for (String option : options) {
            if (option.length() > maxLength) {
                maxLength = option.length();
            }
        }
        maxLength += 41; // Add padding

        // Top border
        System.out.println();
        System.out.print(BOX_TOP_LEFT);
        for (int i = 0; i < maxLength; i++) {
            System.out.print(BOX_HORIZONTAL);
        }
        System.out.println(BOX_TOP_RIGHT);

        // Title
        System.out.println(BOX_VERTICAL + " " + centerText(title, maxLength - 2) + " " + BOX_VERTICAL);

        // Divider
        System.out.print(BOX_VERTICAL + " ");
        for (int i = 0; i < maxLength - 2; i++) {
            System.out.print("─");
        }
        System.out.println(" " + BOX_VERTICAL);

        // Options
        for (int i = 0; i < options.length; i++) {
            System.out.println(BOX_VERTICAL + " " + options[i] + " ".repeat(maxLength - options[i].length() - 1) + BOX_VERTICAL);
        }

        // Bottom border
        System.out.print(BOX_BOTTOM_LEFT);
        for (int i = 0; i < maxLength; i++) {
            System.out.print(BOX_HORIZONTAL);
        }
        System.out.println(BOX_BOTTOM_RIGHT);
    }

    /**
     * Format a table with proper spacing
     * @param headers The column headers
     * @param data The data rows
     * @param columnWidths The width for each column
     */
    public static void printTable(String[] headers, ArrayList<String[]> data, int[] columnWidths) {
        // Print headers
        System.out.println();
        System.out.print("| ");
        for (int i = 0; i < headers.length; i++) {
            System.out.print(padRight(headers[i], columnWidths[i]) + " | ");
        }
        System.out.println();

        // Print separator
        System.out.print("+");
        for (int i = 0; i < headers.length; i++) {
            System.out.print("-".repeat(columnWidths[i] + 2) + "+");
        }
        System.out.println();

        // Print data
        for (String[] row : data) {
            System.out.print("| ");
            for (int i = 0; i < row.length; i++) {
                System.out.print(padRight(row[i], columnWidths[i]) + " | ");
            }
            System.out.println();
        }
    }

    /**
     * Creates a centered text string
     * @param text The text to center
     * @param width The total width
     * @return Centered text string
     */
    public static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }

    /**
     * Pads a string on the right with spaces to reach desired width
     * @param s The string to pad
     * @param width The desired width
     * @return Padded string
     */
    public static String padRight(String s, int width) {
        return s + " ".repeat(Math.max(0, width - s.length()));
    }

    /**
     * Print a summary box for order totals
     * @param count Total item count
     * @param subtotal Subtotal amount
     * @param taxes Tax amount
     * @param total Total price
     */
    public static void printOrderSummaryBox(int count, double subtotal, double taxes, double total) {
        System.out.println();
        System.out.println(THIN_DIVIDER);
        System.out.println("ORDER SUMMARY");
        System.out.println(THIN_DIVIDER);
        System.out.printf("Total Items: %d\n", count);
        System.out.printf("Subtotal:    $%.2f\n", subtotal);
        System.out.printf("Taxes:       $%.2f\n", taxes);
        System.out.println(THIN_DIVIDER);
        System.out.printf("TOTAL:       $%.2f\n", total);
        System.out.println(THIN_DIVIDER);
    }
}
