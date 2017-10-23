package com.hankoattila.tetris.entities;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class TableBlock extends GameEntity implements Interactable {
    public TableBlock(Pane pane, double x, double y, String image) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        setImage(new Image(image));
        pane.getChildren().add(this);
    }

    public void apply() {
    }

}
