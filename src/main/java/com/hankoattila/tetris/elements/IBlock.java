package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class IBlock extends Animatable implements Interactable {

    public IBlock(Pane pane, int x, int y) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        int length = Globals.BLOCK_SIZE;
        blockList.add(this);
        for (int i = 0; i < 3; i++) {
            blockList.add(new BodyBlock(pane, x, y - length, this));
            length += Globals.BLOCK_SIZE;
        }
        setImage(new Image("square.png"));
        pane.getChildren().add(this);
    }



    public String getMessage() {
        return null;
    }
}
