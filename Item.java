public class Item {

  private String name;
  private double price;
  private String brand;
  private String description;
  private int quantity;
  private int returnPolicy;
  private double tax;


  /**
   * Creates an instance of Item.
   * @param name
   * @param price
   * @param brand
   * @param description
   * */
  public Item(String name, double price, String brand, String description) {
    this.quantity = 1;
    this.returnPolicy = 30;
    this.tax = 0.04;
    this.name = name;
    this.price = price;
    this.brand = brand;
    this.description = description;
  }

  /**
   * Returns the name.
   * @return name
   * */
  public String getName() {
    return name;
  }

  /**
   * Returns the price.
   * @return price
   * */
  public double getPrice() {
    return price;
  }

  /**
   * Returns the quantity.
   * @return quantity
   * */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Returns the returnPolicy.
   * @return returnPolicy
   * */
  public int getReturnPolicy() {
    return returnPolicy;
  }

  /**
   * Returns the tax.
   * @return tax
   * */
  public double getTax() {
    return tax;
  }

  /**
   * Returns the brand.
   * @return brand
   * */
  public String getBrand() {
    return brand;
  }

  /**
   * Returns the description.
   * @return description
   * */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the name.
   * @param name The new name.
   * */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the price.
   * @param price The new price.
   * */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * Sets the quantity.
   * @param quantity The new quantity.
   * */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Sets the returnPolicy.
   * @param returnPolicy The new returnPolicy.
   * */
  public void setReturnPolicy(int returnPolicy) {
    this.returnPolicy = returnPolicy;
  }

  /**
   * Sets the tax.
   * @param tax The new tax.
   * */
  public void setTax(double tax) {
    this.tax = tax;
  }

  /**
   * Sets the brand.
   * @param brand The new brand.
   * */
  public void setBrand(String brand) {
    this.brand = brand;
  }

  /**
   * Sets the description.
   * @param description The new description.
   * */
  public void setDescription(String description) {
    this.description = description;
  }
  
  /**
   * Compares Items based on class and name.
   * @return The truth value.
   * */
  @Override
  public boolean equals(Object obj) {
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    return this.getName().equals(((Item)obj).getName());
  }
}
