package com.hankoattila.tetris.elements;

import com.hankoattila.tetris.Animatable;
import com.hankoattila.tetris.GameEntity;
import com.hankoattila.tetris.Globals;
import com.hankoattila.tetris.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class LBlock extends Animatable implements Interactable {
    public LBlock(Pane pane, int x, int y, String image) {
        super(pane, image);
        this.pane = pane;
        setX(x);
        setY(y);
        blockList.add(this);
        blockList.add(new BodyBlock(pane, x, y - Globals.BLOCK_SIZE, image, this));
        blockList.add(new BodyBlock(pane, x , y + Globals.BLOCK_SIZE, image, this));
        blockList.add(new BodyBlock(pane, x + Globals.BLOCK_SIZE, y + Globals.BLOCK_SIZE, image, this));
        setImage(new Image(this.image));
        pane.getChildren().add(this);

    }

    @Override
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
}
