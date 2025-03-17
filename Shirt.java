public class Shirt extends Outerwear {

  private String color;

  public Shirt(String name, double price, String brand, String description, boolean fragile, int size, String color) {
    super(name, price, brand, description, fragile, size);
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String toString() {
    return String.format("Quantity: %d; Name: %s; Price: %.2f; Fragile: %b; Size: %d; Color: %s",
    this.getQuantity(), this.getName(), this.getPrice(), this.isFragile(), this.getSize(), this.getColor());
  }
}
