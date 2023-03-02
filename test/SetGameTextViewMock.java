import java.io.IOException;
import cs3500.set.model.hw02.SetGameModelState;
import cs3500.set.view.SetGameView;

/**
 * Class for SetView mock.
 */
public class SetGameTextViewMock implements SetGameView {
  private SetGameModelState state;
  final Appendable log;

  /**
   * Displays the mock game in text view and outputs a log.
   */
  public SetGameTextViewMock(Appendable log) {
    this.log = log;
  }

  /**
   * Renders the grid to the data output in the implementation.
   * The format of the grid is exactly that of the toString method.
   * @throws IOException if the transmission of the grid to the data output fails
   */
  @Override
  public void renderGrid() throws IOException {
    try {
      this.log.append(this.toString()).append("\n");
    } catch (Exception e) {
      throw new IOException("Invalid Appendable");
    }
  }

  /**
   * Renders a given message to the data output in the implementation.
   *
   * @param message the message to be printed
   * @throws IOException if the transmission of the message to the data output fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.log.append(message).append("\n");
    } catch (Exception e) {
      throw new IOException("Invalid Appendable");
    }
  }
}