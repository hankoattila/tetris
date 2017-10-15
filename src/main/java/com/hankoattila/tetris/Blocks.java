package com.hankoattila.tetris;

import com.hankoattila.tetris.elements.*;
import javafx.scene.layout.Pane;

public enum   Blocks {
    IBLOCK("iblock"),
    JBLOCK("jblock"),
    LBLOCK("lblock"),
    OBLOCK("oblock"),
    SBLOCK("sblock"),
    TBLOCK("tblock"),
    ZBLOCK("zblock");

    private String blockString;

    Blocks(String blockString){
        this.blockString = blockString;
    }

    public static GameEntity createNewBlock(int number ,Pane pane){
        switch (number){
            case 0:return new IBlock(pane,200,0);
            case 1:return new JBlock(pane,200,0);
            case 2:return new LBlock(pane,200,0);
            case 3:return new OBlock(pane,200,0);
            case 4:return new SBlock(pane,200,0);
            case 5:return new TBlock(pane,200,0);
            case 6:return new ZBlock(pane,200,0);

        }
        return null;
    }
}
