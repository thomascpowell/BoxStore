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
   * Overrides the toString method.
   * @return The string representation.
   * */
  @Override
  public String toString() {
    return String.format("%s; Legs: %d",
    super.toString(), this.getLegs());
  }

}
