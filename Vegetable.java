public class Vegetable extends FoodItem {
  
  private boolean green;

  public Vegetable(String name, double price, String brand, String description, String expiration, boolean green) {
    super(name, price, brand, description, expiration);
    this.green = green;
  }

  public boolean isGreen() {
    return green;
  }

  public void setGreen(boolean green) {
    this.green = green;
  }

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Expiration: %s; Green: %b",
    this.getQuantity(), this.getName(), this.getPrice(), this.getExpiration(), this.isGreen());
  }
}
