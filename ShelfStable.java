public class ShelfStable extends FoodItem {

  private String packaging;

  public ShelfStable(String name, double price, String expiration, String packaging) {
    super(name, price, expiration);
    this.packaging = packaging;
  }

  public String getPackaging() {
    return packaging;
  }
  public void setPackaging(String packaging) {
    this.packaging = packaging;
  }

}
