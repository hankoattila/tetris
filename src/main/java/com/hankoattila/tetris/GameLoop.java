package com.hankoattila.tetris;

import javafx.animation.AnimationTimer;


public class GameLoop extends AnimationTimer {
    private  int tetrisStep = 0;

    public void handle(long now) {
        tetrisStep++;
        if (tetrisStep == Globals.speed){

            for (GameEntity gameObject : Globals.gameObjects) {
                if (gameObject instanceof Animatable) {
                    Animatable animObject = (Animatable) gameObject;
                    animObject.step();
                }
            }
            tetrisStep = 0;
        }

        Globals.gameObjects.addAll(Globals.newGameObjects);
        Globals.newGameObjects.clear();

        Globals.gameObjects.removeAll(Globals.oldGameObjects);
        Globals.oldGameObjects.clear();
    }
}
