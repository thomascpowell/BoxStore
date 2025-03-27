/**
 * @author Thomas Powell, Dimitiri Montgomery, Taylor Waldo
 * Date: March 27, 2025
 * Section: CSC 331-002
 * Purpose: Define the Laptop class.
 * */

public class Laptop extends ElectronicItem {
  private String processor;

  /**
   * Creates an instance of a Laptop.
   * @param name
   * @param price
   * @param brand
   * @param description
   * @param fragile
   * @param releaseYear
   * @param processor
   * */
  public Laptop(String name, double price, String brand, String description, boolean fragile, int releaseYear, String processor) {
    super(name, price, brand, description, fragile, releaseYear);
    this.processor = processor;
  }

  /**
   * Returns the processor.
   * @return processor
   * */
  public String getProcessor() {
    return processor;
  }

  /**
   * Sets the processor.
   * @param processor The new processor value.
   * */
  public void setProcessor(String processor) {
    this.processor = processor;
  }

  /**
   * Overrides the toString method.
   * @return The string representation.
   * */
  @Override
  public String toString() {
    return String.format("%s; Processor: %s",
    super.toString(), this.getProcessor());
  }

}
