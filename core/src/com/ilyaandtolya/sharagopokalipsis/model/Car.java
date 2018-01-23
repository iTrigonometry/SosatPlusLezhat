package com.ilyaandtolya.sharagopokalipsis.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ilyaandtolya.sharagopokalipsis.control.CarController;

public class Car extends GameObject {
    private CarController carController;
    public Car(Texture texture, float x, float y, float width, float heith) {
        super(texture, x, y, width, heith);
        carController = new CarController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        carController.handle();
    }
}
