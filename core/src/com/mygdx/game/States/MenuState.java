package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.TankStars;

public class MenuState extends State{
    private Texture background;
    private Texture start;
    private Texture quit;
    private Texture resume;



    public MenuState(GameStateManager gsm) {
        super(gsm);
        background=new Texture("backg.png");
        start=new Texture("start.png");
        resume=new Texture("resume.png");
        quit=new Texture("quit.png");

    }

    @Override
    public void handleInput() {

        if(Gdx.input.getY()<TankStars.HEIGHT/2-65&&Gdx.input.getY()>TankStars.HEIGHT/2-65-start.getHeight()&&Gdx.input.getX()<start.getWidth()+(TankStars.WIDTH)/2-(start.getWidth())/2&&Gdx.input.getX()>(TankStars.WIDTH)/2-(start.getWidth())/2){
            if(Gdx.input.justTouched()){
                gsm.set(new ChoosetankState(gsm));
                dispose();
            }
        }

        if(Gdx.input.getX()>(TankStars.WIDTH)/2-(start.getWidth())/2 && Gdx.input.getX()<(TankStars.WIDTH)/2+(start.getWidth())/2 && Gdx.input.getY()<TankStars.HEIGHT/2+200 && Gdx.input.getY()>TankStars.HEIGHT/2+400-quit.getWidth()){
            if(Gdx.input.justTouched()){
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
        sb.draw(background,0,0,TankStars.WIDTH,TankStars.HEIGHT);
        sb.draw(start,(TankStars.WIDTH)/2-(start.getWidth())/2,TankStars.HEIGHT/2+65);
        sb.draw(resume,(TankStars.WIDTH)/2-(start.getWidth())/2,TankStars.HEIGHT/2-50);
        sb.draw(quit,(TankStars.WIDTH)/2-(start.getWidth())/2,TankStars.HEIGHT/2-200);
        sb.end();

    }
    @Override
    public void dispose(){
        background.dispose();
        start.dispose();
        resume.dispose();
        quit.dispose();
    }




}
