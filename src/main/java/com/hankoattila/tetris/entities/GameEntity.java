package com.hankoattila.tetris.entities;

import com.hankoattila.tetris.Globals;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class GameEntity extends ImageView {
    protected Pane pane;

    protected GameEntity(Pane pane) {
        this.pane = pane;
        // add to the main loop.
        Globals.addGameObject(this);
    }

    public void destroy() {
        if (getParent() != null) {
            pane.getChildren().remove(this);
        }
        Globals.removeGameObject(this);
    }

    public boolean isOutOfBottomBound() {
        if (getY() >= Globals.END_OF_WINDOW) {
            return true;
        }
        return false;
    }


    public abstract boolean isEmptyDownPosition();

    protected abstract boolean isEmptyLeftPosition();

    protected abstract boolean isEmptyRightPosition();

    protected abstract boolean outOfLeftBound();

    protected abstract boolean outOfRightBound();


}
