public class StoreItem extends Item {

  private boolean fragile;

  public StoreItem(String name, double price, String brand, String description, boolean fragile) {
    super(name, price, brand, description);
    this.fragile = fragile;
  }

  public boolean isFragile() {return fragile;}

  public void setFragile(boolean fragile) {
    this.fragile = fragile;
  } 
}
