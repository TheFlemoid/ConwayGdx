package com.tdberg.apps.conway;

import com.tdberg.apps.conway.views.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ConwayGdx extends Game {
	private static ConwayGdx INSTANCE;
	private OrthographicCamera camera;
	private GameScreen gameScreen;
	private int screenWidth;
	private int screenHeight;

	private static final int GAMESCREEN = 0;

	public ConwayGdx() {
		INSTANCE = this;
	}

	public static ConwayGdx getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ConwayGdx();
		}
		return INSTANCE;
	}

	@Override
	public void create() {
		Gdx.graphics.setTitle("Conway's Game of Life");

		this.screenWidth = Gdx.graphics.getWidth();
		this.screenHeight = Gdx.graphics.getHeight();
		this.camera = new OrthographicCamera();

		gameScreen = new GameScreen(camera);
		changeScreen(GAMESCREEN);
	}

	public void changeScreen(int newScreen) {
		switch(newScreen) {
			case GAMESCREEN:
				if(gameScreen == null) {
					gameScreen = new GameScreen(camera);
				}
				Gdx.input.setInputProcessor(gameScreen.getStage());
				setScreen(gameScreen);
				break;
			default:
				break;
		}
	}

	@Override
	public void dispose () {
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}
}
