package game.scenes;

import game.Utils;
import game.bases.BoxCollider;
import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.physics.Physics;
import game.bases.physics.PhysicsBody;
import game.bases.renderers.Animation;
import game.bases.renderers.ImageRenderer;
import game.enemies.Enemy;
import game.player.PlayerSpell;

/**
 * Created by Admin on 7/27/2017.
 */
public class Explosion extends GameObject implements PhysicsBody {
    private BoxCollider boxCollider;
    FrameCounter frameCounter;

    public Explosion() {
        super();
        this.renderer = new Animation(
                Utils.loadImage("assets/images/players/explosions/0.png"),
                Utils.loadImage("assets/images/players/explosions/1.png"),
                Utils.loadImage("assets/images/players/explosions/2.png"),
                Utils.loadImage("assets/images/players/explosions/3.png"),
                Utils.loadImage("assets/images/players/explosions/4.png"),
                Utils.loadImage("assets/images/players/explosions/5.png"),
                Utils.loadImage("assets/images/players/explosions/6.png"),
                Utils.loadImage("assets/images/players/explosions/7.png")
        );
        this.frameCounter = new FrameCounter(20);
        this.boxCollider = new BoxCollider(20, 20);
        this.children.add(boxCollider);
    }

    public Vector2D setPosition(PlayerSpell playerSpell) {
        this.position.set(playerSpell.position);
        return this.position;
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        if (frameCounter.run()){
            frameCounter.reset();
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

//    public void setTime() {
//        boolean status = frameCounter.run();
//        if (status){
//            this.isActive = false;
//            frameCounter.reset();
//        }
    }

