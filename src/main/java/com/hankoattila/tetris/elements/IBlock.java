package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class IBlock extends GameEntity implements Animatable, Interactable {

    public IBlock(Pane pane, int xc, int yc) {
        super(pane);
        this.pane = pane;
        Globals.objectIsFall = true;
        setX(xc);
        setY(yc);
        int length = 30;
        for (int i = 0; i < 3; i++) {
            new BodyBlock(pane,xc,yc-length);
            length+=30;
        }
        setImage(new Image("square.png"));
        pane.getChildren().add(this);
    }

    public void step() {
        setY(getY() + 4);
        if (isOutOfBounds()) {
            new JBlock(pane, 200, 0);
            destroy();
        }

    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
