package cs3500.set.model.hw02;

/**
 * This class creates a Cart for the game Set.
 */
public class Card {
  public Count count;
  public Filling filling;
  public Shape shape;


  /**
   * This creates a Card using given count, filling and shape.
   *
   * @param count   is the number attribute of the card
   * @param filling is the filling attribute of the card
   * @param shape   is the shape attribute of the card
   * @throws IllegalArgumentException if invalid argument
   */
  public Card(Count count, Filling filling, Shape shape) throws IllegalArgumentException {
    if (count == null || count.getCount() != 1
            && count.getCount() != 2
            && count.getCount() != 3
            || filling == null || filling.getFilling() != ('E')
                    && filling.getFilling() != ('S')
                    && filling.getFilling() != ('F')
            || shape == null || shape.getShape() != ('O')
                    && shape.getShape() != ('Q')
                    && shape.getShape() != ('D')) {
      throw new IllegalArgumentException("not a valid card");
    }

    this.count = count;
    this.filling = filling;
    this.shape = shape;
  }

  /**
   * The methods returns the string representation of a card with its attributes.
   * @return string which is the representation of a card.
   */

  public String toString() {

    return count.getCount() + "" + filling.getFilling() + "" + shape.getShape();
  }
}

//Arrays.asList(dbase.getPlushNamesByType(type))




