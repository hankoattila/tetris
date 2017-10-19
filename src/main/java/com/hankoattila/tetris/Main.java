package com.hankoattila.tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        Main gameUI = new Main();
        gameUI.launch(Main.class, args);

    }

    public void start(Stage primaryStage) throws Exception {
        Stage initialise = Gui.createStartWindow();
        Game game = new Game();
        Scene scene = new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(scene);
        primaryStage.show();
        initialise.close();
        game.start();
    }
}
