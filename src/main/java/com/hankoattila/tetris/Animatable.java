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
    protected boolean leftKeyDown = false;
    protected boolean rightKeyDown = false;
    protected boolean downKeyDown = false;
    protected String image;

    protected Animatable(Pane pane, String image) {
        super(pane);
        this.image = image;
        initEventHandlers(pane, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.DOWN);

    }

    public void step() {
        Globals.speed = Globals.speedLimit;
        if (leftKeyDown && !outOfLeftBound() && isEmptyLeftPosition()) {
            for (GameEntity gameEntity : blockList) {
                gameEntity.setX(gameEntity.getX() - Globals.BLOCK_SIZE);
            }
            move();
        } else if (rightKeyDown && !outOfRightBound() && isEmptyRightPosition()) {
            for (GameEntity gameEntity : blockList) {
                gameEntity.setX(gameEntity.getX() + Globals.BLOCK_SIZE);
            }
            move();

        } else if (downKeyDown) {
            Globals.speed = Globals.speedBoost;
            move();
        } else {
            move();
        }
    }

    public void apply() {
        if (blockList.size() != 0) {
            int blockLength = blockList.size();
            for (int i = 0; i < blockLength; i++) {
                Globals.positions.put(new Point2D(blockList.get(0).getX(), blockList.get(0).getY()), image);
                new BlockDown(pane, blockList.get(0).getX(), blockList.get(0).getY(), this.image);
                blockList.get(0).destroy();
                blockList.remove(0);
            }

            int y = Globals.END_OF_WINDOW;
            for (int i = y; i > 0; i -= Globals.BLOCK_SIZE) {
                int counter = 0;
                for (int x = 0; x < Globals.WINDOW_WIDTH; x += Globals.BLOCK_SIZE) {
                    if (Globals.positions.containsKey(new Point2D(x, i))) {
                        counter++;
                    }
                }
                if (counter == Globals.WIDTH) {
                    System.out.println(i);
                    for (int x = 0; x < Globals.WINDOW_WIDTH; x += Globals.BLOCK_SIZE) {
                        new BlockDown(pane,x,i,"bcg.jpg");
                        Globals.positions.remove(new Point2D(x, i));
                    }

                }
            }

            Random rnd = new Random();
            Blocks.createNewBlock(rnd.nextInt(Globals.blocks.size()), pane);
        }

    }

    protected void initEventHandlers(Pane pane, final KeyCode leftCode, final KeyCode rightCode, final KeyCode downCode) {
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

            } else if (downCode == event.getCode()) {
                downKeyDown = false;
            }
        });
    }
}