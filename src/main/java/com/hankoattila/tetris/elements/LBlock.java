package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Interactable;
import javafx.scene.layout.Pane;

public class LBlock  extends Animatable implements  Interactable {
    public LBlock(Pane pane, int i, int i1) {
        super(pane);
    }


    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
