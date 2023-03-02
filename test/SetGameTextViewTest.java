import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.Count;
import cs3500.set.model.hw02.Filling;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.model.hw02.Shape;
import cs3500.set.model.hw03.GeneralSetGameModel;
import cs3500.set.view.SetGameTextView;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * This class is for testing the SetGameView class.
 */
public class SetGameTextViewTest {

  private SetThreeGameModel model;

  private GeneralSetGameModel general;
  private SetGameTextView view;

  private StringBuilder sb; //acts as an Appendable

  @Before
  public void setupModelAndView() {
    model = new SetThreeGameModel();
    sb = new StringBuilder();
    view =  new SetGameTextView(model, sb);
  }

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


  //1EO, 1EQ, 1ED, 1SO, 1SQ, 1SD, 1FO, 1FQ, 1FD,
  // 2EO, 2EQ, 2ED, 2SO, 2SQ, 2SD, 2FO, 2FQ, 2FD,
  // 3EO, 3EQ, 3ED, 3SO, 3SQ, 3SD, 3FO, 3FQ, 3FD


  ArrayList<Card> deck = new ArrayList<Card>();

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
  }

  Coord one = new Coord(0,0);
  Coord two = new Coord(0,1);
  Coord three = new Coord(0,2);



  @Test
  public void testToString() {

    try {
      view =  new SetGameTextView(null);
    } catch (IllegalArgumentException e) {
      //do nothing
    }


    model.startGameWithDeck(deck, 3, 3);

    assertEquals("1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD", view.toString());

    model.claimSet(one, two, three);
    assertEquals("2EO 2EQ 2ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD", view.toString());

  }

  @Test
  public void testRenderGrid() {
    model.startGameWithDeck(deck, 3, 3);
    try {
      view.renderGrid();
    } catch (IOException e) {
      fail();
    }
    assertEquals("1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD" + "\n", sb.toString());
  }

  @Test
  public void testRenderMessage() {
    model.startGameWithDeck(deck, 3, 3);
    try {
      view.renderMessage("message");
    } catch (IOException e) {
      fail();
    }
    assertEquals("message" + "\n", sb.toString());

  }

  @Test
  public void testFailRenderMessage() {
    view = new SetGameTextView(model, new FailingAppendable());
    model.startGameWithDeck(deck, 3, 3);
    try {
      view.renderMessage("message");
      fail();
    } catch (IOException e) {
      //do nothing
    }
  }


}