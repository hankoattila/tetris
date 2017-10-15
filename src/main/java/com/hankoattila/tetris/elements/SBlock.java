package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SBlock  extends Animatable implements  Interactable {
    public SBlock(Pane pane, int x, int y) {

        super(pane);
        this.pane = pane;
        Globals.objectIsFall = true;
        setX(x);
        setY(y);

        new BodyBlock(pane, x, y-30);
        new BodyBlock(pane, x+31, y-30);
        new BodyBlock(pane, x-31, y);

        setImage(new Image("square.png"));
        pane.getChildren().add(this);
    }


    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
