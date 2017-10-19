package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class BodyBlock extends Animatable implements Interactable {
    int speed;

    protected BodyBlock(Pane pane, double xc, double yc) {
        super(pane);
        this.pane = pane;
        speed = 4;
        setX(xc);
        setY(yc);

        pane.getChildren().add(this);
        setImage(new Image("square.png"));
    }
    public void step() {
        setY(getY() + Globals.BLOCK_SIZE);
    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
