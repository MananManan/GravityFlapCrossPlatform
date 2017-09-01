package com.demo.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.swing.text.View;

/**
 * Created by Manan on 8/29/2017.
 */

public class Score {
    Viewport viewport;
    BitmapFont font;
    SpriteBatch batch;
    int score;

    public Score(Viewport viewport){
        this.viewport = viewport;
        init();
    }

    public void init(){
        score = 0;
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().scale(0.0001f);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public void update(Wall wall, Player player){
        if(!wall.passed && wall.position.x + C.WALL_WIDTH < player.position.x){
            score +=1;
            wall.passed = true;
        }
    }

    public void render(){
        font.setColor(C.FONT_COLOR);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        font.draw(batch,"Score : " + score, C.SCORE_X,C.SCORE_Y);
        batch.end();

    }
}
