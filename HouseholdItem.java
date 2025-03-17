public class HouseholdItem extends StoreItem {

  private String material;

  public HouseholdItem(String name, double price, String brand, String description, boolean fragile, String material) {
    super(name, price, brand, description, fragile);
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
