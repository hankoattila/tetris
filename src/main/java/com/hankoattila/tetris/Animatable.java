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
        if (isOutOfBounds() || Globals.positions.contains(new Point2D(getX(),getY()+Globals.BLOCK_SIZE))) {
            int blockLength = block.size();
            for (int i = 0; i < blockLength; i++) {
                Globals.positions.add(new Point2D(block.get(0).getX(),block.get(0).getY()));
                block.get(0).destroy();
                block.remove(0);
            }
            for (Point2D point2D: Globals.positions){
                new BlockDown(pane,point2D.getX(),point2D.getY());
            }
            Random rnd = new Random();
            Blocks.createNewBlock(rnd.nextInt(Globals.blocks.size()), pane);
        } else {
            setY(getY() + Globals.BLOCK_SIZE);
        }
    }

}