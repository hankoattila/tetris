package com.hankoattila.tetris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Globals {
    public static boolean objectIsFall = false;
    public static List<GameEntity> gameObjects = new ArrayList<GameEntity>(); //Holds game object that should be on display.
    public static List<GameEntity> newGameObjects = new ArrayList<GameEntity>(); // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects = new ArrayList<GameEntity>(); // Holds game objects that will be destroyed this frame.
    public static GameLoop gameLoop;
    public static List<Enum> blocks = new ArrayList<Enum>();
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
