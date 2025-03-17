public class Laptop extends ElectronicItem {
  private String processor;

  public Laptop(String name, double price, String brand, String description, boolean fragile, int releaseYear, String processor) {
    super(name, price, brand, description, fragile, releaseYear);
    this.processor = processor;
  }

  public String getProcessor() {
    return processor;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Fragile: %b; Release: %d; Processor: %s",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getReleaseYear(), this.getProcessor());
  }
}
