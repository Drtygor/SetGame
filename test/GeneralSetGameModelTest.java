import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.Count;
import cs3500.set.model.hw02.Filling;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.Shape;
import cs3500.set.model.hw03.GeneralSetGameModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * This class tests for the GeneralSetGameModel.
 */

public class GeneralSetGameModelTest extends AbstractSetGameTests {

  GeneralSetGameModel model = new GeneralSetGameModel();

  /*
  Card c1 = new Card(Count.one, Filling.full, Shape.squiggle);
  Card c2 = new Card(Count.one, Filling.empty, Shape.diamond);
  Card c3 = new Card(Count.three, Filling.striped, Shape.squiggle);
  Card c4 = new Card(Count.two, Filling.striped, Shape.oval);
  Card c5 = new Card(Count.two, Filling.empty, Shape.diamond);
  Card c6 = new Card(Count.three, Filling.full, Shape.oval);
  Card c7 = new Card(Count.one, Filling.empty, Shape.oval);
  Card c8 = new Card(Count.two, Filling.striped, Shape.squiggle);
  Card c9 = new Card(Count.three, Filling.full, Shape.diamond);
  Card c10 = new Card(Count.one, Filling.full, Shape.oval);
  Card c11 = new Card(Count.two, Filling.striped, Shape.diamond);
  Card c12 = new Card(Count.three, Filling.empty, Shape.squiggle);
*/

  Card c1 = new Card(Count.one, Filling.empty, Shape.oval);
  Card c2 = new Card(Count.one, Filling.empty, Shape.squiggle);
  Card c3 = new Card(Count.one, Filling.empty, Shape.diamond);
  Card c4 = new Card(Count.one, Filling.striped, Shape.oval);
  Card c5 = new Card(Count.one, Filling.striped, Shape.squiggle);
  Card c6 = new Card(Count.one, Filling.striped, Shape.diamond);
  Card c7 = new Card(Count.one, Filling.full, Shape.oval);
  Card c8 = new Card(Count.one, Filling.full, Shape.squiggle);
  Card c9 = new Card(Count.one, Filling.full, Shape.diamond);


  Card c10 = new Card(Count.two, Filling.empty, Shape.oval);
  Card c11 = new Card(Count.two, Filling.empty, Shape.squiggle);
  Card c12 = new Card(Count.two, Filling.empty, Shape.diamond);
  Card c13 = new Card(Count.two, Filling.striped, Shape.oval);
  Card c14 = new Card(Count.two, Filling.striped, Shape.squiggle);
  Card c15 = new Card(Count.two, Filling.striped, Shape.diamond);
  Card c16 = new Card(Count.two, Filling.full, Shape.oval);
  Card c17 = new Card(Count.two, Filling.full, Shape.squiggle);
  Card c18 = new Card(Count.two, Filling.full, Shape.diamond);


  Card c19 = new Card(Count.three, Filling.empty, Shape.oval);
  Card c20 = new Card(Count.three, Filling.empty, Shape.squiggle);
  Card c21 = new Card(Count.three, Filling.empty, Shape.diamond);
  Card c22 = new Card(Count.three, Filling.striped, Shape.oval);
  Card c23 = new Card(Count.three, Filling.striped, Shape.squiggle);
  Card c24 = new Card(Count.three, Filling.striped, Shape.diamond);
  Card c25 = new Card(Count.three, Filling.full, Shape.oval);
  Card c26 = new Card(Count.three, Filling.full, Shape.squiggle);
  Card c27 = new Card(Count.three, Filling.full, Shape.diamond);


  //1EO, 1EQ, 1ED, 1SO, 1SQ, 1SD, 1FO, 1FQ, 1FD,
  // 2EO, 2EQ, 2ED, 2SO, 2SQ, 2SD, 2FO, 2FQ, 2FD,
  // 3EO, 3EQ, 3ED, 3SO, 3SQ, 3SD, 3FO, 3FQ, 3FD

  ArrayList<Card> m = new ArrayList<Card>();
  ArrayList<Card> d = new ArrayList<Card>();
  ArrayList<Card> de = new ArrayList<Card>();
  ArrayList<Card> dec = new ArrayList<Card>();
  ArrayList<Card> deck = new ArrayList<Card>();
  ArrayList<Card> deck0 = new ArrayList<Card>();
  ArrayList<Card> deck1 = new ArrayList<Card>();
  ArrayList<Card> deck2 = new ArrayList<Card>();
  ArrayList<Card> deck3 = new ArrayList<Card>();
  ArrayList<Card> deck4 = new ArrayList<Card>();
  ArrayList<Card> deck5 = new ArrayList<Card>();


  Coord one = new Coord(0, 0);
  Coord two = new Coord(0, 1);
  Coord three = new Coord(0, 2);
  Coord four = new Coord(1, 0);
  Coord five = new Coord(1, 1);
  Coord six = new Coord(1, 2);
  Coord seven = new Coord(2, 0);
  Coord eight = new Coord(2, 1);
  Coord nine = new Coord(2, 2);

  Coord offgrid = new Coord(-5, 0);
  Coord offgrid1 = new Coord(28, 0);
  Coord offgrid2 = new Coord(0, -5);
  Coord offgrid3 = new Coord(0, 28);


  @Before
  public void make() {
    m = new ArrayList<Card>();
    m.add(c1);
    m.add(c2);
  }


  @Before
  public void makeD() {
    d = new ArrayList<Card>();
    d.add(c1);
    d.add(c2);
    d.add(c3);
  }

  @Before
  public void makeDe() {
    de = new ArrayList<Card>();
    de.add(c1);
    de.add(c2);
    de.add(c3);
    de.add(c4);
    de.add(c5);
    de.add(c6);
  }


  @Before
  public void makeDec() {
    dec = new ArrayList<Card>();
    dec.add(c1);
    dec.add(c2);
    dec.add(c3);
    dec.add(c4);
    dec.add(c5);
    dec.add(c6);
    dec.add(c7);
    dec.add(c8);
    dec.add(c9);
  }

  @Before
  public void makeDeck() {
    deck = new ArrayList<Card>();
    deck.add(c1);
    deck.add(c2);
    deck.add(c3);
    deck.add(c4);
    deck.add(c5);
    deck.add(c6);
    deck.add(c7);
    deck.add(c8);
    deck.add(c9);
    deck.add(c10);
    deck.add(c11);
    deck.add(c12);
    deck.add(c13);
    deck.add(c14);
    deck.add(c15);
    deck.add(c16);
    deck.add(c17);
    deck.add(c18);
    deck.add(c19);
    deck.add(c20);
    deck.add(c21);
    deck.add(c22);
    deck.add(c23);
    deck.add(c24);
    deck.add(c25);
    deck.add(c26);
    deck.add(c27);
  }

  @Before
  public void makeDeck0() {
    deck0 = new ArrayList<Card>();
    deck0.add(c10);
    deck0.add(c11);
    deck0.add(c12);
    deck0.add(c13);
    deck0.add(c14);
    deck0.add(c15);
    deck0.add(c16);
    deck0.add(c17);
    deck0.add(c18);
    deck0.add(c19);
    deck0.add(c20);
    deck0.add(c21);
    deck0.add(c22);
    deck0.add(c23);
    deck0.add(c24);
    deck0.add(c25);
    deck0.add(c26);
    deck0.add(c27);
  }


  @Before
  public void makeDeck1() {
    deck1 = new ArrayList<Card>();
    deck1.add(c1);
    deck1.add(c2);
  }

  @Before
  public void makeDeck2() {
    deck2 = new ArrayList<Card>();
    deck2.add(c1);
    deck2.add(c2); //not a set
    deck2.add(c4);

    deck2.add(c22);
    deck2.add(c23); //set
    deck2.add(c24);

    deck2.add(c3);
    deck2.add(c25); // not a set
    deck2.add(c12);

    deck2.add(c19);
    deck2.add(c20); //set
    deck2.add(c21);
  }

  @Before
  public void makeDeck3() {
    deck3 = new ArrayList<Card>();
    deck3.add(c1);
    deck3.add(c2); //not a set
    deck3.add(c4);
    deck3.add(c19);
    deck3.add(c20); //set
    deck3.add(c21);
    deck3.add(c10);
    deck3.add(c11); //not a set
    deck3.add(c13);

  }

  @Before
  public void makeDeck4() {
    deck4 = new ArrayList<Card>();
    deck4.add(c22);
    deck4.add(c23); //set
    deck4.add(c24);

    deck4.add(c3);
    deck4.add(c25); // not a set
    deck4.add(c12);

    deck4.add(c1);
    deck4.add(c2); //not a set
    deck4.add(c4);
  }


  @Before
  public void makeDeck5() {
    deck5 = new ArrayList<Card>();
    deck5.add(c1);
    deck5.add(c2); //not a set
    deck5.add(c7);

    deck5.add(c19);
    deck5.add(c20); //set
    deck5.add(c21);

    deck5.add(c3);
    deck5.add(c5); //not a set
    deck5.add(c23);

    deck5.add(c27);
    deck5.add(c25); //not a set
    deck5.add(c14);

    deck5.add(c10);
    deck5.add(c11); //set
    deck5.add(c12);


  }


  @Override
  protected SetGameModel<Card> getModel() {
    return new GeneralSetGameModel();
  }

  /*
  @Test
  public void testAddRow() {
    model.startGameWithDeck(model.getCompleteDeck(), 4,4);
    assertEquals(4, model.getHeight());
    model.addRow();
    assertEquals(5, model.getHeight());
  }

  @Test
  public void testAddingRow() {
    model.startGameWithDeck(deck4, 1, 3);
    assertEquals(1, model.getHeight());
    model.addingRows();
    assertEquals(3, model.getHeight());
    assertTrue(model.isGameOver());
  }

  */


  @Test
  public void testClaimSet() {


    //if not enough cards in deck to replace valid set
    try {
      model.startGameWithDeck(dec, 3, 3);
      //assertTrue(model.isGameOver());
      model.claimSet(one, two, three);
      assertTrue(model.isGameOver());
      //fail("game has ended");
    } catch (IllegalStateException e) {
      //do nothing
    }


    //not a set on grid
    model.startGameWithDeck(deck3, 1, 3);
    //new row added to grid
    assertEquals(2, model.getHeight());


    GeneralSetGameModel model = new GeneralSetGameModel();

    //playing entire game through with bigger grid
    //always a set on every state
    model.startGameWithDeck(deck, 3, 4);
    assertTrue(model.anySetsPresent());
    assertEquals(3, model.getHeight());
    assertFalse(model.isGameOver());

    model.claimSet(one, two, three);
    assertEquals(3, model.getHeight());
    assertEquals(1, model.getScore());
    assertTrue(model.anySetsPresent());
    model.claimSet(one, two, three);
    assertEquals(3, model.getHeight());
    assertEquals(2, model.getScore());
    assertTrue(model.anySetsPresent());
    model.claimSet(one, two, three);
    assertEquals(3, model.getHeight());
    assertEquals(3, model.getScore());
    assertTrue(model.anySetsPresent());
    model.claimSet(one, two, three);
    assertEquals(3, model.getHeight());
    assertEquals(4, model.getScore());
    assertTrue(model.anySetsPresent());
    model.claimSet(one, two, three);
    assertEquals(3, model.getHeight());
    assertEquals(5, model.getScore());
    assertTrue(model.anySetsPresent());
    model.claimSet(one, two, three);
    assertEquals(3, model.getHeight());
    assertEquals(6, model.getScore());
    assertTrue(model.anySetsPresent());

    try {
      model.claimSet(one, two, three);

      System.out.println("hi");
      assertEquals(7, model.getScore());
      assertTrue(model.anySetsPresent());
      assertTrue(model.isGameOver());

    } catch (IllegalStateException e) {
      //do nothing
    }

  }


  @Test
  public void testStartGameWithDeck() {

    //if deck is null
    try {
      model.startGameWithDeck(null, 5, 5);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    //if deck is invalid size, too small for height and width
    try {
      model.startGameWithDeck(m, 5, 4);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }




    //start game no grids need to add
    model.startGameWithDeck(deck2, 2, 3);
    assertEquals(2, model.getHeight());

    //set claimed and replaced with not a set
    //next one isn't a set either so three cards to form new row
    model.claimSet(four, five, six);
    assertEquals(2, model.getHeight());


    //start game need grid need to add
    model.startGameWithDeck(deck3, 1, 3);
    assertEquals(2, model.getHeight());

    //claim on larger board
    model.startGameWithDeck(deck, 4, 4);
    model.claimSet(one, two, three);
    assertEquals(4, model.getHeight());

    //////////////


    // invalid grid for deck size, fault of width
    try {
      model.startGameWithDeck(d, 0, 1);
      fail("invalid arguments");
    } catch (IllegalArgumentException e) {
      //do nothing
    }


    // invalid grid for deck size, fault of height
    try {
      model.startGameWithDeck(d, 1, 0);
      fail("invalid arguments");
    } catch (IllegalArgumentException e) {
      //do nothing
    }


    //is deck doesn't have enough cards to start
    try {
      model.startGameWithDeck(deck1, 3, 3);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    // if the deck has invalid height
    try {
      model.startGameWithDeck(deck, -2, 3);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    // if the deck has invalid width
    try {
      model.startGameWithDeck(deck, 3, -2);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }


  }


  @Test
  public void testIsGameOver() {

    //if deck has no more cards to replace isValid
    model.startGameWithDeck(dec, 3, 3);
    assertFalse(model.isGameOver());
    model.claimSet(one, two, three);
    assertTrue(model.isGameOver());


    //if Bigger Grid deck has no more cards to replace isValid
    model.startGameWithDeck(deck, 3, 9);
    assertFalse(model.isGameOver());
    model.claimSet(one, two, three);
    assertTrue(model.isGameOver());

    ///////////////

    //playing entire game through with bigger grid
    //not always a set on every state
    //no set on starting grid

    model.startGameWithDeck(deck5, 1, 3);
    assertTrue(model.anySetsPresent());

    //starting grid adds new row card
    assertEquals(2, model.getHeight());
    assertFalse(model.isGameOver());

    model.claimSet(one, two, three);

    //claimed set is being replaced by next cards
    //next cards aren't a set so there are now 2 rows of cards that aren't sets
    assertEquals(2, model.getHeight());
    assertTrue(model.anySetsPresent());
    model.claimSet(one, two, three);

    //adds new row of cards
    //assertEquals(3, model.getHeight());
    assertTrue(model.anySetsPresent());
    assertFalse(model.isGameOver());


    //if Grid deck has no more cards to replace isValid
    model.startGameWithDeck(deck0, 2, 9);
    assertFalse(model.isGameOver());
    model.claimSet(one, two, three);
    assertTrue(model.isGameOver());
  }




}