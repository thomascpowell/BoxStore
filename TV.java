public class TV extends ElectronicItem {
  private String resolution;

  public TV(String name, double price, boolean fragile, int releaseYear, String resolution) {
    super(name, price, fragile, releaseYear);
    this.resolution = resolution;
  }

  public String getProcessor() {
    return resolution;
  }
  public void setProcessor(String resolution) {
    this.resolution = resolution;
  }
}
