package Game.enemy;

import Game.Utils;
import Game.bases.ImageRenderer;
import Game.bases.Vector2D;
import Game.player.PlayerSpell;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Admin on 7/18/2017.
 */
public class Bullet  {
    public Vector2D position;
    public ImageRenderer imageRenderer;


    public Bullet(){
        position = new Vector2D();
        this.imageRenderer = new ImageRenderer(Utils.loadAssetImage("enemies/bullets/blue.png"));
    }

    public void move(){
        this.position.addUp(0, 5);
    }
    public void render(Graphics2D g2d){
        imageRenderer.render(g2d, this.position);

    }


}