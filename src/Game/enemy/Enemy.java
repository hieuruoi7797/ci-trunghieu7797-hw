package Game.enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Admin on 7/14/2017.
 */
public class Enemy {
    public int x;
    public int y;

    public BufferedImage image;


    Random rd = new Random();
    private int i = 0;

    public Enemy(){
        this.x = rd.nextInt(300);
        this.y = 50;
    }

    public void move(){
        this.y += 3;
    };

    public void render(Graphics2D g2d){

            g2d.drawImage(image, x, y, null);

        }


        }






