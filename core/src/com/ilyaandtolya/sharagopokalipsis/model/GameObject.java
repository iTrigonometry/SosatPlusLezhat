package com.ilyaandtolya.sharagopokalipsis.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;


abstract class GameObject {

    Polygon bounds;
    Sprite object;
    GameObject(Texture texture, float x, float y, float width, float heith){
        object = new Sprite(texture);
        object.setSize(width,heith);
        object.setOrigin(width/2f, heith/2f);
        object.setPosition(x,y);

        bounds = new Polygon(new float[]{0f,0f, width,0f,width, heith, 0f, heith});
        bounds.setPosition(x,y);
        bounds.setOrigin(width/2f,heith/2f);
    }
    public void draw(SpriteBatch batch){
        object.setPosition(bounds.getX(), bounds.getY());
        object.setRotation(bounds.getRotation());
        object.draw(batch);
    }

    public Polygon getBounds(){
        return bounds;
    }
}
