package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class JBlock extends Animatable implements  Interactable {

    public JBlock(Pane pane, int xc, int yc) {
        super(pane);
        this.pane = pane;
        setX(xc);
        setY(yc);
        block.add(this);
        block.add(new BodyBlock(pane, xc, yc-Globals.BLOCK_SIZE));
        block.add(new BodyBlock(pane, xc-Globals.BLOCK_SIZE, yc-Globals.BLOCK_SIZE));
        block.add(new BodyBlock(pane, xc-62, yc-Globals.BLOCK_SIZE));

        setImage(new Image("square.png"));
        pane.getChildren().add(this);



    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
