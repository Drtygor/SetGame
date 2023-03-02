import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.Count;
import cs3500.set.model.hw02.Filling;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.Shape;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * This class abstracts the SetGame tests.
 */

public abstract class AbstractSetGameTests {


  protected SetGameModel<Card> model;

  protected abstract SetGameModel<Card> getModel();


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

  protected Card c1 = new Card(Count.one, Filling.empty, Shape.oval);
  protected Card c2 = new Card(Count.one, Filling.empty, Shape.squiggle);
  protected Card c3 = new Card(Count.one, Filling.empty, Shape.diamond);
  protected Card c4 = new Card(Count.one, Filling.striped, Shape.oval);
  protected Card c5 = new Card(Count.one, Filling.striped, Shape.squiggle);
  protected Card c6 = new Card(Count.one, Filling.striped, Shape.diamond);
  protected Card c7 = new Card(Count.one, Filling.full, Shape.oval);
  protected Card c8 = new Card(Count.one, Filling.full, Shape.squiggle);
  protected Card c9 = new Card(Count.one, Filling.full, Shape.diamond);


  protected Card c10 = new Card(Count.two, Filling.empty, Shape.oval);
  protected Card c11 = new Card(Count.two, Filling.empty, Shape.squiggle);
  protected Card c12 = new Card(Count.two, Filling.empty, Shape.diamond);
  protected Card c13 = new Card(Count.two, Filling.striped, Shape.oval);
  protected Card c14 = new Card(Count.two, Filling.striped, Shape.squiggle);
  protected Card c15 = new Card(Count.two, Filling.striped, Shape.diamond);
  protected Card c16 = new Card(Count.two, Filling.full, Shape.oval);
  protected Card c17 = new Card(Count.two, Filling.full, Shape.squiggle);
  protected Card c18 = new Card(Count.two, Filling.full, Shape.diamond);


  protected Card c19 = new Card(Count.three, Filling.empty, Shape.oval);
  protected Card c20 = new Card(Count.three, Filling.empty, Shape.squiggle);
  protected Card c21 = new Card(Count.three, Filling.empty, Shape.diamond);
  protected Card c22 = new Card(Count.three, Filling.striped, Shape.oval);
  protected Card c23 = new Card(Count.three, Filling.striped, Shape.squiggle);
  protected Card c24 = new Card(Count.three, Filling.striped, Shape.diamond);
  protected Card c25 = new Card(Count.three, Filling.full, Shape.oval);
  protected Card c26 = new Card(Count.three, Filling.full, Shape.squiggle);
  protected Card c27 = new Card(Count.three, Filling.full, Shape.diamond);


  //1EO, 1EQ, 1ED, 1SO, 1SQ, 1SD, 1FO, 1FQ, 1FD,
  // 2EO, 2EQ, 2ED, 2SO, 2SQ, 2SD, 2FO, 2FQ, 2FD,
  // 3EO, 3EQ, 3ED, 3SO, 3SQ, 3SD, 3FO, 3FQ, 3FD

  protected ArrayList<Card> dec = new ArrayList<Card>();
  protected ArrayList<Card> deck = new ArrayList<Card>();
  protected ArrayList<Card> deck0 = new ArrayList<Card>();
  protected ArrayList<Card> deck1 = new ArrayList<Card>();


  protected Coord one = new Coord(0,0);
  protected Coord two = new Coord(0,1);
  protected Coord three = new Coord(0,2);
  protected Coord four = new Coord(1,0);
  protected Coord five = new Coord(1,1);
  protected Coord six = new Coord(1,2);
  protected Coord seven = new Coord(2,0);
  protected Coord eight = new Coord(2,1);
  protected Coord nine = new Coord(2,2);

  protected Coord offgrid = new Coord(-5,0);
  protected Coord offgrid1 = new Coord(5,0);
  protected Coord offgrid2 = new Coord(0,-5);
  protected Coord offgrid3 = new Coord(0,5);


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
  public void init() {
    model = getModel();
  }

  @Test
  public void testGetScore() {


    //getting score when game hasn't started
    try {
      model.getScore();
      fail("game has not started");
    } catch (IllegalStateException e) {
      //do nothing
    }

  }

  @Test
  public void testClaimSet() {

    // if the game hasn't started
    try {
      model.claimSet(one, two, three);
      fail("game has not started or has ended");
    } catch (IllegalStateException e) {
      //do nothing
    }

    model.startGameWithDeck(deck, 3, 3);

    //if invalid first coord row
    try {
      model.claimSet(offgrid, two, three);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    // if invalid first coord col
    try {
      model.claimSet(offgrid1, two, three);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    //if invalid second coord
    try {
      model.claimSet(one, offgrid2, five);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    //if invalid third coord
    try {
      model.claimSet(one, six, offgrid3);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    //if these cards arent valid set
    try {
      model.claimSet(one, six, five);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

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
  }


  @Test
  public void testStartGameWithDeck() {

    //if deck is null
    try {
      model.startGameWithDeck(null, 3, 3);
      fail("invalid argument");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  @Test
  public void testGetWidth() {

    //getting height when game hasn't started
    try {
      model.getWidth();
      fail("game has not started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testGetHeight() {

    //getting height when game hasn't started
    try {
      model.getHeight();
      fail("game has not started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testAnySetsPresent() {

    //looking for any sets present when game hasn't started
    try {
      model.anySetsPresent();
      fail("game has not started");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  @Test
  public void testGetCardAtCoord() {

    //getting coord when game hasn't started
    try {
      model.getCardAtCoord(0, 1);
      fail("game has not started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testGetCardAtCoord1() {

    Coord coord1 = new Coord(0, 1);

    //getting coord when game hasn't started
    try {
      model.getCardAtCoord(coord1);
      fail("game has not started");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }







}
