public class Shoe extends Outerwear {

  boolean hightop;

  public Shoe(String name, double price, boolean fragile, int size, boolean hightop) {
    super(name, price, fragile, size);
    this.hightop = hightop;
  }

  public boolean isHightop() {
    return hightop;
  }
  public void setHightop(boolean hightop) {
    this.hightop = hightop;
  }
}
