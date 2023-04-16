package com.neymeha.mypetgame.shapes;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Random;


public class Ball{

    public int x; // местоположения мяча по горизонтали по пикселям
    public int y; // местоположения мяча по вертикали по пикселям
    public int size; // размер мяча
    public int xSpeed; // скорость передвижения по пикселям по горизонатли
    public int ySpeed; // скорость передвижения по пикселям по вертикали
    public int nx;
    private static Random r=new Random();
    public boolean destroyed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) { // констукртор мяча
        this.x = x+size;
        this.y = y+size;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        nx= (int) (Math.sqrt(2*size*size)-size);
    }

    public void update() { // метод для движения мяча
        x += xSpeed; // передвижение по горизонтали
        y += ySpeed; // передвижения по вертикали
        if (x-size < 0 || x+size > Gdx.graphics.getWidth()) { // условия для передвижения по горизонтали, если шар выходит за рамки по горизонтали то он меняет направление движения по горизонтали
            xSpeed = -xSpeed; // способ выполнения условия
        }
        if (y+size > Gdx.graphics.getHeight()) { // условия для передвижения по вертикали, если шар выходит за рамки по вертикали то он меняет направление движения по вертикали
            ySpeed = -ySpeed; // способ выполнения условия
        }
        if (y-size < 0) {
            destroyed=true;
        }
    }

    public void draw(ShapeRenderer shape) { // метод создание нашего шара с помощью ShapeRenderer
        shape.circle(x, y, size);
    }

    public static ArrayList<Ball> ballFactory(Ball ball) {
        ArrayList<Ball>balls=new ArrayList<>();
        for (int i=-2;i<3;i++){
                if (i!=0) {
                    balls.add(new Ball(ball.x,ball.y,ball.size, r.nextInt(1,3)*i, r.nextInt(1,3)*i));
                }
        }
        return balls;
    }

}

