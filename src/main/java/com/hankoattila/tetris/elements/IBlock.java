package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Interactable;
import com.hankoattila.tetris.Square;
import javafx.scene.layout.Pane;

public class IBlock  extends GameEntity implements Animatable, Interactable   {

    protected IBlock(Pane pane) {
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
