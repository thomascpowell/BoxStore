public class Vegetable extends FoodItem {
  
  private boolean green;

  public Vegetable(String name, double price, String expiration, boolean green) {
    super(name, price, expiration);
    this.green = green;
  }

  public boolean isGreen() {
    return green;
  }
  public void setGreen(boolean green) {
    this.green = green;
  }

}
