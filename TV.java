/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the TV class.
 * */

public class TV extends ElectronicItem {

  private String resolution;
  
  /**
   * Creates an instance of a TV.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param fragile
   * @param releaseYear
   * @param resolution
   * */
  public TV(String name, double price, String brand, String description, boolean fragile, int releaseYear, String resolution) {
    super(name, price, brand, description, fragile, releaseYear);
    this.resolution = resolution;
  }

  /**
   * Returns the resolution.
   * @return resolution
   * */
  public String getResolution() {
    return resolution;
  }

  /**
   * Sets the resolution.
   * @param resolution The new resolution.
   * */
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Fragile: %b; Release: %d; Resolution: %s",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getReleaseYear(), this.getResolution());
  }
}
