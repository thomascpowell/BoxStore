public class Phone extends ElectronicItem {
  private String formFactor;

  public Phone(String name, double price, boolean fragile, int releaseYear, String formFactor) {
    super(name, price, fragile, releaseYear);
    this.formFactor = formFactor;
  }

  public String getFormFactor() {
    return formFactor;
  }
  public void setFormFactor(String formFactor) {
    this.formFactor = formFactor;
  }
}

