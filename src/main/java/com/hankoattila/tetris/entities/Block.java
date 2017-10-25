package com.hankoattila.tetris.entities;

import com.hankoattila.tetris.Globals;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Block extends GameEntity implements Interactable, Animatable {
    private boolean leftKeyDown = false;
    private boolean rightKeyDown = false;
    private boolean downKeyDown = false;
    private boolean switchKey = false;
    protected String image;
    protected List<GameEntity> blockList = new ArrayList<GameEntity>();


    protected Block(Pane pane, String image) {
        super(pane);
        this.image = image;
        initEventHandlers(pane, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.DOWN, KeyCode.UP);

    }

    public void step() {
        if (blockList.size() != 0) {
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
                blockList.get(0).setImage(null);
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

    public void changePosition() {
        Globals.speed = Globals.speedLimit;
        if (switchKey) {
            if (blockList.size() > 0) {
                rotateBlock();
            }
            switchKey = false;
        }
        if (leftKeyDown) {
            if (!outOfLeftBound() && isEmptyLeftPosition() && !isOutOfBottomBound() && isEmptyDownPosition()) {
                for (GameEntity gameEntity : blockList) {
                    gameEntity.setX(gameEntity.getX() - Globals.BLOCK_SIZE);
                }
            }
        }
        if (rightKeyDown) {
            if (!outOfRightBound() && isEmptyRightPosition() && !isOutOfBottomBound() && isEmptyDownPosition()) {

                for (GameEntity gameEntity : blockList) {
                    gameEntity.setX(gameEntity.getX() + Globals.BLOCK_SIZE);
                }
            }
        }
        if (downKeyDown) {
            Globals.speed = Globals.speedBoost;
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


    public Point2D rotate(Point2D center, Point2D objectPosition) {
        int Px = (int) center.getX();
        int Py = (int) center.getY();
        int Vx = (int) objectPosition.getX();
        int Vy = (int) objectPosition.getY();

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
        return new Point2D(V1, V2);
    }

    protected void rotateBlock() {
        int Px = (int) blockList.get(0).getX();
        int Py = (int) blockList.get(0).getY();
        Point2D center = new Point2D(Px, Py);
        if (isRotateOutOfLeftBound() && isEmptyRightPosition()) {
            for (GameEntity block : blockList) {
                Point2D newPosition = rotate(center, new Point2D(block.getX(), block.getY()));
                block.setX(newPosition.getX() + Globals.BLOCK_SIZE);
                block.setY(newPosition.getY());
            }
        } else if (isRotateOutOfRightBound() && isEmptyLeftPosition()) {
            for (GameEntity block : blockList) {
                Point2D newPosition = rotate(center, new Point2D(block.getX(), block.getY()));
                block.setX(newPosition.getX() - Globals.BLOCK_SIZE);
                block.setY(newPosition.getY());
            }
        } else if (isEmptyRightPosition() && isEmptyLeftPosition() &&
                isEmptyDownPosition() && !isRotateInOtherObject() &&
                !isRotateOutOfBottomBound()) {

            for (GameEntity block : blockList) {
                Point2D newPosition = rotate(center, new Point2D(block.getX(), block.getY()));
                block.setX(newPosition.getX());
                block.setY(newPosition.getY());
            }
        }

    }

    protected boolean isRotateOutOfBottomBound() {
        int Px = (int) blockList.get(0).getX();
        int Py = (int) blockList.get(0).getY();
        Point2D center = new Point2D(Px, Py);
        boolean rotateOutOfBottomBound = false;
        for (GameEntity block : blockList) {
            Point2D newPosition = rotate(center, new Point2D(block.getX(), block.getY()));
            if (newPosition.getY() >= Globals.END_OF_WINDOW) {
                rotateOutOfBottomBound = true;
            }
        }
        return rotateOutOfBottomBound;

    }

    protected boolean isRotateInOtherObject() {
        int Px = (int) blockList.get(0).getX();
        int Py = (int) blockList.get(0).getY();
        Point2D center = new Point2D(Px, Py);
        boolean rotateInOtherObject = false;
        for (GameEntity block : blockList) {
            Point2D newPosition = rotate(center, new Point2D(block.getX(), block.getY()));
            if (Globals.positions.containsKey(newPosition)) {
                rotateInOtherObject = true;
            }
        }
        return rotateInOtherObject;

    }

    protected boolean isRotateOutOfRightBound() {
        int Px = (int) blockList.get(0).getX();
        int Py = (int) blockList.get(0).getY();
        Point2D center = new Point2D(Px, Py);
        boolean outOfLeftBound = false;
        for (GameEntity block : blockList) {
            Point2D newPosition = rotate(center, new Point2D(block.getX(), block.getY()));
            if (newPosition.getX() >= Globals.WINDOW_WIDTH) {
                outOfLeftBound = true;
            }
        }
        return outOfLeftBound;

    }

    protected boolean isRotateOutOfLeftBound() {
        int Px = (int) blockList.get(0).getX();
        int Py = (int) blockList.get(0).getY();
        Point2D center = new Point2D(Px, Py);
        boolean outOfLeftBound = false;
        for (GameEntity block : blockList) {
            Point2D newPosition = rotate(center, new Point2D(block.getX(), block.getY()));
            if (newPosition.getX() < 0) {
                outOfLeftBound = true;
            }
        }
        return outOfLeftBound;
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

    @Override
    public boolean isEmptyDownPosition() {
        boolean isObjectUnder = true;
        for (GameEntity gameEntity : blockList) {
            if (Globals.positions.containsKey(new Point2D(gameEntity.getX(), gameEntity.getY() + Globals.BLOCK_SIZE))) {
                isObjectUnder = false;
                break;
            }
        }
        return isObjectUnder;
    }

    @Override
    protected boolean isEmptyLeftPosition() {
        boolean isEmpty = true;
        for (GameEntity gameEntity : blockList) {
            if (Globals.positions.containsKey(new Point2D(gameEntity.getX() - Globals.BLOCK_SIZE, gameEntity.getY() + Globals.BLOCK_SIZE))) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    @Override
    protected boolean isEmptyRightPosition() {
        boolean isEmpty = true;
        for (GameEntity gameEntity : blockList) {
            if (Globals.positions.containsKey(new Point2D(gameEntity.getX() + Globals.BLOCK_SIZE, gameEntity.getY() + Globals.BLOCK_SIZE))) {
                isEmpty = false;
                break;

            }
        }
        return isEmpty;
    }

    @Override
    protected boolean outOfLeftBound() {
        boolean outOfLeftBound = false;
        for (GameEntity gameEntity : blockList) {
            if (gameEntity.getX() - Globals.BLOCK_SIZE < 0) {
                outOfLeftBound = true;
                break;

            }
        }
        return outOfLeftBound;
    }

    @Override
    protected boolean outOfRightBound() {
        boolean outOfRightBound = false;

        for (GameEntity gameEntity : blockList) {
            if (gameEntity.getX() + Globals.BLOCK_SIZE >= Globals.WINDOW_WIDTH) {
                outOfRightBound = true;
                break;
            }
        }
        return outOfRightBound;
    }
}
