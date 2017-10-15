package com.hankoattila.tetris;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Square extends GameEntity implements Animatable, Interactable  {
    private Pane pane;
    public Square(Pane pane, int xc, int yc) {
        super(pane);
        this.pane = pane;
        Globals.objectIsFall = true;
        setX(xc);
        setY(yc);
        pane.getChildren().add(this);
        setImage( new Image("square.png"));
    }

    public void step() {
        setY(getY()+4);
        if (isOutOfBounds()){
            destroy();
            new Square(pane,200,200);
        }

    }

    public void apply(Square square) {

    }

    public String getMessage() {
        return null;
    }
}
