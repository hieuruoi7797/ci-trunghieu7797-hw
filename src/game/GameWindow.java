package Game;

import Game.bases.Contraints;
import Game.bases.GameObject;
import Game.enemies.Enemy;
import Game.enemies.EnemySpawner;
import Game.inputs.InputManager;
import Game.player.Player;
import Game.player.PlayerSpell;
import Game.scenes.BackGround;
import Game.scenes.Setting;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

/**
 * Created by Admin on 7/9/2017.
 */
public class GameWindow extends JFrame {


    public BufferedImage backBufferImage;
    public Graphics2D backBufferGraphics2D;
    public BackGround background;
    public InputManager inputManager = new InputManager();
    public Setting setting = new Setting();

    public GameWindow() {
        setting.settingWindow(this);
        addBackGround();
        addPlayer();
        addEnemySpawner();
        backBufferImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics2D = (Graphics2D) backBufferImage.getGraphics();
        this.setVisible(true);
    }
    private void addBackGround() {
        background = new BackGround();
        background.position.y = this.getHeight();
        GameObject.add(background);
    }
    private void addEnemySpawner(){
        Enemy enemy = new Enemy();
        enemy.position.set(background.renderer.getWidth()/2, 0);
        GameObject.add(enemy);
        GameObject.add(new EnemySpawner());
    }
    private void addPlayer() {
        Player player = new Player();
        player.setInputManager(inputManager);
        player.setContraints(new Contraints(20, this.getHeight(), 0, background.renderer.getWidth()));
        player.position.set(background.renderer.getWidth() / 2, this.getHeight() - 50);
        GameObject.add(player);

    }

    public void loop() {
        while (true) {
                setting.settingLoop();
                run();
                render();
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
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backBufferImage, 0, 0, null);

    }

}
