package com.hankoattila.tetris;

import javafx.scene.layout.Pane;

import java.util.Random;

public class Game extends Pane {

    public void start() {
        Random rnd = new Random();
        createBlockList();
        Blocks.createNewBlock(rnd.nextInt(Globals.blocks.size()), this);
        GameLoop gameLoop = new GameLoop();
        Globals.gameLoop = gameLoop;
        Globals.gameLoop.start();
    }

    private void createBlockList() {
        Globals.blocks.add(Blocks.IBLOCK);
        Globals.blocks.add(Blocks.JBLOCK);
        Globals.blocks.add(Blocks.LBLOCK);
        Globals.blocks.add(Blocks.OBLOCK);
        Globals.blocks.add(Blocks.SBLOCK);
//        Globals.blocks.add(Blocks.TBLOCK);
        Globals.blocks.add(Blocks.ZBLOCK);


    }
}
