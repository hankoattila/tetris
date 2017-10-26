package com.hankoattila.tetris;

import com.hankoattila.tetris.entities.GameEntity;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Globals {

    public static final int speedBoost =  5;
    public static final int speedLimit = 80;
    public static int speed = 80;
    public static int WIDTH = 12;
    public static int HEIGHT = 20;
    public static final int BLOCK_SIZE = 31;
    public static final int WINDOW_WIDTH = BLOCK_SIZE * WIDTH;
    public static final int WINDOW_HEIGHT = BLOCK_SIZE * HEIGHT;
    public static final int END_OF_WINDOW = WINDOW_HEIGHT - BLOCK_SIZE;
    public static boolean gameOver = false;
    public static List<Enum> blocks = new ArrayList<Enum>();
    public static List<Integer> removeLine = new ArrayList<>();
    public static HashMap<Point2D, String> positions = new HashMap<>();
    public static List<GameEntity> gameObjects = new ArrayList<GameEntity>(); //Holds game object that should be on display.
    public static List<GameEntity> newGameObjects = new ArrayList<GameEntity>(); // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects = new ArrayList<GameEntity>(); // Holds game objects that will be destroyed this frame.
    public static GameLoop gameLoop;

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
