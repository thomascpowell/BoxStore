public class ShelfStable extends FoodItem {

  private String packaging;

  public ShelfStable(String name, double price, String brand, String description, String expiration, String packaging) {
    super(name, price, brand, description, expiration);
    this.packaging = packaging;
  }

  public String getPackaging() {
    return packaging;
  }

  public void setPackaging(String packaging) {
    this.packaging = packaging;
  }


  //I like dudes


}
