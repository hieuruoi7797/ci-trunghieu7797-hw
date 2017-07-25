package Game.player;

import Game.Utils;
import Game.bases.GameObject;
import Game.bases.ImageRenderer;
import Game.bases.Vector2D;
import Game.inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Admin on 7/11/2017.
 */
public class PlayerSpell extends GameObject {

    public PlayerSpell() {
        position = new Vector2D();
        renderer = new ImageRenderer(Utils.loadAssetImage("player-spells/a/0.png"));
    }


@Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        this.position.addUp(0, -20);
    }



}
