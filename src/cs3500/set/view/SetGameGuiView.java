package cs3500.set.view;

/**
 * Represents behaviors for a GUI view for the game of Set.
 * By default, requires operations to refresh the view and
 * render messages to the user.
 *
 */
public interface SetGameGuiView {
  /**
   * Refresh the screen. This is called when the something on the
   * screen is updated and therefore it must be redrawn.
   */
  void refresh();

  /**
   * Display a message in a suitable area of the GUI.
   * @param message the message to be displayed
   */
  void renderMessage(String message);

}
