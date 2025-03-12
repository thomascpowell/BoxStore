public class CleaningSupply extends HouseholdItem {
 
  private boolean sprayBottle;

  public CleaningSupply(String name, double price, String brand, String description, boolean fragile, String material, boolean sprayBottle) {
    super(name, price, brand, description, fragile, material);
    this.sprayBottle = sprayBottle;
  }

  public boolean isSprayBottle() {
    return sprayBottle;
  }
  public void setSprayBottle(boolean sprayBottle) {
    this.sprayBottle = sprayBottle;
  }

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %d; Fragile: %b; Material: %s; Spray Bottle: %b",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getMaterial(), this.isSprayBottle());
  }
}
