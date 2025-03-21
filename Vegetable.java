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
   * */
  public boolean isGreen() {
    return green;
  }

  /**
   * Sets green.
   * @param green New green truth value.
   * */
  public void setGreen(boolean green) {
    this.green = green;
  }

  /**
   * Returns all parameters in a String.
   * */
  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Expiration: %s; Green: %b",
    this.getQuantity(), this.getName(), this.getPrice(), this.getExpiration(), this.isGreen());
  }
}
