package com.hankoattila.tetris.entities;

import com.hankoattila.tetris.Globals;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.Random;

public class Block extends GameEntity implements Interactable, Animatable {
    private boolean leftKeyDown = false;
    private boolean rightKeyDown = false;
    private boolean downKeyDown = false;
    private boolean switchKey = false;
    protected String image;


    protected Block(Pane pane, String image) {
        super(pane);
        this.image = image;
        initEventHandlers(pane, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.DOWN, KeyCode.UP);

    }

    public void changePosition() {
        Globals.speed = Globals.speedLimit;
        if (switchKey) {
            if (blockList.size() > 0) {
                if (isEmptyLeftPosition() && !outOfLeftBound() && !outOfRightBound() && !isOutOfBottomBound()) {
                    switchPositions();
                }
                switchKey = false;
            }
        }
        if (leftKeyDown) {
            if (!outOfLeftBound() && isEmptyLeftPosition()) {
                for (GameEntity gameEntity : blockList) {
                    gameEntity.setX(gameEntity.getX() - Globals.BLOCK_SIZE);
                }
            }
        }
        if (rightKeyDown) {
            if (!outOfRightBound() && isEmptyRightPosition()) {

                for (GameEntity gameEntity : blockList) {
                    gameEntity.setX(gameEntity.getX() + Globals.BLOCK_SIZE);
                }
            }
        }
        if (downKeyDown) {
            Globals.speed = Globals.speedBoost;
        }

    }

    public void step() {
        if (blockList.size() != 0){
            for (GameEntity gameEntity : blockList) {
                gameEntity.setY(gameEntity.getY() + Globals.BLOCK_SIZE);
            }
        }
    }

    public void apply() {
        if (blockList.size() != 0) {
            Globals.removeLine.clear();
            int blockLength = blockList.size();
            for (int i = 0; i < blockLength; i++) {
                int x = (int) blockList.get(0).getX();
                int y = (int) blockList.get(0).getY();
                Globals.positions.put(new Point2D(x, y), image);
                new TableBlock(pane, x, y, this.image);
                blockList.get(0).destroy();
                blockList.remove(0);
            }
            FullLineChecking();
            if (Globals.removeLine.size() > 0) {

                setBlockNewPosition();
            }
            Random rnd = new Random();
            BlockTypes.createNewBlock(rnd.nextInt(Globals.blocks.size()), pane);
        }
    }

    protected void switchPositions() {
        int Px = (int) blockList.get(0).getX();
        int Py = (int) blockList.get(0).getY();

        for (GameEntity block : blockList) {

            int Vx = (int) block.getX();
            int Vy = (int) block.getY();

            int Vrx = Vx - Px;
            int Vry = Vy - Py;

            int Rx1 = 0;
            int Ry1 = 1;
            int Rx2 = -1;
            int Ry2 = 0;


            int Vtx = Rx1 * Vrx + Rx2 * Vry;
            int Vty = Ry1 * Vrx + Ry2 * Vry;
            int V1 = Px + Vtx;
            int V2 = Py + Vty;
            block.setX(V1);
            block.setY(V2);
        }
    }

    private void FullLineChecking() {
        for (int y = Globals.END_OF_WINDOW; y > 0; y -= Globals.BLOCK_SIZE) {
            int lineItemCounter = 0;
            for (int x = 0; x < Globals.WINDOW_WIDTH; x += Globals.BLOCK_SIZE) {
                if (Globals.positions.containsKey(new Point2D(x, y))) {
                    lineItemCounter++;
                }
            }
            if (lineItemCounter == Globals.WIDTH) {
                Globals.removeLine.add(y);
            }

        }
    }

    private void setBlockNewPosition() {

        for (int y : Globals.removeLine) {
            for (int x = 0; x < Globals.WINDOW_WIDTH; x += Globals.BLOCK_SIZE) {
                Globals.positions.remove(new Point2D(x, y));
                new TableBlock(pane, x, y, "bcg.jpg");
            }
        }
        int start = Collections.max(Globals.removeLine) - Globals.BLOCK_SIZE;
        for (int y = start; y > 0; y -= Globals.BLOCK_SIZE) {
            for (int x = 0; x < Globals.WINDOW_HEIGHT; x += Globals.BLOCK_SIZE) {
                if (Globals.positions.containsKey(new Point2D(x, y))) {
                    new TableBlock(pane, x, y, "bcg.jpg");
                    String picture = Globals.positions.get(new Point2D(x, y));
                    Globals.positions.remove(new Point2D(x, y));
                    Globals.positions.put(new Point2D(x, y + Globals.BLOCK_SIZE * Globals.removeLine.size()), picture);
                    new TableBlock(pane, x, y + Globals.BLOCK_SIZE * Globals.removeLine.size(), picture);
                }
            }

        }

    }

    protected void initEventHandlers(Pane pane,
                                     final KeyCode leftCode,
                                     final KeyCode rightCode,
                                     final KeyCode downCode,
                                     final KeyCode switchCode) {

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
                } else if (downCode == event.getCode()) {
                    downKeyDown = true;
                } else if (switchCode == event.getCode()) {
                    switchKey = true;
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

            }
            if (rightCode == event.getCode()) {
                rightKeyDown = false;

            } else if (downCode == event.getCode()) {
                downKeyDown = false;
            }
        });
    }
}
