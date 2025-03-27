/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the Vegetable class.
 * */

public class Vegetable extends FoodItem {
  
  private boolean green;

  /**
   * Creates an instance of Vegetable.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param expiration
   * @param green
   * */
  public Vegetable(String name, double price, String brand, String description, String expiration, boolean green) {
    super(name, price, brand, description, expiration);
    this.green = green;
  }

  /**
   * Returns green.
   * @return green
   * */
  public boolean isGreen() {
    return green;
  }

  /**
   * Sets green.
   * @param green New green value.
   * */
  public void setGreen(boolean green) {
    this.green = green;
  }

  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  @Override
  public String toString() {
    return String.format("%s; Green: %b",
    super.toString(), this.isGreen());
  }
}
