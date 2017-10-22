package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class OBlock extends Animatable implements Interactable {
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
    protected void switchPositions() {

    }
}
