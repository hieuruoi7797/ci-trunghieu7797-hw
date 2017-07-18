package Game.player;

import Game.Utils;
import Game.bases.Contraints;
import Game.bases.FrameCounter;
import Game.bases.ImageRenderer;
import Game.bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Admin on 7/11/2017.
 */
public class Player {

    public Vector2D position;
    public ImageRenderer imageRenderer;
    Contraints contraints;
    FrameCounter coolDownCounter;
    boolean spellDisabled;

    public Player(){
        this.position = new Vector2D();
        this.coolDownCounter = new FrameCounter(17);//17 frames = 300 miliseconds to cool down
        this.imageRenderer = new ImageRenderer(Utils.loadAssetImage("players/straight/0.png"));

    }

    //Method: phuong thuc
    public void move(int dx, int dy) {
       this.position.addUp(dx, dy);
       contraints.make(this.position);
    }

    public void render(Graphics2D g2d){
        imageRenderer.render(g2d, this.position);
    }
    //setter
    public void setContraints(Contraints contraints){
        this.contraints = contraints;
    }

    public void castSpell(ArrayList<PlayerSpell> playerSpells) {
        //cast spell
        if (!spellDisabled) {
            PlayerSpell playerSpell = new PlayerSpell();
            playerSpell.position.set(this.position.add(0, -20));
            playerSpells.add(playerSpell);
            spellDisabled = true;

        }
    }

    public void coolDown(){
        if (spellDisabled) {
            //cooldown
            boolean status = coolDownCounter.run();
            if (status) {
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


