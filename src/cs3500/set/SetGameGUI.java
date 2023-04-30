package cs3500.set;

import java.io.InputStreamReader;

import cs3500.set.controller.SetGameController;

import cs3500.set.controller.SetGameControllerImpl;
import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.view.BoardPanel;
import cs3500.set.view.IBoardPanel;
import cs3500.set.view.SetGameGuiView;
import cs3500.set.view.SetGameTextView;
import cs3500.set.view.SetGameView;
import cs3500.set.view.SwingGuiView;


public class SetGameGUI {



  public static void main(String[] args) {

    SetGameModel<Card> model = new SetThreeGameModel();
    model.startGameWithDeck(model.getCompleteDeck(),3, 3);


    BoardPanel boardPanel = new BoardPanel(model);
    IBoardPanel gamePanel = new GamePanel(boardPanel, model.getModelState());


    SetGameGUIView view = new SetGameGUIView(gamePanel, model);
    controller.playGame();




    SetGameModel game = new SetGameModelImpl();
    game.startGame(game.getDeck(), 3, 3);

    BoardPanel boardPanel = new BoardPanel(game.getModelState());
    ISetPanel gamePanel = new GamePanel(boardPanel, game.getModelState());

    SetGameGUIView view = new SetGameGUIView(gamePanel, game);
    view.display();


  }
}
