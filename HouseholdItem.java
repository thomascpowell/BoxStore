/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the HouseholdItem class.
 * */

public class HouseholdItem extends StoreItem {

  private String material;

  /**
   * Creates a household item with a standard 30-day return policy.
   *
   * @param name Item name for inventory
   * @param price Retail price
   * @param brand Manufacturer
   * @param description Product details
   * @param fragile Handling requirement flag
   * @param material Primary material of construction
   */

  public HouseholdItem(String name, double price, String brand, String description, boolean fragile, String material) {
    super(name, price, brand, description, fragile);
    super.setReturnPolicy(30);
    this.material = material;
  }

  /**
   * Retrieves material type for care instructions.
   *
   * @return Material composition
   */

  public String getMaterial() {
    return material;
  }

  /**
   * Updates material information when needed.
   *
   * @param material New material description
   */

  public void setMaterial(String material) {
    this.material = material;
  }

  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  @Override
  public String toString() {
    return String.format("%s; Material: %s",
    super.toString(), this.getMaterial());
  }
}
