public class ElectronicItem extends StoreItem {
  
  private int releaseYear;

  public ElectronicItem(String name, double price, String brand, String description, boolean fragile, int releaseYear) {
    super(name, price, brand, description, fragile);
    super.setReturnPolicy(90);
    this.releaseYear = releaseYear;
  }

  public int getReleaseYear() {
    return releaseYear;
  }
  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
}
