package cs3500.set.view;

import java.io.IOException;

import cs3500.set.model.hw02.SetGameModelState;

/**
 * This class implements the SetGameView interface.
 */
public class SetGameTextView implements SetGameView {

  private SetGameModelState model;
  private Appendable object;

  /**
   * This a constructor for the View class.
   *
   * @param model is a SetGameModelState class parameter.
   * @throws IllegalArgumentException if the provided model null.
   */

  public SetGameTextView(SetGameModelState model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("invalid arguments");
    }
    this.model = model;
    this.object = System.out;
  }

  /**
   * This a constructor for the View class.
   *
   * @param model  is a SetGameModelState class parameter.
   * @param object is a Readable.
   * @throws IllegalArgumentException if the provided model or Appendable object is null.
   */

  public SetGameTextView(SetGameModelState model, Appendable object)
          throws IllegalArgumentException {
    if (model == null || object == null) {
      throw new IllegalArgumentException("invalid arguments");
    }
    this.model = model;
    this.object = object;
  }


  /**
   * Produces a textual view of the grid of cards of the current game.
   * Each card is displayed as initials of all of its attributes.
   * For instance, if a card has a single red oval, the card is displayed as 1RO.
   * If a card has three squiggly purple shapes, the card is displayed as 3PS.
   *
   * @return representation of the current state of the game
   */

  @Override
  public String toString() {
    String output = "";
    for (int i = 0; i < model.getHeight(); i++) {
      for (int j = 0; j < model.getWidth(); j++) {
        this.model.getCardAtCoord(i, j).toString();
        String card = this.model.getCardAtCoord(i, j).toString();
        if (j == model.getWidth() - 1) {
          output = output + card;
        } else {
          output = output + card + " ";
        }
      }
      if (i == model.getHeight() - 1) {
        return output;
      } else {
        output = output + "\n";
      }
    }
    return output;
  }


  /**
   * Renders the grid to the data output in the implementation.
   * The format of the grid is exactly that of the toString method.
   *
   * @throws IOException if the transmission of the grid to the data output fails
   */
  @Override
  public void renderGrid() throws IOException {

    object.append(this.toString() + "\n");

  }


  /**
   * Renders a given message to the data output in the implementation.
   *
   * @param message the message to be printed
   * @throws IOException if the transmission of the message to the data output fails
   */
  @Override
  public void renderMessage(String message) throws IOException {

    object.append(message).append("\n");

  }

}
