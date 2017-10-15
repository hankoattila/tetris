package com.hankoattila.tetris;

import javafx.scene.layout.Pane;

public class Game extends Pane {

    public void start() {
        Square square = new Square(this, 200, 200);
        Globals.pane = this;
        GameLoop gameLoop = new GameLoop();
        Globals.gameLoop = gameLoop;
        Globals.gameLoop.start();
    }
}
