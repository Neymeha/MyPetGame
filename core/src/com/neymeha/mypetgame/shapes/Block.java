package com.neymeha.mypetgame.shapes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.neymeha.mypetgame.interact.EventList;

public class Block {

    public int x,y,width,height,special_grade;
    public boolean destroyed,special;
    private EventList event;
    Color blockColor;
    public EventBall eventBall;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setEvent(EventList event) {
        this.event = event;
    }

    public EventList getEvent() {
        return event;
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }

}
