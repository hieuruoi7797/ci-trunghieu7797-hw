package Game.player;

import Game.Utils;
import Game.bases.*;
import Game.dragonball.DragonBall;
import Game.inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Admin on 7/11/2017.
 */
public class Player extends GameObject {

    Contraints contraints;
    FrameCounter coolDownCounter;
    boolean spellDisabled;
    Vector2D velocity;
    InputManager inputManager;
    boolean ballDisabled = false ;
    DragonBall dragonBall1 ;
    DragonBall dragonBall2 ;
    public static Player instance;

    public Player() {
        if (ballDisabled==false){
            dragonBall1 = new DragonBall();
            dragonBall2 = new DragonBall();
            GameObject.add(dragonBall1);
            GameObject.add(dragonBall2);
        }
        this.velocity = new Vector2D();
        this.coolDownCounter = new FrameCounter(17);//17 frames = 300 miliseconds to cool down
        this.renderer = new ImageRenderer(Utils.loadAssetImage("players/straight/0.png"));
        instance = this;
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        dragonBall1.setPosition(1);
        dragonBall2.setPosition(2);
        move();
        castSpell();
        coolDown();
    }

    public void move() {
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
        if (inputManager.xPressed) {
            PlayerSpell playerSpell = new PlayerSpell();
            playerSpell.position.set(this.position.add(0, -20));
            GameObject.add(playerSpell);
        }
    }

    public void coolDown() {
        if (spellDisabled) {
            //cooldown
            boolean status = coolDownCounter.run();
            if (status) { PlayerSpell playerSpell = new PlayerSpell();
                playerSpell.position.set(this.position.add(0, -20));
                GameObject.add(playerSpell);
                spellDisabled = false;
                coolDownCounter.reset();
            }
        }

    }
}


//    public BufferedImage image;
//    public void render(Graphics2D g2d){
//        g2d.drawImage(image, (int)position.x, (int)position.y, null);
//
//    }


