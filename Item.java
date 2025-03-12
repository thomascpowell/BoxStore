public class Item {
  private String name;
  private double price;
  private int quantity;
  private int returnPolicy;
  private String brand;
  private String description;

  public Item(String name, double price, int quantity, int returnPolicy, String brand, String description) {
    this.quantity = 1; // for use in WQS class
    this.returnPolicy = 30; // default 30 days, for use in sellItem
    this.name = name;
    this.price = price;
    this.brand = brand;
    this.description = description;
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
  public String getBrand() {return brand;}
  public String getDescription() {return description;}
  /// //


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
  public void setBrand(String brand) {this.brand = brand;}
  public void setDescription(String description) {this.description = description;}
}
