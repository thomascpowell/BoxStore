/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the ElectronicItem class.
 * */

public class ElectronicItem extends StoreItem {
  
  private int releaseYear;

  /**
   * Creates an electronic item with an extended 90-day return policy
   * due to the higher defect risk of electronic components.
   *
   * @param name Product name for inventory tracking
   * @param price Current market value
   * @param brand Manufacturer for warranty claims
   * @param description Product features for customer information
   * @param fragile Indicates special handling requirements
   * @param releaseYear Production year for determining support lifecycle
   */

  public ElectronicItem(String name, double price, String brand, String description, boolean fragile, int releaseYear) {
    super(name, price, brand, description, fragile);
    super.setReturnPolicy(90);
    this.releaseYear = releaseYear;
  }

  /**
   * Retrieves product age for depreciation calculations
   * and determining warranty/support status.
   *
   * @return The year this electronic item was released
   */

  public int getReleaseYear() {
    return releaseYear;
  }

  /**
   * Updates release year when correcting inventory errors
   *
   * @param releaseYear The corrected manufacturing year
   */

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
}
