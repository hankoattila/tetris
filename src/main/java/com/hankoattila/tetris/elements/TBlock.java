package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Interactable;
import com.hankoattila.tetris.Square;
import javafx.scene.layout.Pane;

public class TBlock  extends GameEntity implements Animatable, Interactable {
    protected TBlock(Pane pane) {
        super(pane);
    }

    public void step() {

    }

    public void apply(Square square) {

    }

    public String getMessage() {
        return null;
    }
}
