package com.ilyaandtolya.sharagopokalipsis.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.ilyaandtolya.sharagopokalipsis.view.GameScreen;

public class CarController {
    private Polygon carBounds;

    public CarController(Polygon carBounds){
        this.carBounds = carBounds;
    }

    private float carSpeed, speedVelocity = 2f, speedMax = 10f;
    private float rotationSpeed = 30f;
//    static final lamda_dlya_controller = GameScreen.deltaCff;
    public void handle() {
        //все что связано со скоростью
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {//скорость при нажатой стрелочке вверх
            carSpeed += speedVelocity  * GameScreen.deltaCff;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {//скорость при нажатии стрелочки вниз
            carSpeed -= speedVelocity * GameScreen.deltaCff;
        }else {
            downSpeed();//снижение скорости когда клавиша не нажата

        }
        //ограничение скорости
        carSpeed = sliceSpeed();
        //

        //все что связано с поворотом
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){//влево
            carBounds.rotate(rotationSpeed * carSpeed * GameScreen.deltaCff);
        }else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){//вправо
            carBounds.rotate(-rotationSpeed * carSpeed * GameScreen.deltaCff);
        }

        carBounds.setPosition(carBounds.getX() + (MathUtils.sinDeg(carBounds.getRotation() + 90) * carSpeed * GameScreen.deltaCff),
                    carBounds.getY() + (MathUtils.cosDeg(carBounds.getRotation() - 90) * carSpeed * GameScreen.deltaCff));

    }

    private void downSpeed(){ //уменьшение скорости при не нажатых клавишах
        if(carSpeed < speedVelocity * GameScreen.deltaCff){
               carSpeed += speedVelocity;

        }else if (carSpeed > speedVelocity * GameScreen.deltaCff){
            carSpeed -= speedVelocity ;

        }{
            carSpeed = 0;
            System.out.println(carSpeed);
        }

    }

    private float sliceSpeed(){ //ограничение скорости
      if (carSpeed > speedMax){
          return speedMax;
      }else if (carSpeed  < - speedMax ){
          return -speedMax;
      }

      return carSpeed;
    }
}
