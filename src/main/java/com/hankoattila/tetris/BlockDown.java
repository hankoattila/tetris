package com.hankoattila.tetris;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.Random;


public class BlockDown extends GameEntity implements Interactable {
    public BlockDown(Pane pane, double x, double y) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        setImage(new Image("square.png"));
        pane.getChildren().add(this);
    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
