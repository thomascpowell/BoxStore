public class ElectronicItem extends StoreItem {
  
  private int releaseYear;

  public ElectronicItem(String name, double price, boolean fragile, int releaseYear) {
    super(name, price, fragile);
    this.releaseYear = releaseYear;
  }

  public int getReleaseYear() {
    return releaseYear;
  }
  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
}
