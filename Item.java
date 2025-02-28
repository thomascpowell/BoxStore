public class Item {
  private String name;
  private double price;
  private int quantity;

  public Item(int quantity, String name, double price) {
    this.quantity = quantity;
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }
  public double getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
