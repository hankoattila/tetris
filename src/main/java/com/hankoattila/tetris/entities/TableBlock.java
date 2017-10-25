package com.hankoattila.tetris.entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class TableBlock extends ImageView implements Interactable {
    private Pane pane;

    public TableBlock(Pane pane, double x, double y, String image) {
        this.pane = pane;
        setX(x);
        setY(y);
        setImage(new Image(image));
        pane.getChildren().add(this);
    }

    public void apply() {
    }

}
