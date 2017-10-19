package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class JBlock extends Animatable implements  Interactable {

    public JBlock(Pane pane, int x, int y) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        block.add(this);
        block.add(new BodyBlock(pane, x, y-Globals.BLOCK_SIZE));
        block.add(new BodyBlock(pane, x-Globals.BLOCK_SIZE, y-Globals.BLOCK_SIZE));
        block.add(new BodyBlock(pane, x-62, y-Globals.BLOCK_SIZE));

        setImage(new Image("square.png"));
        pane.getChildren().add(this);



    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
