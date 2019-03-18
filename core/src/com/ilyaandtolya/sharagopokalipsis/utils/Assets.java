package com.ilyaandtolya.sharagopokalipsis.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {

    private AssetManager manager;

    public Assets(){
        manager = new AssetManager();
        manager.load("core/assets/atlas1.atlas", TextureAtlas.class);
        manager.finishLoading();
    }
    public void dispose(){
        manager.dispose();
    }

    public AssetManager getManager() {
        return manager;
    }
}
