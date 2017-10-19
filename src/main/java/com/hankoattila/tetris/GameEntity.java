package com.hankoattila.tetris;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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

    protected boolean isOutOfBounds() {
        if (getX() > 500|| getX() < 10 ||
                getY() >= Globals.END_OF_WINDOW) {
            return true;
        }
        return false;
    }


}
