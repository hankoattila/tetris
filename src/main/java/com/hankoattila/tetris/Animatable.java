package com.hankoattila.tetris;


import javafx.scene.layout.Pane;

import java.util.Random;

// Interface for animated game entities. If a GameEntity implements this, the step() method will be called
// 60 times per second.
public abstract class Animatable extends GameEntity implements Interactable {
    protected Animatable(Pane pane) {
        super(pane);
    }


    public void step() {
        setY(getY() + 4);
        if (isOutOfBounds()) {
            new BlockDown(pane,getX(),getY());
            destroy();
            Random rnd = new Random();
            Blocks.createNewBlock(rnd.nextInt(Globals.blocks.size()), pane);
        }
    }

}