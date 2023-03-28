package cs3500.set.view;

import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import cs3500.set.model.hw02.SetGameModelState;

/**
 * Represents the visual view of the grid for a game of Set. Cards are layed out
 * as a grid of unselected cards. Each card has its text representation printed
 * on the card back.
 */
public class BoardPanel extends JPanel implements IBoardPanel {
  private SetGameModelState modelState;
  private Image unselectedCard;
  private Image selectedCard;
  private final int cellDimension;
  private int originX;
  private int originY;

  /**
   * Constructs a new panel for the given game state. Loads in 2 images
   * representing the unselected and selected cards.
   * @param state the current state of the game
   * @throws IllegalStateException if res/unselected.png and res/selected.png do not exist
   */
  public BoardPanel(SetGameModelState state) throws IllegalStateException {
    super();
    this.modelState = state;
    this.setBackground(Color.WHITE);
    this.cellDimension = 50;
    try {
      unselectedCard = ImageIO.read(new FileInputStream("res/unselected.png"));
      unselectedCard = unselectedCard.getScaledInstance(cellDimension, cellDimension,
                                                    Image.SCALE_DEFAULT);

      selectedCard = ImageIO.read(new FileInputStream("res/selected.png"));
      selectedCard = selectedCard.getScaledInstance(cellDimension, cellDimension,
                                                    Image.SCALE_DEFAULT);

      this.setPreferredSize(
              new Dimension((this.modelState.getWidth() + 4) * cellDimension,
                            (this.modelState.getHeight() + 4) * cellDimension));
    } catch (IOException e) {
      throw new IllegalStateException("Icons not found!");
    }

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int xOffset = this.modelState.getWidth() * cellDimension / 2;
    int yOffset = this.modelState.getHeight() * cellDimension / 2;
    originX = (int) (this.getPreferredSize().getWidth() / 2 - xOffset);
    originY = (int) (this.getPreferredSize().getHeight() / 2 - yOffset);

    //your code to the draw the board should go here. 
    //The originX and originY is the top-left of where the card at coordinate (0,0) should start
    //cellDimension is the width (and height) occupied by every card
    //(we are making them square for simplicity)
    for (int row = 0; row < this.modelState.getHeight(); row++) {
      for (int col = 0; col < this.modelState.getWidth(); col++) {
        int x = originX + col * cellDimension;
        int y = originY + row * cellDimension;
        Image cardImage = unselectedCard;
        // TODO: Check if the card at (row, col) is selected, and if so, use selectedCard instead
        g.drawImage(cardImage, x, y, null);
        // TODO: Draw the text representation of the card at (row, col) on top of the cardImage
      }
    }
  }
}
