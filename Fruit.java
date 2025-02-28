public class Fruit extends FoodItem {
  
  boolean citrus;

  public Fruit(String name, double price, String expiration, boolean citrus) {
    super(name, price, expiration);
    this.citrus = citrus;
  }

  public boolean isCitrus() {
    return citrus;
  }
  public void setCitrus(boolean citrus) {
    this.citrus = citrus;
  }

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Expiration: %s; Citrus: %b",
    this.getQuantity(), this.getName(), this.getPrice(), this.getExpiration(), this.isCitrus());
  }
}
