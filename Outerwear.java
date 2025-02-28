public class Outerwear extends StoreItem {

  private int size;

  public Outerwear(String name, double price, boolean fragile, int size) {
    super(name, price, fragile);
    this.size = size;
  }

  public int getSize() {
    return size;
  }
  public void setSize(int size) {
    this.size = size;
  }

}
