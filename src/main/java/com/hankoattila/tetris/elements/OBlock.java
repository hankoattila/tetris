package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Interactable;
import javafx.scene.layout.Pane;

public class OBlock  extends GameEntity implements Animatable, Interactable {
    protected OBlock(Pane pane) {
        super(pane);
    }

    public void step() {

    }

    public void apply(GameEntity block) {

    }

    public String getMessage() {
        return null;
    }
}
