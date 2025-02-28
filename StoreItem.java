public class StoreItem extends Item {
  private boolean fragile;


  public StoreItem(String name, double price, boolean fragile) {
    super(name, price);
    this.fragile = fragile;
  }

  public boolean isFragile() {
    return fragile;
  }

  public void setFragile(boolean fragile) {
    this.fragile = fragile;
  } 

  public String toString() {
    return this.getName() + ", " + this.getPrice() + ", " + this.isFragile();
  }
}
