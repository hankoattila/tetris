package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
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
        block.add(new BodyBlock(pane, x, y - Globals.BLOCK_SIZE));
        block.add(new BodyBlock(pane, x + Globals.BLOCK_SIZE, y));
        block.add(new BodyBlock(pane, x - Globals.BLOCK_SIZE, y -Globals.BLOCK_SIZE));
        block.add(this);
        setImage( new Image("square.png"));
        pane.getChildren().add(this);

    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
