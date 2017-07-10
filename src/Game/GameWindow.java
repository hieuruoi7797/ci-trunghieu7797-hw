package Game;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 7/9/2017.
 */
public class GameWindow extends JFrame{
    private BufferedImage background;
    private BufferedImage player;
    private int playerX;
    private int playerY;

    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;



    public GameWindow(){
        setupWindow();
        loadImages();

        playerX = background.getWidth()/2;

        playerY = this.getHeight()-player.getHeight();
        backBufferImage = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics2D = (Graphics2D) backBufferImage.getGraphics();
        setupInputs();

        this.setVisible(true);
            }

    private void setupInputs() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        playerX += 5;
                        break;

                    case KeyEvent.VK_LEFT:
                        playerX -=5;
                        break;

                    case KeyEvent.VK_DOWN:
                        playerY +=5;
                        break;

                    case KeyEvent.VK_UP:
                        playerY -=5;
                        break;


                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

    }

    public void run(){
        int backgroundHeight = background.getHeight();
        int ground = this.getHeight()- backgroundHeight;
        while(true){
            try {
                Thread.sleep(17);

                backBufferGraphics2D.setColor(Color.BLACK);
                backBufferGraphics2D.fillRect(0,0,this.getWidth(),this.getHeight());
                if (ground < 0){
                ground += 5;
               }
                backBufferGraphics2D.drawImage(background,0, ground,null);
                backBufferGraphics2D.drawImage(player,playerX, playerY,null);

                Graphics2D g2d= (Graphics2D)this.getGraphics();
                g2d.drawImage(backBufferImage, 0, 0, null);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
    }

    private void loadImages() {
        try {
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
            background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void setupWindow() {
        this.setSize(600, 600);
        this.setResizable(false);
        this.setTitle("Game do hoi - cover by HieuRuoi");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent   e) {
                System.exit(0);
                super.windowClosing(e);

            }
        });
    }
   @Override
    public void paint(Graphics g) {
        Graphics2D g2d= (Graphics2D)g; //ep kieu

        g2d.drawImage(backBufferImage,0,0,null);

        //cast, convert
    }

}
