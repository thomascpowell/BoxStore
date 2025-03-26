/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the Furniture class.
 * */

public class Furniture extends HouseholdItem {
  private int legs;

  /**
   * Creates a furniture item with structural information.
   *
   * @param name Item name for inventory
   * @param price Retail price
   * @param brand Manufacturer
   * @param description Product details
   * @param fragile Handling requirement flag
   * @param material Construction material
   * @param legs Number of supporting legs
   */

  public Furniture(String name, double price, String brand, String description, boolean fragile, String material, int legs) {
    super(name, price, brand, description, fragile, material);
    this.legs = legs;
  }

  /**
   * Retrieves leg count for assembly instructions.
   *
   * @return Number of legs
   */

  public int getLegs() {
    return legs;
  }

  /**
   * Updates leg count when product design changes.
   *
   * @param legs New leg count
   */

  public void setLegs(int legs) {

    this.legs = legs;
  }

  /**
   * Creates display text for inventory listings.
   *
   * @return Formatted furniture information
   */

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Fragile: %b; Material: %s; Legs: %d",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getMaterial(), this.getLegs());
  }
}
