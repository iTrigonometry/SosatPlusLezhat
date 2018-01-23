package com.ilyaandtolya.sharagopokalipsis.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ilyaandtolya.sharagopokalipsis.model.Car;

public class GameScreen implements Screen {

    private Texture carTexture;
    private SpriteBatch batch;
    private Car car;
    private OrthographicCamera camera;

    public static float deltaCff;

    @Override
    public void show() {
       batch = new SpriteBatch();
       carTexture = new Texture(Gdx.files.internal("download.png"));
       carTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
       car = new Car(carTexture,0,0,0.7f * 2, 0.7f);
    }


    @Override
    public void render(float delta) {
      Gdx.gl.glClearColor(0,0,0,1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      deltaCff = delta;

      batch.setProjectionMatrix(camera.combined);
      batch.begin();
      car.draw(batch);
      batch.end();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width;
        camera = new OrthographicCamera(20f, 20f * aspectRatio);
        camera.zoom = 0.6f;
        camera.update();

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
