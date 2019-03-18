package com.ilyaandtolya.sharagopokalipsis.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.ilyaandtolya.sharagopokalipsis.view.GameScreen;

public class CarController {
    private float carSpeed, speedVelocity = 1f, speedMax = 25f;
    private float rotationSpeed = 30f;

    private Polygon carBounds;
    public CarController(Polygon carBounds) {
        this.carBounds = carBounds;
    }


    public void handle(){
        //всё, что связано со скоростью
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            carSpeed += speedVelocity * GameScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            carSpeed -= speedVelocity * GameScreen.deltaCff;
        else
            downSpeed();
        carSpeed = sliceSpeed();
        //

        //всё, что связано с поворотом
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            carBounds.rotate(rotationSpeed * carSpeed * GameScreen.deltaCff);
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            carBounds.rotate(-rotationSpeed * carSpeed * GameScreen.deltaCff);
        ///


        carBounds.setPosition(carBounds.getX() + MathUtils.sinDeg(carBounds.getRotation() + 90) * carSpeed * GameScreen.deltaCff,
                carBounds.getY() + MathUtils.cosDeg(carBounds.getRotation() - 90) * carSpeed * GameScreen.deltaCff);

    }
    //СНИЖЕНИЕ СКОРОСТИ ЕСЛИ КОАВИША НЕ НАЖАТА
    private void downSpeed(){
        if (carSpeed > speedVelocity * GameScreen.deltaCff)
            carSpeed -= speedVelocity * GameScreen.deltaCff;
        else if (carSpeed < -speedVelocity * GameScreen.deltaCff)
            carSpeed += speedVelocity * GameScreen.deltaCff;
        else
            carSpeed = 0f;
    }
    //ОГРАНИЧЕНИЕ СКОРОСТИ
    private float sliceSpeed(){
        if (carSpeed > speedMax)
            return speedMax;
        if (carSpeed < -speedMax)
            return -speedMax;
        return carSpeed;
    }



}