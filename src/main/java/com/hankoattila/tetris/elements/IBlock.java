package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;



public class IBlock extends Animatable implements Interactable {

    public IBlock(Pane pane, int x, int y) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        int length = Globals.BLOCK_SIZE;
        block.add(this);
        for (int i = 0; i < 3; i++) {
            block.add(new BodyBlock(pane,x,y-length));
            length+=Globals.BLOCK_SIZE;
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
