package Game.scenes;

import Game.GameWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Admin on 7/23/2017.
 */
public class Setting  {

    long lastUpdateTime;

    public Setting(){

    }

    public void settingWindow(GameWindow gameWindow){
        gameWindow.setSize(600,600);
        gameWindow.setSize(600, 600);
        gameWindow.setResizable(false);
        gameWindow.setTitle("Game do hoi - cover by HieuRuoi");
        gameWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });
        gameWindow.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                gameWindow.inputManager.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                gameWindow.inputManager.keyReleased(e);
            }
        });
    }
    public void settingLoop(){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastUpdateTime > 17) {
                lastUpdateTime = currentTime;
            }
    }
    //gameplayWidth, gameplayHeight

    //windowWidth, windowHeight

    //frameDelay = 17;
}
