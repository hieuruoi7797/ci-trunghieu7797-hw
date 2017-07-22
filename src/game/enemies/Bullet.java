package game.enemies;

import game.Utils;
import game.bases.GameObject;
import game.bases.ImageRenderer;
import game.bases.Vector2D;
import game.player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Admin on 7/22/2017.
 */
public class Bullet extends GameObject{
    Random rd = new Random();
    public Bullet(){
        position = new Vector2D();
        this.renderer = new ImageRenderer(Utils.loadImage("assets/images/enemies/bullets/blue.png"));

    }
@Override
    public void run(){
        this.position.addUp(rd.nextInt(10), rd.nextInt(20));

    }




}
