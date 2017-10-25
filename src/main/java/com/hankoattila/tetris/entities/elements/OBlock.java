package com.hankoattila.tetris.entities.elements;

import com.hankoattila.tetris.*;
import com.hankoattila.tetris.entities.Block;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class OBlock extends Block {
    public OBlock(Pane pane, int x, int y,String image) {
        super(pane,image);
        this.pane = pane;
        setX(x);
        setY(y);
        blockList.add(this);
        blockList.add(new BodyBlock(pane, x + Globals.BLOCK_SIZE, y,image, this));
        blockList.add(new BodyBlock(pane, x, y - Globals.BLOCK_SIZE, image,this));
        blockList.add(new BodyBlock(pane, x + Globals.BLOCK_SIZE, y - Globals.BLOCK_SIZE,image, this));
        setImage(new Image(this.image));
        pane.getChildren().add(this);


    }

    @Override
    protected void rotateBlock() {

    }
}
