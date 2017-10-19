package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class BodyBlock extends Animatable implements Interactable {
    GameEntity parent;

    protected BodyBlock(Pane pane, double xc, double yc, GameEntity parent) {
        super(pane);
        this.pane = pane;
        this.parent = parent;
        setX(xc);
        setY(yc);
        initEventHandlers(pane, KeyCode.LEFT, KeyCode.RIGHT);
        pane.getChildren().add(this);
        setImage(new Image("square.png"));
    }

    @Override
    public void step() {
        if (leftKeyDown) {
            setX(getX() - Globals.BLOCK_SIZE);
        }
        if (rightKeyDown) {
            setX(getX() + Globals.BLOCK_SIZE);
        }
        setY(getY() + Globals.BLOCK_SIZE);
    }

    @Override
    public void apply() {
        ((Interactable) parent).apply();
    }

}
