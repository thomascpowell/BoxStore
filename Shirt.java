/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the Shirt class.
 * */

public class Shirt extends Outerwear {

  private String color;

  /**
   * Creates an instance of Shoe.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param fragile
   * @param size
   * @param color
   * */
  public Shirt(String name, double price, String brand, String description, boolean fragile, int size, String color) {
    super(name, price, brand, description, fragile, size);
    this.color = color;
  }

  /**
   * Returns color.
   * @return color
   * */
  public String getColor() {
    return color;
  }

  /**
   * Sets the color.
   * @param color The new color value.
   * */
  public void setColor(String color) {
    this.color = color;
  }


  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  @Override
  public String toString() {
    return String.format("%s; Color: %s",
    super.toString(), this.getColor());
  }

}
