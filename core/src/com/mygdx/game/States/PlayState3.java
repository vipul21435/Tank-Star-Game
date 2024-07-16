package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Sprites.Tanks;
import com.mygdx.game.TankStars;


public class PlayState3 extends State {
    private Tanks tank2;
    private Tanks tank1;

    private Texture img2;
    private Texture img1;

    private Texture img_bullet;
    private Texture pause;
    private Texture background;
    private Texture hill;

    private SpriteBatch batch;
    public BitmapFont font;
    int a=20;
    int b=20;
    int f1=5;
    int f2=5;


    public PlayState3(GameStateManager gsm) {
        super(gsm);
        batch=new SpriteBatch();
        font=new BitmapFont();

        img2 = new Texture("tank3r.png");
        img_bullet= new Texture("pngegg.png");
        img1=new Texture("tank3.png");

        tank2 = new Tanks(img_bullet, img2,Gdx.graphics.getWidth()+100,140);
        tank1=new Tanks(img_bullet, img1,100,140);
        pause= new Texture("pause.jpg");
        background=new Texture("backg.png");
        hill=new Texture("hill.png");
//        camera.setToOrtho(false, MyGdxGame.width/2,MyGdxGame.height/2);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.getX()<5+pause.getWidth()) {
            if (Gdx.input.justTouched() ) {
                gsm.set(new PauseState(gsm));
                dispose();
            }
        }
        if((tank2.position_bullet.x-tank1.position.x>-50&&tank2.position_bullet.x-tank1.position.x<50&&tank2.position_bullet.y>TankStars.HEIGHT/4&&tank2.position_bullet.y<TankStars.HEIGHT/3)){
            a--;
            tank1.position.x=tank1.position.x-2;
        }

        if(tank1.position_bullet.x-tank2.position.x<50&&tank1.position_bullet.x-tank2.position.x>-50&&tank1.position_bullet.y>TankStars.HEIGHT/4&&tank1.position_bullet.y<TankStars.HEIGHT/3){
            b--;
            tank2.position.x=tank2.position.x+2;
        }






    }

    @Override
    public void update(float dtime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw(background,0,0, TankStars.WIDTH,TankStars.HEIGHT);
        sb.draw(hill,0,0, TankStars.WIDTH,TankStars.HEIGHT/3);
        sb.draw(pause,5,5);
        sb.end();
        batch.begin();



        font.draw(batch,"HEALTH: "+a, 30, 400);
        font.draw(batch,"FUEL: "+tank1.fuel1 , 30, 380);
        font.draw(batch,"HEALTH: "+b , 500, 400);
        font.draw(batch,"FUEL: " +tank2.fuel2, 500, 380);

        if(a<=0){
            font.draw(batch,"TANK 2 WON !!!", 280, 300);
            a=0;

        }
        if(b<=0){
            font.draw(batch,"TANK 1 WON !!!", 280, 300);
            b=0;
        }

        tank1.draw1(batch);
        tank2.draw2(batch);
        batch.end();

    }

    @Override
    public void dispose() {
        pause.dispose();
        background.dispose();
        hill.dispose();
        font.dispose();
    }
}
