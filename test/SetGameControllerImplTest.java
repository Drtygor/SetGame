import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;

import cs3500.set.controller.SetGameController;
import cs3500.set.controller.SetGameControllerImpl;
import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.Count;
import cs3500.set.model.hw02.Filling;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.model.hw02.Shape;
import cs3500.set.view.SetGameTextView;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Tests for SetGameControllerImpl.
 */
public class SetGameControllerImplTest {


  private SetThreeGameModel model;
  private SetGameTextView view;


  private Readable object;


  @Before
  public void setupModelAndView() {
    StringBuilder sb;
    model = new SetThreeGameModel();
    sb = new StringBuilder();
    view = new SetGameTextView(model, sb);
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

  Coord one = new Coord(0, 0);
  Coord two = new Coord(0, 1);
  Coord three = new Coord(0, 2);


  //exceptions
  //behaviors
  //methods in the correct order
  //model cant answer because don't know what was called by the controller

  /*
  Scanner s = new Scanner(object);
  view = new SetGameTextView(model, sb);
  model.startGameWithDeck(deck, 3, 3);
  */

  @Test
  public void testQuitBeforeStartGame() {
    SetThreeGameModel model = new SetThreeGameModel();
    Readable read = new StringReader("q");
    Appendable out = new StringBuilder();
    SetGameTextView view = new SetGameTextView(model, out);
    SetGameController control = new SetGameControllerImpl(model, view, read);

    control.playGame();

    assertEquals("Game quit!\nScore: 0\n", out.toString());

  }

  @Test
  public void testQuitAfterStartGame() {
    SetThreeGameModel model = new SetThreeGameModel();
    Readable read = new StringReader("3 3 q");
    Appendable out = new StringBuilder();
    SetGameTextView view = new SetGameTextView(model, out);
    SetGameController control = new SetGameControllerImpl(model, view, read);

    control.playGame();
    model.startGameWithDeck(deck, 3, 3);

    assertEquals("1EO 1EQ 1ED" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 0" +
                    "\nGame quit!" +
                    "\nState of game when quit:" +
                    "\n1EO 1EQ 1ED" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 0\n"
            , out.toString());
  }


  @Test
  public void testNullView() {
    try {
      new SetGameControllerImpl(model, null, object);
      fail("Should not be able to initialize as null");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  @Test
  public void testNullReadable() {
    try {
      new SetGameControllerImpl(model, view, null);
      fail("Should not be able to initialize as null");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }


  @Test
  public void testNullModel() {
    try {
      new SetGameControllerImpl(null, view, object);
      fail("Should not be able to initialize as null");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }


  //game plays to end with all valid sets
  //ends game when over, not enough cards to claim set or no sets to claim
  @Test
  public void testEndGameOutput() {
    SetThreeGameModel model = new SetThreeGameModel();
    Readable read = new StringReader("3 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3");
    Appendable out = new StringBuilder();
    SetGameTextView view = new SetGameTextView(model, out);
    SetGameController control = new SetGameControllerImpl(model, view, read);

    control.playGame();
    model.startGameWithDeck(deck, 3, 3);

    assertEquals("1EO 1EQ 1ED" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 0" +
                    "\n2EO 2EQ 2ED" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 1" +
                    "\n2SO 2SQ 2SD" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 2" +
                    "\n2FO 2FQ 2FD" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 3" +
                    "\n3EO 3EQ 3ED" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 4" +
                    "\n3SO 3SQ 3SD" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 5" +
                    "\n3FO 3FQ 3FD" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 6" +
                    "\nGame over!" +
                    "\nScore: 7\n"
            , out.toString());
  }

  //game plays to end with some invalid sets
  @Test
  public void testCompleteGame() {
    SetThreeGameModel model = new SetThreeGameModel();
    Readable read = new StringReader("3 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 1 1 1 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3 " +
            "1 1 1 2 1 3");
    Appendable out = new StringBuilder();
    SetGameTextView view = new SetGameTextView(model, out);
    SetGameController control = new SetGameControllerImpl(model, view, read);

    control.playGame();
    model.startGameWithDeck(deck, 3, 3);

    assertEquals("1EO 1EQ 1ED" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 0" +
                    "\n2EO 2EQ 2ED" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 1" +
                    "\n2SO 2SQ 2SD" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 2" +
                    "\n2SO 2SQ 2SD" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 2" +
                    "\n2FO 2FQ 2FD" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 3" +
                    "\n3EO 3EQ 3ED" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 4" +
                    "\n3SO 3SQ 3SD" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 5" +
                    "\n3FO 3FQ 3FD" +
                    "\n1SO 1SQ 1SD" +
                    "\n1FO 1FQ 1FD" +
                    "\nScore: 6" +
                    "\nGame over!" +
                    "\nScore: 7\n"
            , out.toString());
  }


  //before starting game - client must put in two valid height and width before start game
  //one valid int and one invalid char, asks to re-enter invalid
  @Test
  public void testInvalidInputTryAgainBeforeStartGame() {
    SetThreeGameModel model = new SetThreeGameModel();
    Readable read = new StringReader("3 k 2 q");
    Appendable out = new StringBuilder();
    SetGameTextView view = new SetGameTextView(model, out);
    SetGameController control = new SetGameControllerImpl(model, view, read);

    control.playGame();
    assertEquals("Invalid height/width. Try again.\n" +
            "Game quit!\n" +
            "Score: 0\n", out.toString());
  }


  //after starting game - client must put in valid set before claim set
  //one valid and one invalid, asks to re-enter invalid
  @Test
  public void testInvalidInputTryAgainBeforeClaimSet() {
    SetThreeGameModel model = new SetThreeGameModel();
    Readable read = new StringReader("3 3 1 g 2 q");
    Appendable out = new StringBuilder();
    SetGameTextView view = new SetGameTextView(model, out);
    SetGameController control = new SetGameControllerImpl(model, view, read);

    control.playGame();
    assertEquals("1EO 1EQ 1ED" +
            "\n1SO 1SQ 1SD" +
            "\n1FO 1FQ 1FD" +
            "\nScore: 0" +
            //"\ninvalid input" +
            "\nGame quit!" +
            "\nState of game when quit:" +
            "\n1EO 1EQ 1ED" +
            "\n1SO 1SQ 1SD" +
            "\n1FO 1FQ 1FD" +
            "\nScore: 0\n", out.toString());
  }


  //No next in readable at start of playing game
  @Test
  public void testNoNextGameNotStarted() {
    SetThreeGameModel model = new SetThreeGameModel();
    Readable read = new StringReader("");
    Appendable out = new StringBuilder();
    SetGameTextView view = new SetGameTextView(model, out);
    SetGameController control = new SetGameControllerImpl(model, view, read);

    try {
      control.playGame();
      fail("no next");
    } catch (IllegalStateException e) {
      //do nothing
    }


  }

  //No next in readable in middle of playing game
  @Test
  public void testNoNextGameNotOver() {
    SetThreeGameModel model = new SetThreeGameModel();
    Readable read = new StringReader("3 3 1");
    Appendable out = new StringBuilder();
    SetGameTextView view = new SetGameTextView(model, out);
    SetGameController control = new SetGameControllerImpl(model, view, read);

    try {
      control.playGame();
      fail("no next");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }


  //Transmit error from Appendable to output
  @Test(expected = IllegalStateException.class)
  public void testFailTransmitOutput() {
    SetThreeGameModel model = new SetThreeGameModel();
    Readable read = new StringReader("3 3 1");
    Appendable out = new FailingAppendable();
    SetGameTextView view = new SetGameTextView(model, out);
    SetGameController control = new SetGameControllerImpl(model, view, read);
    control.playGame();


  }


}