package com.neymeha.mypetgame.shapes;

import java.awt.Color;
import java.util.ArrayList;

public class Lives {
    public static int count=3;
    public int x;
    public int y;
    public Color color= Color.RED;

    private Lives(){

    }

    public ArrayList <Lives> livesFactory(){
        ArrayList <Lives> lives = null;
        lives.add(new Lives());
        lives.add(new Lives());
        lives.add(new Lives());
        return lives;
    }

    public void checkGameOver(){
        if (count==0) {

        }
    }
}
