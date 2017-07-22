package game.enemies;

import game.Utils;
import game.bases.GameObject;
import game.bases.ImageRenderer;
import game.player.Player;

import java.util.Random;

/**
 * Created by Admin on 7/18/2017.
 */
public class EnemySpawner extends GameObject {
    Random rd = new Random();
    public EnemySpawner(){

        this.position.x = rd.nextInt(390*2);
        this.position.y = 0;
        this.renderer = new ImageRenderer(Utils.loadImage("assets/images/enemies/level0/black/0.png"));

    }
    @Override
    public void run(){
        shot();
        if (this.position.y < 600){


            this.position.y +=5;

        }
        else {
            this.position.y =0;
            this.position.x =rd.nextInt(390);
        }


            }

    public void shot() {
        Bullet bullet = new Bullet();
        bullet.position.x = this.position.x;
        bullet.position.y = this.position.y;
        GameObject.add(bullet);

    }
}
