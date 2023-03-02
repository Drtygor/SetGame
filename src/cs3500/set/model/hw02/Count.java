package cs3500.set.model.hw02;

/**
 * This enum instantiates the different Count attributes of a card.
 */
public enum Count {
  one(1),
  two(2),
  three(3);

  private final int num;

  Count(int num) {
    this.num = num;
  }

  public int getCount() {
    return num;
  }

}
