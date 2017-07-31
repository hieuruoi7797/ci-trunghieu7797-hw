package game.enemies;

import game.Utils;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.renderers.Animation;

/**
 * Created by Admin on 7/30/2017.
 */
public class EnemyExplosion extends GameObject {
    private Animation animation;

    public EnemyExplosion(){
        animation = new Animation(
                3,
                false,
                Utils.loadImage("assets/images/enemies/explosion/0.png"),
                Utils.loadImage("assets/images/enemies/explosion/2.png"),
                Utils.loadImage("assets/images/enemies/explosion/4.png"),
                Utils.loadImage("assets/images/enemies/explosion/6.png")
        );

        this.renderer = animation;
    }
    @Override
    public void run (Vector2D parentPosition){
        super.run(parentPosition);
        if (this.animation.isFinished()){
            this.isActive = false;
        }
    }
    @Override
    public void refresh(){
        super.refresh();
        animation.reset();
    }

}
