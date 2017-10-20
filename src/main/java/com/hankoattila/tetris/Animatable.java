package com.hankoattila.tetris;


import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.Random;

// Interface for animated game entities. If a GameEntity implements this, the step() method will be called
// 60 times per second.
public abstract class Animatable extends GameEntity implements Interactable {
    protected Animatable(Pane pane) {
        super(pane);
        initEventHandlers(pane, KeyCode.LEFT, KeyCode.RIGHT);

    }

    protected boolean leftKeyDown = false;
    protected boolean rightKeyDown = false;

    public void step() {
        if (leftKeyDown){
            for (GameEntity gameEntity : blockList) {
                gameEntity.setX(gameEntity.getX() - Globals.BLOCK_SIZE);
            }
        }
        if (rightKeyDown){
            for (GameEntity gameEntity : blockList) {
                gameEntity.setX(gameEntity.getX() + Globals.BLOCK_SIZE);
            }
        }

        for (GameEntity gameEntity : blockList) {
            gameEntity.setY(gameEntity.getY() + Globals.BLOCK_SIZE);
        }
    }

    public void apply() {
        if (blockList.size() != 0) {
            int blockLength = blockList.size();
            for (int i = 0; i < blockLength; i++) {
                Globals.positions.add(new Point2D(blockList.get(0).getX(), blockList.get(0).getY()));
                blockList.get(0).destroy();
                blockList.remove(0);
            }
            for (Point2D point2D : Globals.positions) {
                new BlockDown(pane, point2D.getX(), point2D.getY());
            }
            Random rnd = new Random();
            Blocks.createNewBlock(rnd.nextInt(Globals.blocks.size()), pane);
        }

    }

    protected void initEventHandlers(Pane pane, final KeyCode leftCode, final KeyCode rightCode) {
        //EventHandler has to be chained to each other due to only one can be set
        final EventHandler oldKeyPressedHandler = pane.getScene().getOnKeyPressed();
        pane.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (oldKeyPressedHandler != null) {
                    oldKeyPressedHandler.handle(event);
                }
                if (leftCode == event.getCode()) {
                    leftKeyDown = true;

                } else if (rightCode == event.getCode()) {
                    rightKeyDown = true;
                }
            }
        });
        EventHandler keyReleasedEventHandler = pane.getScene().getOnKeyReleased();
        pane.getScene().setOnKeyReleased(event -> {
            if (keyReleasedEventHandler != null) {
                keyReleasedEventHandler.handle(event);
            }
            if (leftCode == event.getCode()) {
                leftKeyDown = false;

            } else if (rightCode == event.getCode()) {
                rightKeyDown = false;

            }
        });
    }
}