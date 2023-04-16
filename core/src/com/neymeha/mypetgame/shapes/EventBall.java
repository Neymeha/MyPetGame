package com.neymeha.mypetgame.shapes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.neymeha.mypetgame.interact.EventList;

public class EventBall {
    public int x; // местоположения мяча по горизонтали по пикселям
    public int y; // местоположения мяча по вертикали по пикселям
    public int size=10; // размер мяча
    public int ySpeed=3; // скорость передвижения по пикселям по вертикали
    public EventList event;
    public Color color;

    public void update() { // метод для движения мяча
        y -= ySpeed; // передвижения по вертикали
    }

    public EventBall(int x, int y, EventList event) {
        this.x = x;
        this.y = y;
        this.event = event;
    }

    public void draw(ShapeRenderer shape) { // метод создание нашего шара с помощью ShapeRenderer
        shape.circle(x, y, size);
        shape.setColor(color);
    }
}
