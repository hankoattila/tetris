package com.hankoattila.tetris;

import com.hankoattila.tetris.elements.IBlock;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    public void start() {
        IBlock iBlock = new IBlock(this, 200, 0);
        GameLoop gameLoop = new GameLoop();
        Globals.gameLoop = gameLoop;
        Globals.gameLoop.start();
    }
}
