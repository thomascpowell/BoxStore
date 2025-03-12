public class Shoe extends Outerwear {

  boolean hightop;

  public Shoe(String name, double price, String brand, String description, boolean fragile, int size, boolean hightop) {
    super(name, price, brand, description, fragile, size);
    this.hightop = hightop;
  }

  public boolean isHightop() {
    return hightop;
  }
  public void setHightop(boolean hightop) {
    this.hightop = hightop;
  }
  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Fragile: %b; Size: %d; Hightop: %b",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getSize(), this.isHightop());
  }
}
