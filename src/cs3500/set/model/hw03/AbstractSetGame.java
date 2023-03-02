package cs3500.set.model.hw03;

import java.util.ArrayList;
import java.util.List;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.Count;
import cs3500.set.model.hw02.Filling;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.Shape;


/**
 * This represents the abstract class for methods between the SetGameModel class implementations.
 */
public abstract class AbstractSetGame implements SetGameModel<Card> {
  protected int score;
  protected int width;
  protected int height;
  protected boolean start;
  protected boolean end;
  protected Card[][] gameBoard;
  protected List<Card> deck;

  /**
   * Constructor for implementation of SetGameModel.
   * The initial values represent before game is started.
   */
  public AbstractSetGame() {
    this.score = 0;
    this.width = 0;
    this.height = 0;
    this.start = false;
    this.end = false;
  }


  /**
   * Method that throws State exception if the game has not yet started or ended.
   */
  public void notSorE() {
    if (!start) {
      throw new IllegalStateException("game has not started or has ended");
    }

    if (end) {
      throw new IllegalStateException("game has not started or has ended");
    }
  }


  /**
   * Method that abstracts
   * the removal of cards and replacing with cards from deck,
   * increasing the score by one,
   * and ending the game else
   * behaviors for claim set.
   * @param coord1 the coordinates of the first card
   * @param coord2 the coordinates of the second card
   * @param coord3 the coordinates of the third card
   */
  @Override
  public void claimSet(Coord coord1, Coord coord2, Coord coord3) {

    if (isValidSet(coord1, coord2, coord3)) {
      this.score += 1;

      if (deck.size() >= 3) {
        gameBoard[coord1.row][coord1.col] = this.deck.remove(0);
        gameBoard[coord2.row][coord2.col] = deck.get(0);
        this.deck.remove(0);
        gameBoard[coord3.row][coord3.col] = deck.get(0);
        this.deck.remove(0);
      }

      else {
        this.end = true;
      }
    }

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
  public void startGameWithDeck(List<Card> deck, int height, int width) throws
          IllegalArgumentException {
    this.gameBoard = new Card[height][width];
    this.deck = new ArrayList<Card>(deck);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        gameBoard[i][j] = this.deck.get(0);
        this.deck.remove(0);
      }
    }

    this.start = true;
    this.width = width;
    this.height = height;
    this.end = false;
  }




  /**
   * This method gets the width of the board.
   * @return width the width of the board
   * @throws IllegalStateException if the game has not yet started
   */
  @Override
  public int getWidth() throws IllegalStateException {
    if (!start) {
      throw new IllegalStateException("game has not started");
    }
    else {
      return this.width;
    }

  }


  /**
   * This method gets the height of the board.
   * @return height the height of the board
   * @throws IllegalStateException if the game has not yet started
   */
  @Override
  public int getHeight() throws IllegalStateException {
    if (!start) {
      throw new IllegalStateException("game has not started");
    }
    else {
      return this.height;
    }
  }


  /**
   * This method gets the score of the game.
   * @return score the score of the game
   * @throws IllegalStateException if the game has not yet started
   */
  @Override
  public int getScore() throws IllegalStateException {
    if (!start) {
      throw new IllegalStateException("game has not started");
    }
    else {
      return this.score;
      //if isValidSet returns true then score + 1
    }

  }


  /**
   * Returns true if and only if there are any sets in the currently dealt board.
   *
   * @return if there are any sets available
   * @throws IllegalStateException if the game has not yet started
   */
  @Override
  public boolean anySetsPresent() throws IllegalStateException {
    if (!start) {
      throw new IllegalArgumentException("game has not started");
    }


    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        for (int k = 0; k < this.height; k++) {
          for (int l = 0; l < this.width; l++) {
            for (int m = 0; m < this.height; m++) {
              for (int n = 0; n < this.width; n++) {
                Coord c1 = new Coord(i, j);
                Coord c2 = new Coord(k, l);
                Coord c3 = new Coord(m, n);

                if (!c1.equals(c2) && !c2.equals(c3) && !c1.equals(c3)) {
                  if (isValidSet(c1, c2, c3)) {
                    return true;
                  }
                }

              }
            }

          }
        }
      }
    }
    return false;

  }



  /**
   * Returns true if cards at the specified coordinates form a valid set.
   * @param coord1 the coordinates of the first card
   * @param coord2 the coordinates of the second card
   * @param coord3 the coordinates of the third card
   * @return whether the cards form a valid set
   * @throws IllegalArgumentException if any of the coordinates are invalid for the given
   *     implementation of Set
   */
  @Override
  public boolean isValidSet(Coord coord1, Coord coord2, Coord coord3)
          throws IllegalArgumentException {
    if (coord1.row < 0 || coord1.row > this.height
            || coord1.col < 0 || coord1.col > this.width
            || coord2.row < 0 || coord2.row > this.height
            || coord2.col < 0 || coord2.col > this.width
            || coord3.row < 0 || coord3.row > this.height
            || coord3.col < 0 || coord3.col > this.width) {
      throw new IllegalArgumentException("invalid coordinates for a Set");
    }
    if (coord1.equals(coord2) || coord2.equals(coord3) || coord1.equals(coord3)) {
      throw new IllegalArgumentException("same coord, invalid set");
    }

    Card c1 = getCardAtCoord(coord1.row, coord1.col);
    Card c2 = getCardAtCoord(coord2.row, coord2.col);
    Card c3 = getCardAtCoord(coord3.row, coord3.col);

    return (c1.count == c2.count && c2.count == c3.count
            || c1.count != c2.count && c2.count != c3.count && c1.count != c3.count)
            && (c1.filling == c2.filling && c2.filling == c3.filling
            || c1.filling != c2.filling && c2.filling != c3.filling && c1.filling != c3.filling)
            && (c1.shape == c2.shape && c2.shape == c3.shape
            || c1.shape != c2.shape && c2.shape != c3.shape && c1.shape != c3.shape);
  }



  /**
   * Returns the card at the specified row and column coordinates.
   * @param row the row of the desired card
   * @param col the column of the desired card
   * @return the card at the specified coordinates
   * @throws IllegalStateException if the game has not yet started
   */
  @Override
  public Card getCardAtCoord(int row, int col) {
    if (!start) {
      throw new IllegalStateException("game has not started");
    }
    return gameBoard[row][col];
  }



  /**
   * Returns the card at the specified coordinates.
   * @param coord the coordinates of the desired card
   * @return the card at the specified coordinates
   * @throws IllegalStateException if the game has not yet started
   */
  @Override
  public Card getCardAtCoord(Coord coord) {
    if (!start) {
      throw new IllegalArgumentException("game has not started");
    }
    return gameBoard[coord.row][coord.col];
  }






  /**
   * Craft and return a new complete deck for the implemented game.
   * This deck must contain every possible card possible in the implemented game
   * exactly once.
   * There is no required/sorted order for the cards in this deck.
   * @return the complete deck of cards
   */
  @Override
  public List<Card> getCompleteDeck() {
    List<Card> deck = new ArrayList<Card>();
    for (int i = 0; i < Count.values().length; i++) {
      for (int j = 0; j < Shape.values().length; j++) {
        for (int k = 0; k <  Filling.values().length; k++) {
          Card c = new Card(Count.values()[i], Filling.values()[j], Shape.values()[k]);
          deck.add(c);
        }
      }
    }
    return deck;
  }


}
