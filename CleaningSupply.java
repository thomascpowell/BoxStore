/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the CleaningSupply class.
 * */

public class CleaningSupply extends HouseholdItem {
 
  private boolean sprayBottle;

  /**
   * Creates a cleaning supply with complete attribute set to enable proper
   * categorization in inventory and provide accurate customer information.
   *
   * @param name The name of the cleaning supply
   * @param price The price of the cleaning supply
   * @param brand The manufacturer brand of the cleaning supply
   * @param description A brief description of the cleaning supply
   * @param fragile Whether the cleaning supply should be handled with care
   * @param material The primary material of the cleaning supply container
   * @param sprayBottle Whether the cleaning supply comes in a spray bottle
   */

  public CleaningSupply(String name, double price, String brand, String description, boolean fragile, String material, boolean sprayBottle) {
    super(name, price, brand, description, fragile, material);
    this.sprayBottle = sprayBottle;
  }

  /**
   * Identifies spray bottle status to determine
   * @return true if the cleaning supply is in a spray bottle, false otherwise
   * */

  public boolean isSprayBottle() {
    return sprayBottle;
  }

  // Simple setter method(s) like below should have JavaDoc comments. Will add to all class files. - Waldo

  /**
   * Updates spray bottle status when product packaging changes
   *
   * @param sprayBottle true if the cleaning supply is in a spray bottle, false otherwise
   */

  public void setSprayBottle(boolean sprayBottle) {
    this.sprayBottle = sprayBottle;
  }

  /**
   * Formats item details for inventory listings and receipts.
   *
   * @return a formatted string representation of the cleaning supply
   */

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %d; Fragile: %b; Material: %s; Spray Bottle: %b",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getMaterial(), this.isSprayBottle());
  }
}
