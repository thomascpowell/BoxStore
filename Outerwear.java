public class Outerwear extends StoreItem {

  private int size;

  /**
   * Creates an instance of an Outerwear.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param fragile
   * @param size
   * */
  public Outerwear(String name, double price, String brand, String description, boolean fragile, int size) {
    super(name, price, brand, description, fragile);
    this.size = size;
  }

  /**
   * Returns the size.
   * @return size
   * */
  public int getSize() {
    return size;
  }

  /**
   * Sets the size.
   * @param size The new size value.
   * */
  public void setSize(int size) {
    this.size = size;
  }

}
