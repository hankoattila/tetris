package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class OBlock extends Animatable implements Interactable {
    public OBlock(Pane pane, int x, int y) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        blockList.add(this);
        blockList.add(new BodyBlock(pane, x + Globals.BLOCK_SIZE, y, this));
        blockList.add(new BodyBlock(pane, x, y - Globals.BLOCK_SIZE, this));
        blockList.add(new BodyBlock(pane, x + Globals.BLOCK_SIZE, y - Globals.BLOCK_SIZE, this));
        setImage(new Image("square.png"));
        pane.getChildren().add(this);


    }

}
