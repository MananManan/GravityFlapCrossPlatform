package com.demo.game;


import com.badlogic.gdx.graphics.Color;

/**
 * Created by Manan on 8/29/2017.
 */

public class C {
    public static final Color FONT_COLOR = Color.GREEN;
    public static final float ASPECTRATIO = 16.0f/9;
    public static final float WORLD_HEIGHT = 100f;
    public static final float WORLD_WIDTH = WORLD_HEIGHT*ASPECTRATIO;
    public static final float SCORE_X = WORLD_WIDTH*2/3;
    public static final float SCORE_Y = WORLD_HEIGHT*8/9;
    public static final float PLAYER_HEIGHT = WORLD_HEIGHT/10;
    public static final Color PLAYER_COLOR = Color.YELLOW;
    public static final float PLAYER_WIDTH = WORLD_HEIGHT/10;
    public static final float PLAYER_START_X = WORLD_WIDTH/3;
    public static final float PLAYER_START_Y= 0;
    public static  float GRAVITY = -(WORLD_HEIGHT*4f);
    public static final float MIN_OPENING = 0;
    public static  float JUMP_VELOCITY = 100;
    public static final float MAX_VELOCITY = 150;
    public static final float WALL_WIDTH = PLAYER_WIDTH*2;
    public static final float WALL_VELOCITY = -20;
    public static final Color WALL_COLOR = Color.BLACK;
    public static final float MAX_INTERWALL_DISTANCE = WORLD_WIDTH/6;
    public static final float HOLE_MAX_SIZE = WORLD_HEIGHT/2;
    public static final float HOLE_MIN_SIZE = WORLD_HEIGHT/4;






}
