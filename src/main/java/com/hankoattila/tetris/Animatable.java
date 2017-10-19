package com.hankoattila.tetris;


import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

// Interface for animated game entities. If a GameEntity implements this, the step() method will be called
// 60 times per second.
public abstract class Animatable extends GameEntity implements Interactable {
    protected Animatable(Pane pane) {
        super(pane);
    }


    public void step() {
        setY(getY() + Globals.BLOCK_SIZE);
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

}