package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class JBlock extends Animatable implements Interactable {

    public JBlock(Pane pane, int x, int y) {
        super(pane);
        this.pane = pane;
        setX(x);
        setY(y);
        blockList.add(this);
        blockList.add(new BodyBlock(pane, x, y - Globals.BLOCK_SIZE, this));
        blockList.add(new BodyBlock(pane, x - Globals.BLOCK_SIZE, y - Globals.BLOCK_SIZE, this));
        blockList.add(new BodyBlock(pane, x - 62, y - Globals.BLOCK_SIZE, this));
        setImage(new Image("square.png"));
        pane.getChildren().add(this);

    }


}
