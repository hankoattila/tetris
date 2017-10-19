package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;



public class IBlock extends Animatable implements Interactable {

    public IBlock(Pane pane, int xc, int yc) {
        super(pane);
        this.pane = pane;
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

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
