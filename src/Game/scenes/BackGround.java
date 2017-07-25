package Game.scenes;

import Game.Utils;
import Game.bases.GameObject;
import Game.bases.ImageRenderer;
import Game.bases.Vector2D;
import javafx.scene.layout.Background;

import javax.rmi.CORBA.Util;

/**
 * Created by Admin on 7/23/2017.
 */
public class BackGround extends GameObject {
    public BackGround(){
        super();
        this.renderer = new ImageRenderer(Utils.loadAssetImage("background/0.png"));
        this.renderer.anchor.set(0, 1);
    }
    @Override
    public void run(Vector2D parentPosition){
        if (this.position.y - this.renderer.getHeight()<0)
        this.position.addUp(0, 1);
    }
}
