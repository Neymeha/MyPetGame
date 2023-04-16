package com.neymeha.mypetgame.shapes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    public float x=0; // местоположение по горизонтали
    public float y=0; // местоположение по вертикали
    public float height=10; // высота отбивающей поверхности
    public float width=80; // длина отбивающей поверхности
    public float division_x;

    public Paddle() { // конструктор для отбивающей поверхности параметры будут стандартными
        division_x =(float) (width /12.0);
    }

    public void move() {
        x=Gdx.input.getX()-(width/2); // изменение по горизонтале фиксируются по центру отбивающей поверхности, и ослеживается по курсору
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x,y,width,height); // отрисовываем стандартную отбивающую поверхность
    }
}
