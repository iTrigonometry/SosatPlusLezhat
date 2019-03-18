package com.ilyaandtolya.sharagopokalipsis;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.ilyaandtolya.sharagopokalipsis.utils.Assets;
import com.ilyaandtolya.sharagopokalipsis.view.GameScreen;


public class Main extends Game {
	private Screen gameScreen;
	private Assets assets;

	@Override
	public void create() {
		assets = new Assets();
		gameScreen = new GameScreen();
		((GameScreen)gameScreen).setTextureAtlas(assets.getManager().get("core/assets/atlas1.atlas", TextureAtlas.class));
		setScreen(gameScreen);
	}
}
