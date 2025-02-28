public class Furniture extends HouseholdItem {
  private int legs;

  public Furniture(String name, double price, boolean fragile, String material, int legs) {
    super(name, price, fragile, material);
    this.legs = legs;
  }

  public int getLegs() {
    return legs;
  }
  public void setLegs(int legs) {
    this.legs = legs;
  }

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Fragile: %b; Material: %s; Legs: %d",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getMaterial(), this.getLegs());
  }
}
