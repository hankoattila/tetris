package com.hankoattila.tetris;

import com.hankoattila.tetris.entities.BlockTypes;
import com.hankoattila.tetris.entities.TableBlock;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Game extends Pane {

    public void start() {
        Random rnd = new Random();
        createBlockList();
        for (int i = 0; i < Globals.WINDOW_WIDTH; i += Globals.BLOCK_SIZE) {
            for (int j = 0; j < Globals.WINDOW_HEIGHT; j += Globals.BLOCK_SIZE) {
                new TableBlock(this, i, j, "bcg.jpg");
            }

        }
        BlockTypes.createNewBlock(rnd.nextInt(Globals.blocks.size()), this);
        GameLoop gameLoop = new GameLoop();
        Globals.gameLoop = gameLoop;
        Globals.gameLoop.start();
    }

    private void createBlockList() {
        Globals.blocks.add(BlockTypes.IBLOCK);
        Globals.blocks.add(BlockTypes.JBLOCK);
        Globals.blocks.add(BlockTypes.LBLOCK);
        Globals.blocks.add(BlockTypes.OBLOCK);
        Globals.blocks.add(BlockTypes.SBLOCK);
        Globals.blocks.add(BlockTypes.TBLOCK);
        Globals.blocks.add(BlockTypes.ZBLOCK);


    }
}
