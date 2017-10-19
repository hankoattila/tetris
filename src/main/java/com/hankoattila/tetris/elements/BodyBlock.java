package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class BodyBlock extends Animatable implements Interactable {
    GameEntity parent;

    protected BodyBlock(Pane pane, double xc, double yc, GameEntity parent) {
        super(pane);
        this.pane = pane;
        this.parent = parent;
        setX(xc);
        setY(yc);

        pane.getChildren().add(this);
        setImage(new Image("square.png"));
    }

    public void step() {
        setY(getY() + Globals.BLOCK_SIZE);
    }

    public void apply() {
        ((Interactable)parent).apply();
    }

    public String getMessage() {
        return null;
    }
}
