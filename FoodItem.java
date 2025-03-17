public class FoodItem extends Item {

  public String expiration;

  public FoodItem(String name, double price, String brand, String description, String expiration) {
    super(name, price, brand, description);
    super.setReturnPolicy(7);
    this.expiration = expiration;
    super.setReturnPolicy(2);
  }

  public String getExpiration() {
    return expiration;
  }
  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }
}
