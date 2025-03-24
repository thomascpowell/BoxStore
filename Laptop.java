public class Laptop extends ElectronicItem {
  private String processor;

  /**
   * Creates an instance of a Laptop.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param fragile
   * @param releaseYear
   * @param processor
   * */
  public Laptop(String name, double price, String brand, String description, boolean fragile, int releaseYear, String processor) {
    super(name, price, brand, description, fragile, releaseYear);
    this.processor = processor;
  }

  /**
   * Returns the processor.
   * @return processor
   * */
  public String getProcessor() {
    return processor;
  }

  /**
   * Sets the processor.
   * @param processor The new processor value.
   * */
  public void setProcessor(String processor) {
    this.processor = processor;
  }

  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Fragile: %b; Release: %d; Processor: %s",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getReleaseYear(), this.getProcessor());
  }
}
