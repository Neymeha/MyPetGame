package com.neymeha.mypetgame.interact;

import com.badlogic.gdx.graphics.Color;
import com.neymeha.mypetgame.shapes.Ball;
import com.neymeha.mypetgame.shapes.Block;
import com.neymeha.mypetgame.shapes.EventBall;

import java.util.ArrayList;
import java.util.Random;

public class Event {
    public static boolean dragonball_event_running;
    public static boolean multiply_event_running;
    public static Random r=new Random();
    public static Block b;
    public static ArrayList <Ball> balls;

    public static void makeSpecial(ArrayList<Block> listOfBlocks){
        for (int i=1; i<11; i++) {
            b=listOfBlocks.get(r.nextInt(1,71));
            b.special_grade=r.nextInt(1,2);
            b.special=true;
            if (b.special_grade==2) {
                b.setEvent(EventList.DRAGONBALL);
                b.eventBall=new EventBall((b.x+b.x+b.width)/2, (b.y+b.y+b.height)/2, b.getEvent());
                b.eventBall.color= Color.RED;
            }
            if (b.special_grade==1) {
                b.setEvent(EventList.MULTIPLY);
                b.eventBall=new EventBall((b.x+b.x+b.width)/2, (b.y+b.y+b.height)/2, b.getEvent());
                b.eventBall.color= Color.BLUE;
            }
        }
    }

//    public static void eventStart(EventBall eventBall, Ball ball, ShapeRenderer shapeRenderer){
//        if (eventBall.event==EventList.DRAGONBALL) {
//            ball.ySpeed *= 2;
//            s=System.currentTimeMillis();
//            e=System.currentTimeMillis()+10000;
//        }
//        if (eventBall.event==EventList.MULTIPLY) {
//            s=System.currentTimeMillis();
//            e=System.currentTimeMillis()+10000;
//            for (int i=-3; i<4; i++) {
//                for (int j=-3; j<4; j++) {
//                    if (i!=0 && j!=0) {balls.add(new Ball(ball.x, ball.y, ball.size, i,j));}
//                }
//            }
//        }
//        if (!Event.balls.isEmpty()) {
//            for (Ball mball: balls){
//                mball.draw(shapeRenderer);
//                mball.update();
//            }
//        }
//
//    }
//
//    public static void eventEnd(Ball ball){
//
//        if (s+10000<=e) {
//            if (dragonball_event_running){
//                Event.dragonball_event_running=false;
//                ball.ySpeed/=2;
//            }
//            if (multiply_event_running){
//                Event.multiply_event_running=false;
//                balls.clear();
//            }
//        }
//    }

}

