package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.StartState;

public class TankStars extends ApplicationAdapter {
	public static final int WIDTH=670;
	public static final int HEIGHT=500;
	public static final String TITLE="Tank Stars";

	private GameStateManager gsm;
	private SpriteBatch batch;


	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		gsm=new GameStateManager();
		img = new Texture("badlogic.jpg");
		ScreenUtils.clear(0, 1, 0, 0);
//		gsm.push(new StartState(gsm));
		gsm.push(StartState.getVar_instance(gsm));
	}

	@Override
	public void render () {

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();

	}
}
