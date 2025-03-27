/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the FoodItem class.
 * */

public class FoodItem extends Item {

  public String expiration;

  /**
   *
   * @param name Product name for inventory and shelf labeling
   * @param price Retail value for customer purchase
   * @param brand Manufacturer for product
   * @param description Product details (nutritional information)
   * @param expiration Date when the product should be removed from sale
   */

  public FoodItem(String name, double price, String brand, String description, String expiration) {
    super(name, price, brand, description);
    super.setReturnPolicy(7);
    this.expiration = expiration;
    super.setReturnPolicy(2);
    super.setTax(0.02); // "tax should be different for food items vs non-food items"
  }

  /**
   * Retrieves expiration date to determine product eligibility to remain on shelves
   * @return The expiration date of this food item
   */

  public String getExpiration() {
    return expiration;
  }

  /**
   * Updates expiration date
   * @param expiration The new EXP date for this item
   */

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  @Override
  public String toString() {
    return String.format("%s; Expiration: %s",
    super.toString(), this.getExpiration());
  }
}
