import cs3500.set.controller.SetGameController;
import cs3500.set.model.hw02.SetThree;
import cs3500.set.view.SetGameGuiView;
import cs3500.set.view.SwingGuiView;


public class SetGameGUI {
  public static void main(String[] args) {
    SetThree model = new SetThree();
    SetGameGuiView view = new SwingGuiView(model);

    SetGameController controller = new SetGameController(model, view);
    controller.startGame(model.getDeck(), 3, 3);
  }
}
}
