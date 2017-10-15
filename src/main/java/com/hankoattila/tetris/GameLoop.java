package com.hankoattila.tetris;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    public void handle(long now) {
        for (GameEntity gameObject : Globals.gameObjects) {
            if (gameObject instanceof Animatable) {
                Animatable animObject = (Animatable) gameObject;
                animObject.step();
                if (!Globals.objectIsFall){
                    new Square(Globals.pane,500,500);
                }
            }
        }

        Globals.gameObjects.addAll(Globals.newGameObjects);
        Globals.newGameObjects.clear();

        Globals.gameObjects.removeAll(Globals.oldGameObjects);
        Globals.oldGameObjects.clear();
    }
}
