package cs3500.set;


import java.io.IOException;
import java.io.InputStreamReader;

import cs3500.set.controller.SetGameController;
import cs3500.set.controller.SetGameControllerImpl;
import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.model.hw03.GeneralSetGameModel;
import cs3500.set.view.SetGameTextView;
import cs3500.set.view.SetGameView;

/**
 * This class runs the program.
 */

public final class SetGame {

  /**
   * This is the main method.
   *
   * @param args input for the controller.
   * @throws IOException if controller is unable to
   *                     successfully read input or transmit output.
   */
  public static void main(String[] args) throws IOException {
    SetGameModel<Card> model;
    if (args[0].equals("three")) {
      model = new SetThreeGameModel();
    } else if (args[0].equals("general")) {
      model = new GeneralSetGameModel();
    } else {
      return;
    }
    Appendable ap = System.out;
    SetGameView view = new SetGameTextView(model, ap);
    Readable rd = new InputStreamReader(System.in);
    SetGameController controller = new SetGameControllerImpl(model, view, rd);
    controller.playGame();
  }
}
