package game.scenes;

import game.GameWindow;
import game.bases.GameObject;
import game.inputs.InputManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Admin on 7/23/2017.
 */
public class Setting {
    private InputManager inputManager = new InputManager();

    public Setting(){

           }

    public void setupWindow(GameWindow window){


        window.setSize(600, 600);
        window.setResizable(false);
        window.setTitle("game do hoi - cover by HieuRuoi");
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });
        window.addKeyListener(new KeyListener() {
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
    public InputManager getInputManager(){
        return inputManager;
    }
    //gameplayWidth, gameplayHeight
    //windowWidth, windowHeight
    //frameDelay = 17;
}
