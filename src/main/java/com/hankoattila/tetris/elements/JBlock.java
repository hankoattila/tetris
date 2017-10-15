package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class JBlock extends GameEntity implements Animatable, Interactable {

    protected JBlock(Pane pane, int xc, int yc) {
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

    public void step() {
        setY(getY() + 4);
        if (isOutOfBounds()) {
            destroy();
            new IBlock(pane, 200, 0);
        }

    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
