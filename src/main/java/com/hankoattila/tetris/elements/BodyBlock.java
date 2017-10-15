package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class BodyBlock  extends GameEntity implements Animatable, Interactable {
    protected BodyBlock(Pane pane, double xc, double yc) {
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
        if (isOutOfBounds()) {
            destroy();
        }
    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
