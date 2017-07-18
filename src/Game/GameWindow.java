package Game;

import Game.bases.Contraints;
import Game.enemy.Bullet;
import Game.enemy.Enemy;
import Game.player.Player;
import Game.player.PlayerSpell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    ArrayList<Enemy> listOfEnemies = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();
    Player player = new Player();
    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();
    Enemy enemy = new Enemy();
    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;




    public GameWindow(){
        setupWindow();
        loadImages();

        Contraints contraints = new Contraints(0, this.getHeight(),0, background.getWidth());
        player.setContraints(contraints);
        player.position.set(background.getWidth()/2,this.getHeight() - 50) ;

        backgroundY = this.getHeight()-background.getHeight();

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

    long lastUpdateTime;

    public void loop(){
        while(true){

            long currentTime = System.currentTimeMillis();
            if (currentTime - lastUpdateTime > 17) {
                lastUpdateTime = currentTime;
                run();
                render();

            }


            }}

    private void run(){
        if (backgroundY <=0)
            backgroundY += 5;

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
        if (xPressed){
           player.castSpell(playerSpells);
        }




        player.move(dx, dy);
        player.coolDown();
        for (PlayerSpell playerSpell: playerSpells){
            playerSpell.move();
        }

        enemy.printEnemy(listOfEnemies);
        enemy.coolDownEnemy();
        for (Enemy enemy:listOfEnemies)
              {
                  enemy.move();
                  enemy.shot(bullets);
                  enemy.coolDownBullet();
                  for (Bullet bullet:bullets)
                        {
                      bullet.move();
                  }
        }






    }
    private void render() {
        backBufferGraphics2D.setColor(Color.BLACK);
        backBufferGraphics2D.fillRect(0,0,this.getWidth(),this.getHeight());

        backBufferGraphics2D.drawImage(background,0, backgroundY,null);
        player.render(backBufferGraphics2D);




        for (PlayerSpell playerSpell : playerSpells){
            playerSpell.render(backBufferGraphics2D);
        }

        for (Enemy enemy:listOfEnemies){
            enemy.render(backBufferGraphics2D);
            for (Bullet bullet : bullets){
                bullet.render(backBufferGraphics2D);
            }
        }



        Graphics2D g2d= (Graphics2D)this.getGraphics();
        g2d.drawImage(backBufferImage, 0, 0, null);
    }

    private void loadImages() {

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
