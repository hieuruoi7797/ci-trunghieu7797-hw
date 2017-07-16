package Game.player;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Admin on 7/11/2017.
 */
public class PlayerSpell {
    public int x;
    public int y;
    public BufferedImage image;
    int count = 0;
    int coolDownTime = 3;
    public void move(){

        y -=10;
    }
    public void render(Graphics2D g2d){
        if (count < coolDownTime){
            count ++;
        }
        else {
        g2d.drawImage(image, x +4  , y - 15, null);
        count =0 ;}
    }


}

