public class Fruit extends FoodItem {
  
  boolean citric;

  public Fruit(String name, double price, String expiration, boolean citric) {
    super(name, price, expiration);
    this.citric = citric;
  }

  public boolean isCitric() {
    return citric;
  }
  public void setCitric(boolean citric) {
    this.citric = citric;
  }
}
