package com.demo.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Manan on 8/29/2017.
 */

public class Walls {

    LinkedList<Wall> walls;

    public Walls(){
        init();
    }

    public void init(){
        walls = new LinkedList<Wall>();
        walls.add(new Wall());
    }

    public void render(ShapeRenderer renderer){
        for(Wall w: walls){
            w.render(renderer);
        }
    }

    public void update(float delta, Player player){
        if( walls.getLast().position.x < C.WORLD_WIDTH*2/3 ){
             walls.add(new Wall((float)Math.random()*C.MAX_INTERWALL_DISTANCE + C.WORLD_WIDTH));
        }
        if(walls.getFirst().position.x + C.WALL_WIDTH<0) { walls.poll();}

        for(Wall w: walls){
            w.update(delta, player);
        }
    }


}
