package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.TankStars;

public class StartState extends State{

    private Texture startbackground;
    private StartState(GameStateManager gsm) {
        super(gsm);
        startbackground=new Texture("startbackground.png");
    }
    private static StartState var_instance;
    public static StartState getVar_instance(GameStateManager gsm){
        if (var_instance==null){
            var_instance=new StartState(gsm);
        }
        return var_instance;

    }


    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new MenuState(gsm));
            dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(startbackground,0,0, TankStars.WIDTH-30, TankStars.HEIGHT);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
