package com.demo.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Manan on 8/29/2017.
 */

public class Wall {

    Vector2 position;
    Vector2 velocity;
    float holePosition;
    float holeLength;
    boolean passed = false;

    public Wall(){
        init(C.WORLD_WIDTH);
    }

    public Wall(float posX) { init(posX);}

    public void init(float posX){
        position = new Vector2(posX,0);
        velocity = new Vector2(C.WALL_VELOCITY,0);
        holePosition = (float)Math.random()*(C.WORLD_HEIGHT - C.HOLE_MAX_SIZE);
        holeLength = (float)Math.random()*(C.HOLE_MAX_SIZE-C.HOLE_MIN_SIZE) + C.HOLE_MIN_SIZE;
    }

    public void update(float delta, Player player){
        position.x += delta*velocity.x;
        position.y += delta*velocity.y;
    }

    public boolean collision(Player player){
        Rectangle playerRect = new Rectangle(player.position.x,player.position.y,C.PLAYER_WIDTH,C.PLAYER_HEIGHT);
        Rectangle first = new Rectangle(position.x,position.y,C.WALL_WIDTH,holePosition);
        Rectangle second = new Rectangle(position.x, holePosition+holeLength,C.WALL_WIDTH, C.WORLD_HEIGHT - (holeLength + holePosition));
        return Intersector.overlaps(playerRect,first) || Intersector.overlaps(playerRect,second);
    }


    public void render(ShapeRenderer renderer){
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(C.WALL_COLOR);
        renderer.rect(position.x,position.y, C.WALL_WIDTH, C.WORLD_HEIGHT);
        renderer.setColor(Color.WHITE);
        renderer.rect(position.x,holePosition,C.WALL_WIDTH,holeLength);
    }


}
