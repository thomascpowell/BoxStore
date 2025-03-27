/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the Fruit class.
 * */

public class Fruit extends FoodItem {
  
  boolean citrus;

  /**
   *
   * @param name Item name for display
   * @param price Retail price
   * @param brand Producer or distributor
   * @param description Product details
   * @param expiration Removal date
   * @param citrus Whether this is a citrus fruit
   */

  public Fruit(String name, double price, String brand, String description, String expiration, boolean citrus) {
    super(name, price, brand, description, expiration);
    this.citrus = citrus;
  }

  /**
   * Checks citrus status for allergies and storage.
   * @return True if citrus, false otherwise
   */

  public boolean isCitrus() {
    return citrus;
  }

  /**
   * Updates citrus classification when needed.
   * @param citrus New citrus status
   */

  public void setCitrus(boolean citrus) {
    this.citrus = citrus;
  }

  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  @Override
  public String toString() {
    return String.format("%s; Citrus: %b",
    super.toString(), this.isCitrus());
  }
}
