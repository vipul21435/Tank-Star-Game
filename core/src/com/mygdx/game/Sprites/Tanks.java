package com.mygdx.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.TankStars;

public class Tanks {
    public Vector2 position;
    public Sprite sprite;

    public Sprite sprite_bullet;

    public Vector2 position_bullet;

    public float speed=100;

    public float speed_bullet=700;

    public float angle_bullet1=135;
    public float angle_bullet2=45;

    public float time=0;
    public int fuel1=500;
    public int fuel2=500;

    public Tanks(Texture img_bullet,Texture img, float x, float y){
        sprite_bullet=new Sprite(img_bullet);
        sprite = new Sprite(img);
        position = new Vector2(x, y);
        position_bullet = new Vector2(100000000,1000000000);
//        sprite.scale(1);
        sprite.setSize(70,100);
    }

    public void Update1(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.Q) && (position_bullet.x<=0 || position_bullet.x>Gdx.graphics.getWidth() ||
                position_bullet.y>=Gdx.graphics.getHeight() || position_bullet.y<=0)){
            position_bullet.x=position.x;
            time=0;
            position_bullet.y=TankStars.HEIGHT/3+5;


        }

        if(Gdx.input.isKeyPressed(Input.Keys.PAGE_DOWN)){
            speed_bullet-=50;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.PAGE_UP)){
            speed_bullet+=50;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)){
            position.x-=dt*speed;
            fuel1--;


        }
        if(fuel1<=0){
            fuel1=0;
        }





        if(Gdx.input.isKeyPressed(Input.Keys.T)){
            if(angle_bullet1>=90) {
                angle_bullet1 -= 2;
            }
        }        if(Gdx.input.isKeyPressed(Input.Keys.G)){
            if(angle_bullet1<=180) {
                angle_bullet1 += 2;
            }
        }


        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)){
            position.x+=dt*speed;
            fuel1--;

        }
        if(position.x-(sprite.getWidth()*sprite.getScaleX()/2)<=-100){
            position.x = sprite.getWidth()*sprite.getScaleX()/2-100;
        }
        if(position.x+(sprite.getWidth()*sprite.getScaleX()/2)>=Gdx.graphics.getWidth()-100){
            position.x = Gdx.graphics.getWidth()-(sprite.getWidth()*sprite.getScaleX()/2)-100;
        }

        position_bullet.x-=dt*speed_bullet*Math.cos(Math.toRadians(angle_bullet1));
        position_bullet.y+= dt*speed_bullet*Math.sin(Math.toRadians(angle_bullet1))
                -30*time*time;
        time+=dt;
    }

    public void Update2(float dt){
        if(Gdx.input.isKeyJustPressed(Input.Keys.W) && (position_bullet.x<=0 || position_bullet.x>Gdx.graphics.getWidth() ||
                position_bullet.y>=Gdx.graphics.getHeight() || position_bullet.y<=0)){
            position_bullet.x=position.x;
            position_bullet.y= TankStars.HEIGHT/3+5;
            time=0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)){
            if(angle_bullet2>=5) {
                angle_bullet2 -= 2;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)){
            if(angle_bullet2<=90) {
                angle_bullet2 += 2;

            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            position.x-=dt*speed;
            fuel2--;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            position.x+=dt*speed;
            fuel2--;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.PAGE_DOWN)){
            speed_bullet-=50;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.PAGE_UP)){
            speed_bullet+=50;
        }

        if(fuel2<=0){
            fuel2=0;
        }
        if(position.x-(sprite.getWidth()*sprite.getScaleX()/2)<=-100){
            position.x = sprite.getWidth()*sprite.getScaleX()/2-100;
        }
        if(position.x+(sprite.getWidth()*sprite.getScaleX()/2)>=Gdx.graphics.getWidth()-100){
            position.x = Gdx.graphics.getWidth()-(sprite.getWidth()*sprite.getScaleX()/2)-100;
        }

        position_bullet.x-=dt*speed_bullet*Math.cos(Math.toRadians(angle_bullet2));
        position_bullet.y+= dt*speed_bullet*Math.sin(Math.toRadians(angle_bullet2))
                -30*time*time;
        time+=dt;
    }
    public void draw2(SpriteBatch batch){
        Update2(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x,position.y);
        sprite.draw(batch);


        sprite_bullet.setPosition(position_bullet.x,position_bullet.y);
        sprite_bullet.draw(batch);
    }
    public void draw1(SpriteBatch batch){
        Update1(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x,position.y);
        sprite.draw(batch);
        sprite_bullet.setPosition(position_bullet.x,position_bullet.y);
        sprite_bullet.draw(batch);
    }
}
