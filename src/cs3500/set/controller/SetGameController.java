package cs3500.set.controller;

/**
 * This interface is to represent a controller for this game.
 */

public interface SetGameController {


  /**
   * This method should play a new game of Set.
   *
   * @throws IllegalStateException if controller is unable to
   *                               successfully read input or transmit output.
   */
  void playGame() throws IllegalStateException;

}
