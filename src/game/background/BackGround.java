package game.background;

import game.GameWindow;
import game.Utils;
import game.bases.GameObject;
import game.bases.ImageRenderer;
import game.bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

/**
 * Created by Admin on 7/19/2017.
 */
public class BackGround extends GameObject {

    private float backgroundY;
    public BackGround(){

        this.renderer = new ImageRenderer(Utils.loadImage("assets/images/background/0.png"));
        this.position.x = 0;
        this.position.y = 0;
        GameObject.add(this);
        backgroundY = 600 - this.renderer.image.getHeight();
        this.position.x += this.renderer.image.getWidth()/2;
    }
     @Override
     public void run(){
        if (backgroundY<0){
            backgroundY++;
            this.position.y = backgroundY + this.renderer.image.getHeight()/2;
        }
     }




//        this.position.x += this.renderer.image.getWidth()/2;
//        this.position.y += this.renderer.image.getHeight()/2;
    }
























