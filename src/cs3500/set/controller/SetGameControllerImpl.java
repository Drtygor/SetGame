package cs3500.set.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.view.SetGameView;

/**
 * This class implements the SetGameController interface.
 */
public class SetGameControllerImpl implements SetGameController {

  private SetGameModel<Card> model;

  private SetGameView view;

  private Readable object;


  /**
   * This constructor is for the controller class.
   *
   * @param model  is a SetGameModel.
   * @param view   is a SetTextView.
   * @param object is the readable object.
   */

  public SetGameControllerImpl(SetGameModel model, SetGameView view, Readable object) {
    if (model == null || view == null || object == null) {
      throw new IllegalArgumentException("invalid arguments");
    }
    this.model = model;
    this.view = view;
    this.object = object;
  }


  /**
   * This is an abstract method for checking values.
   *
   * @param value is the value.
   * @return boolean for comparison.
   */
  private boolean isGoodInputCheck(int value) {
    return value > 0;
  }

  /**
   * This is a method for checking for quit game command is prompted.
   *
   * @param input is the input.
   * @return boolean if quit.
   */
  private boolean isQuit(String input) {
    return input.equals("q") || input.equals("Q");
  }

  /**
   * This ia a method for abstracting the renderMessage StateException catch.
   *
   * @param input string message.
   */
  private void message(String input) {
    try {
      this.view.renderMessage(input);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * This is a method for abstracting the renderGrid StateException catch.
   */
  private void grid() {
    try {
      this.view.renderGrid();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * This is a method for abstracting the Scanner has next no element catch.
   *
   * @param s is a Scanner.
   */
  private void noNext(Scanner s) throws IllegalStateException {
    if (!s.hasNext()) {
      throw new IllegalStateException();
    }
  }

  /**
   * This is a method for abstracting the String is a format exception.
   *
   * @param s string reader.
   */
  private void noFormat(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      throw new NumberFormatException();
    }
  }


  /**
   * This method should play a new game of Set.
   *
   * @throws IllegalStateException if controller is unable to successfully
   *                               read input or transmit output.
   */

  @Override
  public void playGame() throws IllegalStateException {

    Scanner s = new Scanner(this.object);

    /*
    noNext(s);
    String h = s.next();
    if (isQuit(h)) {
      message("Game quit!");
      message("Score: 0");
      return;
    }

    noFormat(h);
    int height = Integer.parseInt(h);
    //number format exception


    noNext(s);
    String w = s.next();
    if (isQuit(w)) {
      message("Game quit!");
      message("Score: 0");
      return;
    }

    noFormat(w);
    int width = Integer.parseInt(w);
    //number format exception
    */

    int height;
    int width;


    //(height <= 0 || width <= 0) && height * width > 27
    while (true) {

      // message("Invalid input, please re-enter");
      String h;
      if (s.hasNext()) {
        h = s.next();
      } else {
        throw new IllegalStateException("No more inputs");
      }


      try {
        height = Integer.parseInt(h);
        break;
      } catch (NumberFormatException e) {
        if (isQuit(h)) {
          message("Game quit!");
          message("Score: 0");
          return;
        }
        else {
          message("Invalid height/width. Try again");
        }
      }
    }


    while (true) {

      // message("Invalid input, please re-enter");
      noNext(s);
      String w = s.next();


      try {
        width = Integer.parseInt(w);
        break;
      } catch (NumberFormatException e) {
        if (isQuit(w)) {
          message("Game quit!");
          message("Score: 0");
          return;
        } else {
          message("Invalid height/width. Try again.");
        }
      }
    }


    while (true) {

      try {
        model.startGameWithDeck(model.getCompleteDeck(), height, width);
        break;
      } catch (IllegalArgumentException ae) {
        message("Invalid height/width. Try again.");
        while (true) {


          noNext(s);
          String h = s.next();


          try {
            height = Integer.parseInt(h);
            break;
          } catch (NumberFormatException e) {
            if (isQuit(h)) {
              message("Game quit!");
              message("Score: 0");
              return;
            } else {
              message("Invalid height/width. Try again.");
            }
          }
        }


        while (true) {

          // message("Invalid input, please re-enter");
          noNext(s);
          String w = s.next();


          try {
            width = Integer.parseInt(w);
            break;
          } catch (NumberFormatException e) {
            if (isQuit(w)) {
              message("Game quit!");
              message("Score: 0");
              return;
            } else {
              message("Invalid height/width. Try again.");
            }
          }
        }

      }
    }


    while (!model.isGameOver()) {

      grid();
      message("Score: " + this.model.getScore());

      int[] arr = new int[6];

      for (int i = 0; i < 6; i++) {

        noNext(s);
        String lineInput = s.next();

        if (isQuit(lineInput)) {
          message("Game quit!");
          message("State of game when quit:");
          grid();
          message("Score: " + this.model.getScore());
          return;
        }

        int rowOrCol = 0;

        try {
          rowOrCol = Integer.parseInt(lineInput);
        } catch (Exception e) {
          i -= 1;
          System.out.println("invalid input");
          continue;
        }

        if (i % 2 == 0) { //means this is a row
          if (!isGoodInputCheck(rowOrCol)) {
            message("Invalid input, please re-enter");
            i -= 1;
          } else {
            arr[i] = rowOrCol;
          }
        }

        if (i % 2 == 1) { //means this is a col
          if (!isGoodInputCheck(rowOrCol)) {
            message("Invalid input, please re-enter");
            i -= 1;
          } else {
            arr[i] = rowOrCol;
          }
        }

      }

      /*
      //loop this until given a valid input
      String strRow1 = s.next();
      if (isQuit(strRow1)) {
        break;
      }
      int row1 = Integer.parseInt(strRow1);
      if (! (isGoodInputCheck(row1, height))) {
        try {
          this.view.renderMessage("Invalid input, please re-enter");
        } catch(IOException e) {
          throw new IllegalStateException(e);
        }
      }


      String strCol1 = s.next();
      if (isQuit(strCol1)) {
        break;
      }
      int column1 = Integer.parseInt(strCol1);
      if (! (isGoodInputCheck(column1, width))) {
        try {
          this.view.renderMessage("Invalid input, please re-enter");
        } catch(IOException e) {
          throw new IllegalStateException(e);
        }
      }


      String strRow2 = s.next();
      if (isQuit(strRow2)) {
        break;
      }
      int row2 = Integer.parseInt(strRow2);
      if (! (isGoodInputCheck(row2, height))) {
        try {
          this.view.renderMessage("Invalid input, please re-enter");
        } catch(IOException e) {
          throw new IllegalStateException(e);
        }
      }


      String strCol2 = s.next();
      if (isQuit(strCol2)) {
        break;
      }
      int column2 = Integer.parseInt(strCol2);
      if (! (isGoodInputCheck(column2, width))) {
        try {
          this.view.renderMessage("Invalid input, please re-enter");
        } catch(IOException e) {
          throw new IllegalStateException(e);
        }
      }


      String strRow3 = s.next();
      if (isQuit(strRow3)) {
        break;
      }
      int row3 = Integer.parseInt(strRow3);
      if (! (isGoodInputCheck(row3, height))) {
        try {
          this.view.renderMessage("Invalid input, please re-enter");
        } catch(IOException e) {
          throw new IllegalStateException(e);
        }
      }


      String strCol3 = s.next();
      if (isQuit(strCol3)) {
        break;
      }
      int column3 = Integer.parseInt(strCol3);
      if (! (isGoodInputCheck(column3, width))) {
        try {
          this.view.renderMessage("Invalid input, please re-enter");
        } catch(IOException e) {
          throw new IllegalStateException(e);
        }
      }
      */

      /*
      Coord one = new Coord(row1 - 1, column1 - 1);
      Coord two = new Coord(row2 - 1, column2 - 1);
      Coord three = new Coord(row3 - 1, column3 - 1);

      model.claimSet(one, two, three);
      */


      Coord one = new Coord(arr[0] - 1, arr[1] - 1);
      Coord two = new Coord(arr[2] - 1, arr[3] - 1);
      Coord three = new Coord(arr[4] - 1, arr[5] - 1);

      try {
        model.claimSet(one, two, three);
      } catch (Exception e) {
        System.out.println("Invalid Claim");
      }


    }


    message("Game over!");

    message("Score: " + this.model.getScore());


  }


}
