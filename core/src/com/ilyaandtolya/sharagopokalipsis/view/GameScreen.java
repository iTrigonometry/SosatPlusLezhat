package com.ilyaandtolya.sharagopokalipsis.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ilyaandtolya.sharagopokalipsis.model.Car;

public class GameScreen implements Screen {

    private Texture carTexture;
    private SpriteBatch batch;
    private Car car;

    @Override
    public void show() {
       batch = new SpriteBatch();
       carTexture = new Texture(Gdx.files.internal("download.png"));
       car = new Car(carTexture,0,0,318, 159);
    }


    @Override
    public void render(float delta) {
      Gdx.gl.glClearColor(0,0,0,1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


      batch.begin();
      car.draw(batch);
      batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        carTexture.dispose();
        batch.dispose();
    }
}
