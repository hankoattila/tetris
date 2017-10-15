package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class JBlock extends Animatable implements  Interactable {

    public JBlock(Pane pane, int xc, int yc) {
        super(pane);
        this.pane = pane;
        Globals.objectIsFall = true;
        setX(xc);
        setY(yc);

        new BodyBlock(pane, xc, yc-30);
        new BodyBlock(pane, xc-31, yc-30);
        new BodyBlock(pane, xc-62, yc-30);

        setImage(new Image("square.png"));
        pane.getChildren().add(this);



    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
