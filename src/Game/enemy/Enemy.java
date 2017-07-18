package Game.enemy;

import Game.Utils;
import Game.bases.Contraints;
import Game.bases.FrameCounter;
import Game.bases.ImageRenderer;
import Game.bases.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 7/17/2017.
 */
public class Enemy {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    Random rd = new Random();
    boolean vissible;
    FrameCounter coolDownCounter;

    boolean dontShoot;

    public Enemy() {
        position = new Vector2D(rd.nextInt(500), 0);
        this.imageRenderer = new ImageRenderer(Utils.loadAssetImage("enemies/level0/black/0.png"));
        coolDownCounter = new FrameCounter(17);

    }

    public void move() {
        this.position.addUp(0, 10 );
    }

    public void render(Graphics2D g2d){
        imageRenderer.render(g2d,this.position);
    }

    public void printEnemy(ArrayList<Enemy> enemies ){
        if (vissible) {
            Enemy enemy = new Enemy();
            enemy.position.set(rd.nextInt(400), 0);
            enemies.add(enemy);
            vissible = false;
        }
    }

    public void shot(ArrayList<Bullet> bullets){
        if (!dontShoot){
            Bullet bullet = new Bullet();
            bullet.position.set(this.position.add(0,+20));
            bullets.add(bullet);
            dontShoot = true;
        }
    }
    public void coolDownBullet(){
        if (dontShoot){
            boolean status = coolDownCounter.run();
            if (status){
                dontShoot = false;
                coolDownCounter.reset();
            }
        }
    }

    public void coolDownEnemy(){
        if (!vissible){
             boolean status = coolDownCounter.run();
            if (status){
                vissible = true;
                coolDownCounter.reset();
            }
        }
    }
}
