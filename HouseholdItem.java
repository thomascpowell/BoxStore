public class HouseholdItem extends StoreItem {

  private String material;

  public HouseholdItem(String name, double price, boolean fragile, String material) {
    super(name, price, fragile);
    super.setReturnPolicy(30);
    this.material = material;
  }

  public String getMaterial() {
    return material;
  }
  public void setMaterial(String material) {
    this.material = material;
  }
}
