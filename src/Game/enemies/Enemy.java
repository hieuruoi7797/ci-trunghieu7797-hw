package Game.enemies;

import Game.Utils;
import Game.bases.*;
import Game.player.Player;

/**
 * Created by Admin on 7/23/2017.
 */
public class Enemy extends GameObject {
    public Vector2D velocity;
    FrameCounter shootCounter;
    BoxCollider boxCollider;

    public static Enemy instance;

    public Enemy(){
        super();
        this.renderer = new ImageRenderer(Utils.loadAssetImage("enemies/level0/blue/0.png"));
        velocity = new Vector2D();
        this.shootCounter = new FrameCounter(5);
        this.boxCollider = new BoxCollider(20,20);
        instance = this;
    }
    @Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        velocity.y = 2;
        this.position.addUp(this.velocity);
        if (shootCounter.run()){
            this.shootCounter.reset();
            shoot();
        }
    }

    private void shoot() {
        Vector2D target = Player.instance.position;
        Vector2D bulletVeclocity = target.subtract(position)
                .normalize()
                .multiply(4);
        EnemyBullet enemyBullet = new EnemyBullet();
        enemyBullet.velocity.set(bulletVeclocity);
        enemyBullet.position.set(this.position);
        GameObject.add(enemyBullet);
    }


}


