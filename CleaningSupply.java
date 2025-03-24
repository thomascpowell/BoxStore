/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the CleaningSupply class.
 * */

public class CleaningSupply extends HouseholdItem {
 
  private boolean sprayBottle;

  public CleaningSupply(String name, double price, String brand, String description, boolean fragile, String material, boolean sprayBottle) {
    super(name, price, brand, description, fragile, material);
    this.sprayBottle = sprayBottle;
  }

  /**
   * Returns sprayBottle.
   * @return 
   * */
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
