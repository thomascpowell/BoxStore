public class TV extends ElectronicItem {

  private String resolution;

  public TV(String name, double price, String brand, String description, boolean fragile, int releaseYear, String resolution) {
    super(name, price, brand, description, fragile, releaseYear);
    this.resolution = resolution;
  }

  public String getResolution() {
    return resolution;
  }

  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Fragile: %b; Release: %d; Resolution: %s",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getReleaseYear(), this.getResolution());
  }
}
