public class Item {

  private String name;
  private double price;
  private String brand;
  private String description;
  private int quantity;
  private int returnPolicy;
  private double tax;

  public Item(String name, double price, String brand, String description) {
    this.quantity = 1;
    this.returnPolicy = 30;
    this.tax = 0.04;
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
  public double getTax() {
    return tax;
  }
  public String getBrand() {
    return brand;
  }
  public String getDescription() {
    return description;
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
  public void setTax(double tax) {
    this.tax = tax;
  }
  public void setBrand(String brand) {
    this.brand = brand;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    return this.getName().equals(((Item)obj).getName());
  }
}
