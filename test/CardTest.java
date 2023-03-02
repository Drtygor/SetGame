import org.junit.Test;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Count;
import cs3500.set.model.hw02.Filling;
import cs3500.set.model.hw02.Shape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class is for testing the Card class.
 */
public class CardTest {

  Card c1 = new Card(Count.one, Filling.empty, Shape.oval);
  Card c2 = new Card(Count.two, Filling.striped, Shape.squiggle);
  Card c3 = new Card(Count.three, Filling.full, Shape.diamond);

  @Test
  public void testInvalidConstructor() {

    try {
      new Card(Count.one, Filling.empty, null);
      fail("not a valid card");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      new Card(Count.one, null, Shape.oval);
      fail("not a valid card");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      new Card(null, Filling.empty, Shape.oval);
      fail("not a valid card");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  @Test
  public void testToString() {
    assertEquals("1EO", c1.toString());
    assertEquals("2SQ", c2.toString());
    assertEquals("3FD", c3.toString());

  }


}