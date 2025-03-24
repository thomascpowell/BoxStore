/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the StoreItem class.
 * */

public class StoreItem extends Item {

  private boolean fragile;

  /**
   * Creates an instance of StoreItem.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param fragile
   * */
  public StoreItem(String name, double price, String brand, String description, boolean fragile) {
    super(name, price, brand, description);
    this.fragile = fragile;
  }

  /**
   * Returns fragile.
   * @return fragile
   * */
  public boolean isFragile() {
    return fragile;
  }

  /**
   * Sets fragile.
   * @param fragile New fragile value.
   * */
  public void setFragile(boolean fragile) {
    this.fragile = fragile;
  } 
}
