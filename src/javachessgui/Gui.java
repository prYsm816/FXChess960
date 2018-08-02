package javachessgui;

import javafx.stage.*;

import javafx.scene.layout.HBox;


public class Gui {

    public HBox horizontal_box = new HBox(2);
    private Board board;
    private Game game;
    private Stage stage;

    public Gui(Stage set_stage) {

        stage = set_stage;

        board = new Board(true);
        board.stage = stage;

        game = new Game(stage, board);

        game.reset(board.report_fen());

        board.game = game;


        horizontal_box.getChildren().add(board.main_box);
        horizontal_box.getChildren().add(game.vertical_box);

    }

    public void shutdown() {
        board.stop_engine_process();
    }

}
