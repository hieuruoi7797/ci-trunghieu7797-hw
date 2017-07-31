package game.player;

import game.Utils;
import game.bases.*;
import game.bases.physics.PhysicsBody;
import game.bases.renderers.ImageRenderer;
import game.enemies.EnemyExplosion;
import game.inputs.InputManager;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

/**
 * Created by Admin on 7/11/2017.
 */
public class Player extends GameObject implements PhysicsBody {

    Contraints contraints;
    FrameCounter coolDownCounter;
    boolean spellDisabled;
    Vector2D velocity;
    InputManager inputManager;
    private PlayerAnimator animator;
    BoxCollider boxCollider;

    public static Player instance;

    public Player() {
        this.velocity = new Vector2D();
        this.coolDownCounter = new FrameCounter(17);//17 frames = 300 miliseconds to cool down
        this.animator = new PlayerAnimator();
        this.renderer = animator;
        instance = this;
        this.boxCollider = new BoxCollider(20,20);
        this.children.add(boxCollider);
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        animate();
        move();
        castSpell();
        coolDown();
    }

    private void animate() {
        animator.run(this);
    }

    private void move() {
        this.velocity.set(0, 0);
        if (inputManager.leftPressed)
            this.velocity.x -= 10;
        if (inputManager.rightPressed)
            this.velocity.x += 10;
        if (inputManager.upPressed)
            this.velocity.y -= 10;
        if (inputManager.downPressed)
            this.velocity.y += 10;
        this.position.addUp(velocity);
        this.contraints.make(this.position);
    }


    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;

    }

    //Method: phuong thuc
    public void move(int dx, int dy) {
        this.position.addUp(dx, dy);
        contraints.make(this.position);
    }

    //setter
    public void setContraints(Contraints contraints) {
        this.contraints = contraints;
    }

    public void castSpell() {
        //cast spell
        if (inputManager.xPressed && !spellDisabled) {
            PlayerSpell playerSpell = GameObjectPool.recyle(PlayerSpell.class);
            playerSpell.position.set(this.position.add(0, -20));

            spellDisabled = true;
        }
    }

    public void coolDown() {
        if (spellDisabled) {
            //cooldownx
            boolean status = coolDownCounter.run();
            if (status) {
                spellDisabled = false;
                coolDownCounter.reset();
            }
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider ;
    }

    public void getHit(int damage) {
            this.isActive = false;
            PlayerExplosion playerExplosion = GameObjectPool.recyle(PlayerExplosion.class);
            playerExplosion.position.set(this.position);
        }

    }



//    public BufferedImage image;
//    public void render(Graphics2D g2d){
//        g2d.drawImage(image, (int)position.x, (int)position.y, null);
//
//    }


