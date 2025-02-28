public class FoodItem extends Item {

  public String expiration;

  public FoodItem(String name, double price, String expiration) {
    super(name, price);
    this.expiration = expiration;
  }

  public String getExpiration() {
    return expiration;
  }
  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

}
