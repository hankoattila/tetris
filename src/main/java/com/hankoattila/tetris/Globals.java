package com.hankoattila.tetris;

import java.util.Collections;
import java.util.List;

public class Globals {
    public static List<GameEntity> gameObjects; //Holds game object that should be on display.
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static void removeGameObject(GameEntity toRemove) {
        oldGameObjects.add(toRemove);
    }

    public static void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }

}
