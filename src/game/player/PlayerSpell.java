package game.player;

import game.Utils;
import game.bases.BoxCollider;
import game.bases.GameObject;
import game.bases.renderers.ImageRenderer;
import game.bases.Vector2D;
import game.bases.physics.Physics;
import game.bases.physics.PhysicsBody;
import game.enemies.Enemy;
import game.scenes.Explosion;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

/**
 * Created by Admin on 7/11/2017.
 */
public class PlayerSpell extends GameObject implements PhysicsBody {

    private BoxCollider boxCollider;
    private Explosion explosion;
    private Clip sound;

    public PlayerSpell() {
        super();
        explosion = new Explosion();
        renderer = new ImageRenderer(Utils.loadAssetImage("player-spells/a/0.png"));
        boxCollider = new BoxCollider(30, 30);
        children.add(boxCollider);
    }


    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        this.position.addUp(0, -10);
        hitEnemy();
        if (this.position.y < 0) {
            this.isActive = false;
        }
    }

    private void hitEnemy() {
        Enemy hitEnemy = Physics.bodyInRect(this.boxCollider, Enemy.class);
        if (hitEnemy != null) {
            hitEnemy.isActive = false;
            this.isActive = false;
            sound = AudioUtils.loadSound("assets/music/sfx/enemy-explosion-big.wav");
            sound.start();
            explosion.setPosition(this);
            GameObject.add(explosion);
        }
    }



    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
