public class Item {
  private String name;
  private double price;
  private int quantity;
  private int returnPolicy;

  public Item(String name, double price) {
    this.quantity = 1; // for use in WQS class
    this.returnPolicy = 30; // default 30 days, for use in sellItem
    this.name = name;
    this.price = price;
  
  }

  public String getName() {
    return name;
  }
  public double getPrice() {
    return price;
  }
  public int getQuantity() {
    return quantity;
  }
  public int getReturnPolicy() {
    return returnPolicy;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public void setReturnPolicy(int returnPolicy) {
    this.returnPolicy = returnPolicy;
  }
}
