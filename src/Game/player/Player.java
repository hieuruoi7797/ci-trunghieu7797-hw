package Game.player;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Admin on 7/11/2017.
 */
public class Player {

    //Properties: thuoc tinh
    public int x;
    public int y;
    public BufferedImage image;

    //Method: phuong thuc
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void render(Graphics2D g2d){
        g2d.drawImage(image, x, y, null);

    }

}
