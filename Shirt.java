public class Shirt extends Outerwear {

  private String color;

  public Shirt(String name, double price, boolean fragile, int size, String color) {
    super(name, price, fragile, size);
    this.color = color;
  }

  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }
}
