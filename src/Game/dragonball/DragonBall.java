package Game.dragonball;

import Game.GameWindow;
import Game.Utils;
import Game.bases.*;
import Game.enemies.Enemy;
import Game.enemies.EnemyBullet;
import Game.player.Player;
import Game.player.PlayerSpell;

import java.util.Vector;

/**
 * Created by Admin on 7/25/2017.
 */
public class DragonBall extends GameObject {
    int number;
    public static DragonBall fakeBall1 ;
    public static DragonBall fakeBall2 ;
    public Vector<BallSpell> ballSpells;
    FrameCounter shootCounter;

    BoxCollider boxCollider;


    public DragonBall() {
        super();
        this.renderer = new ImageRenderer(Utils.loadImage("assets/images/sphere/0.png"));
        this.shootCounter = new FrameCounter(5);
        fakeBall1 = this;
        fakeBall2 = this;

    }
    public void setPosition(int number){
        if (number == 1) {
            this.position.y = Player.instance.position.y;
            this.position.x = Player.instance.position.x - 20;
            fakeBall1.position.set(this.position);
        }
        if (number == 2) {
            this.position.y = Player.instance.position.y;
            this.position.x = Player.instance.position.x + 20;
            fakeBall2.position.set(this.position);
        }
    }

    @Override
    public void run (Vector2D parentPosition) {
        super.run(parentPosition);
        if (shootCounter.run()){
            this.shootCounter.reset();
            shoot(fakeBall1);
            shoot(fakeBall2);
                }}

    public void shoot(DragonBall fakeBall){
            Vector2D target = Enemy.instance.position;
            Vector2D spellVeclocity = target.subtract(fakeBall.position)
                    .normalize()
                    .multiply(6);
            BallSpell ballSpell = new BallSpell();
            ballSpell.velocity.set(spellVeclocity);
            ballSpell.position.set(fakeBall.position);
            GameObject.add(ballSpell);
        }
    }


