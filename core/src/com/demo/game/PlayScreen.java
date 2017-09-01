package com.demo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Manan on 8/29/2017.
 */

public class PlayScreen extends ScreenAdapter {

    ShapeRenderer renderer;
    Viewport viewport;
    Player player;
    Walls walls;
    Score score;
    boolean playing = true;

    @Override
    public void show() {
        init();
    }

    public void init(){
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        viewport = new FitViewport(C.WORLD_WIDTH, C.WORLD_HEIGHT);
        player = new Player(viewport);
        walls = new Walls();
        score = new Score(viewport);
        Gdx.input.setInputProcessor(player);
    }

    @Override
    public void render(float delta) {

        if(collision()){
            player = new Player(viewport);
            walls = new Walls();
            score = new Score(viewport);
            Gdx.input.setInputProcessor(player);
        }

        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);

        player.update(delta);
        walls.update(delta, player);
        score.update(walls.walls.getFirst(),player);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        renderer.rect(0,0,C.WORLD_WIDTH,C.WORLD_HEIGHT);
        walls.render(renderer);
        player.render(renderer);

        renderer.end();
        score.render();
    }

    public boolean collision(){
        return walls.walls.getFirst().collision(player);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
        player.init();
        walls.init();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
