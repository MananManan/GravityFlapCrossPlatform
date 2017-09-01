package com.demo.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Manan on 8/29/2017.
 */

public class Player implements InputProcessor{

    Viewport viewport;
    Vector2 position;
    Vector2 velocity;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init(){
        position = new Vector2(C.PLAYER_START_X, C.PLAYER_START_Y);
        velocity = new Vector2(0,0);
    }

    public void render(ShapeRenderer renderer){
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(C.PLAYER_COLOR);
        renderer.rect(position.x,position.y,C.PLAYER_WIDTH,C.PLAYER_HEIGHT);
    }

    public void update(float delta){

        velocity.y += delta*C.GRAVITY;

        position.x += delta*velocity.x;
        position.y += delta*velocity.y;

        if(velocity.y > C.MAX_VELOCITY){
            velocity.y = C.MAX_VELOCITY;
        }
        if(position.y < C.PLAYER_START_Y){
            position.y = C.PLAYER_START_Y;
            velocity.y = 0;
        }
        if(position.y + C.PLAYER_HEIGHT> C.WORLD_HEIGHT){
            position.y = C.WORLD_HEIGHT -  C.PLAYER_HEIGHT;
            velocity.y = 0;
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 worldPoint = viewport.unproject(new Vector2(screenX,screenY));
        if(worldPoint.x > C.WORLD_WIDTH/2){
            velocity.y = C.JUMP_VELOCITY;
        }
        else{
            C.GRAVITY = -C.GRAVITY;
            C.JUMP_VELOCITY = -C.JUMP_VELOCITY;
        }
        return true;

    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
