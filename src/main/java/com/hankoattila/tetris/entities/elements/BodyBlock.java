package com.hankoattila.tetris.entities.elements;

import com.hankoattila.tetris.entities.Block;
import com.hankoattila.tetris.entities.GameEntity;
import com.hankoattila.tetris.entities.Interactable;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class BodyBlock extends Block {
    GameEntity parent;

    protected BodyBlock(Pane pane, double xc, double yc,String image, GameEntity parent) {
        super(pane,image);
        this.pane = pane;
        this.parent = parent;
        setX(xc);
        setY(yc);
        initEventHandlers(pane, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.DOWN,KeyCode.UP);
        pane.getChildren().add(this);
        setImage(new Image(image));
    }

    @Override
    protected void switchPositions() {

    }

    @Override
    public void apply() {
        ((Interactable) parent).apply();
    }

}
