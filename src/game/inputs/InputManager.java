package Game.inputs;

import java.awt.event.KeyEvent;
import java.security.Key;

/**
 * Created by Admin on 7/18/2017.
 */
public class InputManager {

    public boolean rightPressed;
    public boolean leftPressed;
    public boolean upPressed;
    public boolean downPressed;
    public boolean xPressed;


    public void keyPressed(KeyEvent keyEvent){
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
            case KeyEvent.VK_X:
                xPressed = true;
                break;
            default:
                break;
        }
    }
    public void keyReleased(KeyEvent keyEvent){
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
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
}
