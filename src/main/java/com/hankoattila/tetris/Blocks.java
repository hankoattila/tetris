package com.hankoattila.tetris;

import com.hankoattila.tetris.elements.*;
import javafx.scene.layout.Pane;

import java.util.Random;

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

        int x = Globals.BLOCK_SIZE * 4;
        switch (number){
            case 0:return new IBlock(pane,x,0);
            case 1:return new JBlock(pane,x,0);
            case 2:return new LBlock(pane,x,0);
            case 3:return new OBlock(pane,x,0);
            case 4:return new SBlock(pane,x,0);
            case 5:return new TBlock(pane,x,0);
            case 6:return new ZBlock(pane,x,0);

        }
        return null;
    }
}
