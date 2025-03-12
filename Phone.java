public class Phone extends ElectronicItem {
  private String formFactor;

  public Phone(String name, double price, String brand, String description, boolean fragile, int releaseYear, String formFactor) {
    super(name, price, brand, description, fragile, releaseYear);
    this.formFactor = formFactor;
  }

  public String getFormFactor() {
    return formFactor;
  }
  public void setFormFactor(String formFactor) {
    this.formFactor = formFactor;
  }

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Fragile: %b; Release: %d; Form Factor: %s",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getReleaseYear(), this.getFormFactor());
  }
}

