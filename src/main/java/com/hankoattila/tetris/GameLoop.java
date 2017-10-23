package com.hankoattila.tetris;

import com.hankoattila.tetris.entities.Animatable;
import com.hankoattila.tetris.entities.Block;
import com.hankoattila.tetris.entities.GameEntity;
import com.hankoattila.tetris.entities.Interactable;
import javafx.animation.AnimationTimer;


public class GameLoop extends AnimationTimer {
    private int tetrisSpeed = 0;
    private int rotation = 0;

    public void handle(long now) {
        tetrisSpeed++;
        rotation++;

        if (rotation >= 30) {

            for (GameEntity gameObject : Globals.gameObjects) {
                if (gameObject instanceof Block) {
                    ((Block) gameObject).changePosition();
                }
            }
            rotation = 0;
        }
        if (tetrisSpeed >= Globals.speed) {

            for (GameEntity gameObject : Globals.gameObjects) {
                if (gameObject.isOutOfBottomBound() || gameObject.isObjectUnder()) {
                    ((Interactable) gameObject).apply();
                }
            }

            for (GameEntity gameObject : Globals.gameObjects) {
                if (gameObject instanceof Animatable) {
                    Animatable animObject = (Animatable) gameObject;
                    if (gameObject instanceof Block) {
                        ((Block) gameObject).changePosition();
                    }
                    animObject.step();

                }
            }
            tetrisSpeed = 0;
        }
        Globals.gameObjects.addAll(Globals.newGameObjects);
        Globals.newGameObjects.clear();

        Globals.gameObjects.removeAll(Globals.oldGameObjects);
        Globals.oldGameObjects.clear();

    }
}
