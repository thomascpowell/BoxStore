/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the Shoe class.
 * */

public class Shoe extends Outerwear {

  boolean hightop;

  /**
   * Creates an instance of Shoe.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param fragile
   * @param size
   * @param hightop
   * */
  public Shoe(String name, double price, String brand, String description, boolean fragile, int size, boolean hightop) {
    super(name, price, brand, description, fragile, size);
    this.hightop = hightop;
  }

  /**
   * Returns hightop.
   * @return hightop
   * */
  public boolean isHightop() {
    return hightop;
  }

  /**
   * Sets hightop.
   * @param hightop The new hightop value.
   * */
  public void setHightop(boolean hightop) {
    this.hightop = hightop;
  }

  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  @Override
  public String toString() {
    return String.format("%s; Hightop: %b",
    super.toString(), this.isHightop());
  }
}
