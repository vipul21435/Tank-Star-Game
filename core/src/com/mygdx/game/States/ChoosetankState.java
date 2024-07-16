package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.TankStars;

public class ChoosetankState extends State{
    private Texture Choosetank;
    private Texture tank1c;
    private Texture tank2c;
    private Texture tank3c;
    public ChoosetankState(GameStateManager gsm) {
        super(gsm);
        Choosetank=new Texture("choosetank.png");
        tank1c=new Texture("tank1c.png");
        tank2c=new Texture("tank2c.png");
        tank3c=new Texture("tank3c.png");
    }

    @Override
    protected void handleInput() {

        if(Gdx.input.getX()>100-20&&Gdx.input.getX()<220){
            if(Gdx.input.justTouched()){
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }
        if(Gdx.input.getX()>300-20&&Gdx.input.getX()<420){
            if(Gdx.input.justTouched()){
                gsm.set(new PlayState2(gsm));
                dispose();
            }
        }
        if(Gdx.input.getX()>500-20&&Gdx.input.getX()<620){
            if(Gdx.input.justTouched()){
                gsm.set(new PlayState3(gsm));
                dispose();
            }
        }




    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(Choosetank,0,0, TankStars.WIDTH,TankStars.HEIGHT);
        sb.draw(tank1c,100-20,170);
        sb.draw(tank2c,300-20,170);
        sb.draw(tank3c,500-20,170);

        sb.end();

    }

    @Override
    public void dispose() {

    }
}
