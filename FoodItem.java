/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the FoodItem class.
 * */

public class FoodItem extends Item {

  public String expiration;

  public FoodItem(String name, double price, String brand, String description, String expiration) {
    super(name, price, brand, description);
    super.setReturnPolicy(7);
    this.expiration = expiration;
    super.setReturnPolicy(2);
    super.setTax(0.02); // "tax should be different for food items vs non-food items"
  }

  public String getExpiration() {
    return expiration;
  }
  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }
}
