public class Laptop extends ElectronicItem {
  private String processor;

  public Laptop(String name, double price, boolean fragile, int releaseYear, String processor) {
    super(name, price, fragile, releaseYear);
    this.processor = processor;
  }

  public String getProcessor() {
    return processor;
  }
  public void setProcessor(String processor) {
    this.processor = processor;
  }
}
