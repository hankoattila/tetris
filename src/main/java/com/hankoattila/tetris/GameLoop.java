package com.hankoattila.tetris;

import com.hankoattila.tetris.entities.Animatable;
import com.hankoattila.tetris.entities.Block;
import com.hankoattila.tetris.entities.GameEntity;
import com.hankoattila.tetris.entities.TableBlock;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;


public class GameLoop extends AnimationTimer {
    private int tetrisSpeed = 0;
    private int rotation = 0;

    public void handle(long now) {
        tetrisSpeed++;
        rotation++;
        if (!Globals.gameOver) {
            boolean isGameOver = false;
            for (int i = 0; i < Globals.WINDOW_WIDTH; i += Globals.BLOCK_SIZE) {
                Point2D point2D = new Point2D(i, 0);
                if (Globals.positions.containsKey(point2D)) {
                    isGameOver = true;
                    Globals.gameOver = true;
                }

            }

            if (Globals.gameOver){
                for (GameEntity gameObject : Globals.gameObjects) {
                    if (gameObject instanceof Animatable) {
                        Animatable animObject = (Animatable) gameObject;
                        System.out.println("sajt");
                        animObject.step();
                        break;
                    }
                }
            }

            if (rotation >= 10) {
                for (GameEntity gameObject : Globals.gameObjects) {
                    if (gameObject instanceof Block) {
                        ((Block) gameObject).changePosition();
                    }
                }
                rotation = 0;
            }
            if (tetrisSpeed >= Globals.speed) {
                for (GameEntity gameObject : Globals.gameObjects) {
                    if (gameObject instanceof Animatable) {
                        Animatable animObject = (Animatable) gameObject;
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
}
