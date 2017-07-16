package Game;

import Game.enemy.Enemy;
import Game.player.Player;
import Game.player.PlayerSpell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 7/9/2017.
 */
public class GameWindow extends JFrame{
    private BufferedImage background;

    boolean rightPressed;
    boolean leftPressed;
    boolean upPressed;
    boolean downPressed;
    boolean xPressed;
    int backgroundY;



    Player player = new Player();
    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();
    ArrayList<Enemy> listOfEnemy = new ArrayList<>();
    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;
    private int i;
    private int numberOfEnemy = 3;


    public GameWindow(){
        setupWindow();
        loadImages();


        player.x = background.getWidth()/2;
        backgroundY = this.getHeight()-background.getHeight();
        player.y = this.getHeight()-player.image.getHeight();
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
                        rightPressed = true;
                        break;

                    case KeyEvent.VK_LEFT:
                        leftPressed = true;

                        break;

                    case KeyEvent.VK_DOWN:
                        downPressed = true;
                        break;

                    case KeyEvent.VK_UP:
                        upPressed = true;
                        break;

                    case KeyEvent.VK_X:
                        xPressed = true;
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        rightPressed = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        leftPressed = false;
                        break;
                    case KeyEvent.VK_UP:
                        upPressed = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        downPressed = false;
                        break;
                    case KeyEvent.VK_X:
                        xPressed = false;
                        break;



                    default:
                        break;


                }
            }
        });

    }

    public void loop(){
        while(true){
            try {

                Thread.sleep(17);


                run();

                render();






            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void run(){

        if (backgroundY <=0) {
            backgroundY++;}

            for (int i = 0; i < 3; i++) {
                Enemy enemy = new Enemy();

                enemy.image = Utils.loadImage("assets/images/enemies/level0/pink/0.png");

                listOfEnemy.add(enemy);
            }


        int dx = 0;
        int dy = 0;


        if (rightPressed){
            dx += 3;
        }
        if (leftPressed){
            dx -= 3;
        }
        if (upPressed){
            dy -= 3;
        }
        if (downPressed){
            dy +=3;
        }
        if (xPressed) {

            // Create New
            PlayerSpell playerSpell = new PlayerSpell();

            //Config
            playerSpell.x = player.x;
            playerSpell.y = player.y;
            playerSpell.image = Utils.loadImage("assets/images/player-spells/a/1.png");
            //Add to ArrayList

            playerSpells.add(playerSpell);

        }



        player.move(dx, dy);
        for (PlayerSpell playerSpell: playerSpells){

            playerSpell.move();
        }
        for (Enemy enemy:listOfEnemy) {
            enemy.move();

        }

    }

    private void render() throws IOException {
        backBufferGraphics2D.setColor(Color.BLACK);
        backBufferGraphics2D.fillRect(0,0,this.getWidth(),this.getHeight());

        backBufferGraphics2D.drawImage(background,0, backgroundY,null);
        player.render(backBufferGraphics2D);

        for (int i = 0; i < numberOfEnemy ; i++) {

        
            Enemy enemy= new Enemy();
            enemy = listOfEnemy.get(i);
            enemy.render(backBufferGraphics2D);

            }



        for (PlayerSpell playerSpell : playerSpells){

            playerSpell.render(backBufferGraphics2D);

        }

        Graphics2D g2d= (Graphics2D)this.getGraphics();
        g2d.drawImage(backBufferImage, 0, 0, null);
    }

    private void loadImages() {
        player.image = Utils.loadImage("assets/images/players/straight/0.png");
        background = Utils.loadImage("assets/images/background/0.png");

    }


    private void setupWindow() {
        this.setSize(600, 600);
        this.setResizable(false);
        this.setTitle("Game do hoi - cover by HieuRuoi");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
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
