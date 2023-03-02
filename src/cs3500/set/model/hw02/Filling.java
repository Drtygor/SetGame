package cs3500.set.model.hw02;

/**
 * This enum instantiates the different Filling attributes of a card.
 */
public enum Filling {
  empty('E'),
  striped('S'),
  full('F');

  private final char fill;
  Filling(char fill) {
    this.fill = fill;
  }

  public char getFilling() {
    return fill;
  }

}
