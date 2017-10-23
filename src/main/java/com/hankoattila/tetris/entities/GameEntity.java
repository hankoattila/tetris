package com.hankoattila.tetris.entities;

import com.hankoattila.tetris.Globals;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class GameEntity extends ImageView {
    protected Pane pane;


    protected List<GameEntity> blockList = new ArrayList<GameEntity>();

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


    public boolean isObjectUnder() {
        boolean isObjectUnder = false;
        for (GameEntity gameEntity : blockList) {
            if (Globals.positions.containsKey(new Point2D(gameEntity.getX(), gameEntity.getY() + Globals.BLOCK_SIZE))) {
                isObjectUnder = true;
                break;
            }
        }
        return isObjectUnder;
    }

    protected boolean isEmptyLeftPosition() {
        boolean isEmpty = true;
        for (GameEntity gameEntity : blockList) {
            if (Globals.positions.containsKey(new Point2D(gameEntity.getX() - Globals.BLOCK_SIZE, gameEntity.getY() + Globals.BLOCK_SIZE))) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    protected boolean isEmptyRightPosition() {
        boolean isEmpty = true;
        for (GameEntity gameEntity : blockList) {
            if (Globals.positions.containsKey(new Point2D(gameEntity.getX() + Globals.BLOCK_SIZE, gameEntity.getY() + Globals.BLOCK_SIZE))) {
                isEmpty = false;
                break;

            }
        }
        return isEmpty;
    }

    protected boolean outOfLeftBound() {
        boolean outOfLeftBound = false;
        for (GameEntity gameEntity : blockList) {
            if (gameEntity.getX() - Globals.BLOCK_SIZE < 0) {
                outOfLeftBound = true;
                break;

            }
        }
        return outOfLeftBound;
    }

    protected boolean outOfRightBound() {
        boolean outOfRightBound = false;

        for (GameEntity gameEntity : blockList) {
            if (gameEntity.getX() + Globals.BLOCK_SIZE >= Globals.WINDOW_WIDTH) {
                outOfRightBound = true;
                break;
            }
        }
        return outOfRightBound;
    }

    public boolean isOutOfBottomBound() {
        if (getY() >= Globals.END_OF_WINDOW) {
            return true;
        }
        return false;
    }


}
