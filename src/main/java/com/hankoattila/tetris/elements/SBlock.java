package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SBlock extends Animatable implements Interactable {
    public SBlock(Pane pane, int x, int y,String image) {
        super(pane,image);
        this.pane = pane;
        setX(x);
        setY(y);
        blockList.add(this);
        blockList.add(new BodyBlock(pane, x - Globals.BLOCK_SIZE, y,image, this));
        blockList.add(new BodyBlock(pane, x, y - Globals.BLOCK_SIZE,image, this));
        blockList.add(new BodyBlock(pane, x + Globals.BLOCK_SIZE, y - Globals.BLOCK_SIZE, image,this));
        setImage(new Image(this.image));
        pane.getChildren().add(this);
    }
}
