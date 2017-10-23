package com.hankoattila.tetris.entities.elements;

import com.hankoattila.tetris.*;
import com.hankoattila.tetris.entities.Block;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class IBlock extends Block {

    public IBlock(Pane pane, int x, int y, String image) {
        super(pane, image);
        this.pane = pane;
        setX(x);
        setY(y);
        int length = Globals.BLOCK_SIZE;
        blockList.add(this);
        for (int i = 0; i < 3; i++) {
            blockList.add(new BodyBlock(pane, x, y - length, image, this));
            length += Globals.BLOCK_SIZE;
        }
        setImage(new Image(this.image));
        pane.getChildren().add(this);
    }

    @Override
    protected void switchPositions() {

    }
}

