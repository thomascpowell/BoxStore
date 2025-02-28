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
}
