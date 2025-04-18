/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the Phone class.
 * */

public class Phone extends ElectronicItem {
  private String formFactor;

  /**
   * Creates an instance of a Phone.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param fragile
   * @param releaseYear
   * @param formFactor
   * */
  public Phone(String name, double price, String brand, String description, boolean fragile, int releaseYear, String formFactor) {
    super(name, price, brand, description, fragile, releaseYear);
    this.formFactor = formFactor;
  }

  /**
   * Returns form factor.
   * @return formFactor
   * */
  public String getFormFactor() {
    return formFactor;
  }

  /**
   * Sets the form factor.
   * @param formFactor The new formFactor value.
   * */
  public void setFormFactor(String formFactor) {
    this.formFactor = formFactor;
  }

  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  @Override
  public String toString() {
    return String.format("%s; Form Factor: %s",
    super.toString(), this.getFormFactor());
  }
}

