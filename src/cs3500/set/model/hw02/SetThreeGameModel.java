package cs3500.set.model.hw02;


import java.util.List;

import cs3500.set.model.hw03.AbstractSetGame;

/**
 * Designs a suitable representation of the game and instantiates in a 3 x 3 grid.
 */

public class SetThreeGameModel extends AbstractSetGame {



  /**
   * If the cards at the specified coordinates form a valid set, claim it,
   * and replace those cards with new cards from the deck, if possible.
   * This method claims a valid set of cards
   * @param coord1 the coordinates of the first card
   * @param coord2 the coordinates of the second card
   * @param coord3 the coordinates of the third card
   * @throws IllegalArgumentException if any of the coordinates are invalid for the particular
   *     implementation of Set OR the cards at those coordinates do not form a set
   * @throws IllegalStateException if the game has not started or the game has already ended
   */
  @Override
  public void claimSet(Coord coord1, Coord coord2, Coord coord3) {

    notSorE();

    if (coord1.row < 0 || coord1.row > 2
            || coord1.col < 0 || coord1.col > 2
            || coord2.row < 0 || coord2.row > 2
            || coord2.col < 0 || coord2.col > 2
            || coord3.row < 0 || coord3.row > 2
            || coord3.col < 0 || coord3.col > 2
            || !isValidSet(coord1, coord2, coord3)) {
      throw new IllegalArgumentException("invalid arguments");
    }

    super.claimSet(coord1, coord2, coord3);

  }


  /**
   * Begins the game using the cards given by the deck creates a grid specified
   * by the height and width parameters.
   *<p>
   * Specifically, the model deals the cards onto the board from left to right and top to bottom,
   * filling the grid.
   *</p>
   * @param deck the list of cards in the order they will be played
   * @param height the height of the board for this game
   * @param width the width of the board for this game
   * @throws IllegalArgumentException if the deck does not have enough cards to deal to the grid
   *     OR the deck is null
   *     OR the width and height are invalid for a particular implementation of Set
   *
   */

  @Override
  public void startGameWithDeck(List<Card> deck, int height, int width)
          throws IllegalArgumentException {
    if (deck == null || deck.size() < 9 || height != 3 || width != 3) {
      throw new IllegalArgumentException("invalid arguments");
    }

    super.startGameWithDeck(deck, height, width);
  }


  /**
   * Return true when the game is over. That happens when
   * <ul>
   *   <li>there no sets on the current board OR</li>
   *   <li>there are not enough cards remaining in the deck to deal after claiming a set</li>
   * </ul>
   * @return whether the game is over
   */

  @Override
  public boolean isGameOver() {
    if (!this.start) {
      this.end = false;
      return this.end;
    }

    if (!anySetsPresent() && deck.size() <= 0) {
      this.end = true;
      return this.end;
    }

    if (this.end) {
      this.end = true;
      return this.end;
    }

    this.end = false;
    return this.end;
  }


}
