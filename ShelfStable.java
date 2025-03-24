public class ShelfStable extends FoodItem {

  private String packaging;

  /**
   * Creates an instance of ShelfStable.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param expiration
   * @param packaging 
   * */
  public ShelfStable(String name, double price, String brand, String description, String expiration, String packaging) {
    super(name, price, brand, description, expiration);
    this.packaging = packaging;
  }

  /**
   * Returns packaging.
   * @return packaging
   * */
  public String getPackaging() {
    return packaging;
  }

  /**
   * Sets the packaging.
   * @param packaging The new packaging value.
   * */
  public void setPackaging(String packaging) {
    this.packaging = packaging;
  }
}
