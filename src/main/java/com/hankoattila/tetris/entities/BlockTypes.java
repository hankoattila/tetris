package com.hankoattila.tetris.entities;

import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.entities.GameEntity;
import com.hankoattila.tetris.entities.elements.*;
import javafx.scene.layout.Pane;

public enum BlockTypes {
    IBLOCK("iblock"),
    JBLOCK("jblock"),
    LBLOCK("lblock"),
    OBLOCK("oblock"),
    SBLOCK("sblock"),
    TBLOCK("tblock"),
    ZBLOCK("zblock");

    private String blockString;

    BlockTypes(String blockString) {
        this.blockString = blockString;
    }

    public static GameEntity createNewBlock(int number, Pane pane) {

        int x = Globals.BLOCK_SIZE * 2;
        switch (number) {
            case 0:
                return new IBlock(pane, x, 0, "square_blue.png");
            case 1:
                return new JBlock(pane, x, 0, "square_green.png");
            case 2:
                return new LBlock(pane, x, 0, "square_orange.png");
            case 3:
                return new OBlock(pane, x, 0, "square_pink.png");
            case 4:
                return new SBlock(pane, x, 0, "square_purple.png");
            case 5:
                return new TBlock(pane, x, 0, "square_red.png");
            case 6:
                return new ZBlock(pane, x, 0, "square_yellow.png");

        }
        return null;
    }
}
