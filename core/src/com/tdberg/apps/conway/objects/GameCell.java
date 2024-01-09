package com.tdberg.apps.conway.objects;

import space.earlygrey.shapedrawer.ShapeDrawer;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GameCell {
    private boolean isAlive;  // Is this cell currently alive
    private boolean isAliveNextGen;  // Should this cell be alive in the next generation
    private long index;  // Long index of this cell
    private float xPos;
    private float yPos;

    // Not sure if this is going to work at all, but I need some way of setting the width/height of a cell in game units
    private float cellSize = 10;

    public GameCell(final int xPos, final int yPos, final long index) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.index = index;

        isAlive = false;
        isAliveNextGen = false;
    }

    public void setAlive(final boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void render(final Batch batch, final ShapeDrawer drawer) {
        drawer.filledRectangle(xPos, yPos, cellSize, cellSize);
    }
}
