package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.TankStars;

public class PauseState extends State{
    private Texture background;
    private Texture resume1;
    private Texture savenexit;
    private Texture exit;

    public PauseState(GameStateManager gsm) {
        super(gsm);
        background=new Texture("backg.png");
        resume1=new Texture("resume1.png");
        savenexit=new Texture("save&exit.png");
        exit=new Texture("exit.png");


    }

    @Override
    protected void handleInput() {
        if(Gdx.input.getX()>(TankStars.WIDTH)/2-(exit.getWidth())/2 && Gdx.input.getX()<(TankStars.WIDTH)/2+(exit.getWidth())/2 && Gdx.input.getY()<TankStars.HEIGHT/2+150 && Gdx.input.getY()>TankStars.HEIGHT/2+150-exit.getHeight()){
            if (Gdx.input.justTouched()) {
                Gdx.app.exit();
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
        sb.draw(background,0,0, TankStars.WIDTH,TankStars.HEIGHT);
        sb.draw(resume1,(TankStars.WIDTH)/2-(resume1.getWidth())/2,TankStars.HEIGHT/2+65);
        sb.draw(savenexit,(TankStars.WIDTH)/2-(savenexit.getWidth())/2,TankStars.HEIGHT/2-50);
        sb.draw(exit,(TankStars.WIDTH)/2-(exit.getWidth())/2,TankStars.HEIGHT/2-150);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
