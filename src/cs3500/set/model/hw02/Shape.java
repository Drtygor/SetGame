package cs3500.set.model.hw02;

/**
 * This enum instantiates the different Shape attributes of a card.
 */
public enum Shape {
  oval('O'),
  squiggle('Q'),
  diamond('D');

  private final char form;
  Shape(char form) {
    this.form = form;
  }

  public char getShape() {
    return form;
  }

}
