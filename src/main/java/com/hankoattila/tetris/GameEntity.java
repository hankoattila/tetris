package com.hankoattila.tetris;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class GameEntity extends ImageView {
    protected Pane pane;

    public List<GameEntity> getBlockList() {
        return blockList;
    }

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

    protected boolean outOfLeftBound(){
        boolean outOfLeftBound = false;
        for (GameEntity gameEntity: blockList){
            if (gameEntity.getX()-Globals.BLOCK_SIZE <0){
                outOfLeftBound = true;
            }
        }
        return outOfLeftBound;
    }
    protected boolean outOfRightBound(){
        boolean outOfRightBound = false;

        for (GameEntity gameEntity: blockList){
            if (gameEntity.getX()+Globals.BLOCK_SIZE >=Globals.WINDOW_WIDTH){
                outOfRightBound = true;
            }
        }
        System.out.println(outOfRightBound);
        return outOfRightBound;
    }

    protected boolean isOutOfoutOfBottomBound() {
        if (getY() >= Globals.END_OF_WINDOW) {
            return true;
        }
        return false;
    }


}
