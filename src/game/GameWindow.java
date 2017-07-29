package game;

import game.bases.Contraints;
import game.bases.GameObject;
import game.enemies.Enemy;
import game.enemies.EnemySpawner;
import game.inputs.InputManager;
import game.player.Player;
import game.scenes.BackGround;
import javafx.embed.swing.JFXPanel;
import tklibs.AudioUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by Admin on 7/9/2017.
 */
public class GameWindow extends JFrame {


    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;
    BackGround background;
    InputManager inputManager = new InputManager();
    final JFXPanel fxPanel = new JFXPanel();


    int backgroundY;

//    Player player = new Player();
//    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();


    public GameWindow() {
        setupWindow();
        loadImages();
        addBackGround();
        addPlayer();
        addEnemySpawner();
        backBufferImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics2D = (Graphics2D) backBufferImage.getGraphics();
        this.setVisible(true);
        AudioUtils.playMedia("assets/music/1.mp3");
    }

    private void addBackGround() {
        background = new BackGround();
        background.position.y = this.getHeight();
        GameObject.add(background);
    }

    private void addEnemySpawner() {
        Enemy enemy = new Enemy();
        enemy.position.set(background.getWidth() / 2, 0);
        GameObject.add(enemy);
        GameObject.add(new EnemySpawner());
    }

    private void addPlayer() {
        Player player = new Player();
        player.setInputManager(inputManager);
        player.setContraints(new Contraints(20, this.getHeight(), 0, background.getWidth()));
        player.position.set(background.getWidth() / 2, this.getHeight() - 50);
        GameObject.add(player);

    }


    long lastUpdateTime;

    public void loop() {
        while (true) {

            long currentTime = System.currentTimeMillis();
            if (currentTime - lastUpdateTime > 17) {
                lastUpdateTime = currentTime;
                run();
                render();
            }
        }
    }

    private void run() {
        GameObject.runall();
    }

    private void render() {
        backBufferGraphics2D.setColor(Color.BLACK);
        backBufferGraphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
        GameObject.renderall(backBufferGraphics2D);
        Graphics2D g2d = (Graphics2D) this.getGraphics();
        g2d.drawImage(backBufferImage, 0, 0, null);
    }

    private void loadImages() {
    }

    private void setupWindow() {
        this.setSize(600, 600);
        this.setResizable(false);
        this.setTitle("game do hoi - cover by HieuRuoi");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManager.keyReleased(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; //ep kieu
        g2d.drawImage(backBufferImage, 0, 0, null);
        //cast, convert
    }

}
