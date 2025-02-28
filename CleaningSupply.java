public class CleaningSupply extends HouseholdItem {
 
  private boolean sprayBottle;

  public CleaningSupply(int quantity, String name, double price, boolean fragile, String material, boolean sprayBottle) {
    super(name, price, fragile, material);
    this.sprayBottle = sprayBottle;
  }

  public boolean isSprayBottle() {
    return sprayBottle;
  }
  public void setSprayBottle(boolean sprayBottle) {
    this.sprayBottle = sprayBottle;
  }

}
