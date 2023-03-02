import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.Count;
import cs3500.set.model.hw02.Filling;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.model.hw02.Shape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * This class tests for the SetThreeModel.
 */


public class SetThreeGameModelTest extends AbstractSetGameTests {
  SetThreeGameModel model = new SetThreeGameModel();

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

  ArrayList<Card> dec = new ArrayList<Card>();
  ArrayList<Card> deck = new ArrayList<Card>();
  ArrayList<Card> deck0 = new ArrayList<Card>();
  ArrayList<Card> deck1 = new ArrayList<Card>();


  Coord one = new Coord(0,0);
  Coord two = new Coord(0,1);
  Coord three = new Coord(0,2);
  Coord four = new Coord(1,0);
  Coord five = new Coord(1,1);
  Coord six = new Coord(1,2);
  Coord seven = new Coord(2,0);
  Coord eight = new Coord(2,1);
  Coord nine = new Coord(2,2);

  Coord offgrid = new Coord(-5,0);
  Coord offgrid1 = new Coord(5,0);
  Coord offgrid2 = new Coord(0,-5);
  Coord offgrid3 = new Coord(0,5);


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


  @Override
  protected SetGameModel<Card> getModel() {
    return new SetThreeGameModel();
  }

  @Before
  public void makeDeck1() {
    deck1 = new ArrayList<Card>();
    deck1.add(c1);
    deck1.add(c2);
  }



  @Test
  public void testClaimSet() {

    //start game
    SetThreeGameModel model = new SetThreeGameModel();
    model.startGameWithDeck(deck, 3, 3);
    model.claimSet(one, two, three);
    assertEquals(1, model.getScore());
    assertEquals(c10, model.getCardAtCoord(0, 0));
    assertEquals(c11, model.getCardAtCoord(0, 1));
    assertEquals(c12, model.getCardAtCoord(0, 2));
    assertEquals(27, deck.size());
  }


  @Test
  public void testStartGameWithDeck() {


    //if deck has invalid deck size
    try {
      model.startGameWithDeck(deck1, 3, 2);
      fail("invalid argument");
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
      model.startGameWithDeck(deck, 2, 3);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    // if the deck has invalid width
    try {
      model.startGameWithDeck(deck, 3, 2);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    //parameters after starting game
    model.startGameWithDeck(deck, 3, 3);
    assertEquals(3 , model.getWidth());
    assertEquals(3 , model.getHeight());
    assertTrue(model.anySetsPresent());
    assertFalse(model.isGameOver());
    assertEquals(0, model.getScore());
    assertEquals(18, deck0.size());
  }



  @Test
  public void testGetWidth() {

    //getting height of game
    model.startGameWithDeck(deck, 3, 3);
    assertEquals(3, model.getWidth());
  }

  @Test
  public void testGetHeight() {

    //getting height of game
    model.startGameWithDeck(deck, 3, 3);
    assertEquals(3, model.getHeight());
  }

  @Test
  public void testGetScore() {
    //getting score as you claim sets and game ends
    model.startGameWithDeck(deck, 3, 3);
    assertEquals(0, model.getScore());
    model.claimSet(one, two, three);
    assertEquals(1, model.getScore());
    model.claimSet(four, five, six);
    assertEquals(2, model.getScore());
    model.claimSet(one, two, three);
    assertEquals(3, model.getScore());
    model.claimSet(one, two, three);
    assertEquals(4, model.getScore());
    model.claimSet(one, two, three);
    assertEquals(5, model.getScore());
    model.claimSet(one, two, three);
    assertEquals(6, model.getScore());
    model.claimSet(one, two, three);
    assertEquals(7, model.getScore());
    assertTrue(model.isGameOver());
  }


  @Test
  public void testAnySetsPresent() {

    //checking if sets present before set claimed
    model.startGameWithDeck(deck, 3, 3);
    assertTrue(model.anySetsPresent());
    //after
    model.claimSet(one, two, three);
    assertTrue(model.anySetsPresent());

  }

  @Test
  public void testIsValidSet() {

    Coord coord1 = new Coord(0,0);
    Coord coord2 = new Coord(0,1);
    Coord coord3 = new Coord(0,2);
    Coord coord4 = new Coord(1,0);
    Coord coord5 = new Coord(1,1);
    Coord coord6 = new Coord(1,2);

    model.startGameWithDeck(deck, 3, 3);

    //testing valid sets
    assertTrue(model.isValidSet(coord1, coord2, coord3));
    assertTrue(model.isValidSet(coord4, coord5, coord6));
    assertFalse(model.isValidSet(coord1, coord2, coord4));

  }

  @Test
  public void testGetCardAtCoord() {

    //getting coord
    model.startGameWithDeck(deck, 3, 3);
    assertEquals(c1, model.getCardAtCoord(0,0));

  }

  @Test
  public void testGetCardAtCoord1() {

    //getting coord
    model.startGameWithDeck(deck, 3, 3);
    assertEquals(c2, model.getCardAtCoord(0,1));

  }

  @Test
  public void testIsGameOver() {
    //if deck has no more cards to replace isValid
    model.startGameWithDeck(dec, 3, 3);
    assertFalse(model.isGameOver());
    model.claimSet(one, two, three);
    assertTrue(model.isGameOver());
  }


  @Test
  public void testGetCompleteDeck() {
    //deck has all 27 possible combinations
    model.startGameWithDeck(deck, 3, 3);
    assertEquals(27, model.getCompleteDeck().size());
  }


}


