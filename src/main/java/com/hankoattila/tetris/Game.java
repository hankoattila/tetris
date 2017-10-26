package com.hankoattila.tetris;

import com.hankoattila.tetris.entities.BlockTypes;
import com.hankoattila.tetris.entities.TableBlock;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;
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


        // new Image(url)
        Image image = new Image("wallpaper.jpg");
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background(images...)
        Background background = new Background(backgroundImage);
        this.setBackground(background);

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
