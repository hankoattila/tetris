package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class ZBlock extends Animatable implements Interactable {

    public ZBlock(Pane pane, int x, int y) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        blockList.add(new BodyBlock(pane, x, y - Globals.BLOCK_SIZE, this));
        blockList.add(new BodyBlock(pane, x + Globals.BLOCK_SIZE, y, this));
        blockList.add(new BodyBlock(pane, x - Globals.BLOCK_SIZE, y - Globals.BLOCK_SIZE, this));
        blockList.add(this);
        setImage(new Image("square.png"));
        pane.getChildren().add(this);

    }
}
