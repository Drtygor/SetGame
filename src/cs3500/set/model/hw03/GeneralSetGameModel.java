package cs3500.set.model.hw03;

import java.util.ArrayList;
import java.util.List;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;

/**
 * Designs a suitable representation of the game and instantiates in a 3 x 3 grid.
 */

public class GeneralSetGameModel extends AbstractSetGame {


  /**
   * Method for a new row of cards with new cards from the deck.
   */
  private void addRow() {

    this.height += 1;
    Card[][] board = new Card[this.height][this.width];
    this.deck = new ArrayList<Card>(getCompleteDeck());

    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        board[i][j] = this.deck.get(0);
        this.deck.remove(0);
      }
    }
    this.gameBoard = board;
  }


  /**
   * Method that continues to add rows is there are still no sets present and the deck has enough
   * cards to add the new row.
   */

  private void addingRows() {
    while (!anySetsPresent() && deck.size() >= this.width) {
      addRow();
      if (deck.size() == 0 && !anySetsPresent()) {
        this.end = true;
      }
    }
  }


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

    if (coord1.row < 0 || coord1.row > this.height
            || coord1.col < 0 || coord1.col > this.width
            || !isValidSet(coord1, coord2, coord3)) {
      throw new IllegalArgumentException("invalid arguments");
    }


    super.claimSet(coord1, coord2, coord3);

    addingRows();

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
   */

  @Override
  public void startGameWithDeck(List<Card> deck, int height, int width)
          throws IllegalArgumentException {
    if (deck == null || deck.size() < 3 || height * width < 3
            || width < 1 || height < 1) {
      throw new IllegalArgumentException("invalid arguments");
    }

    super.startGameWithDeck(deck, height, width);


    addingRows();

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
      return false;
    }

    if (!anySetsPresent() && deck.size() == 0) {
      this.end = true;
      return true;
    }

    if (!anySetsPresent() && deck.size() < this.width) {
      this.end = true;
      return true;
    }

    return this.end;
  }


}
