package game.player;

import game.Utils;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.renderers.Animation;

/**
 * Created by Admin on 8/1/2017.
 */
public class PlayerExplosion extends GameObject {
    private Animation animation;

    public PlayerExplosion() {
        animation = new Animation(
                3,
                false,
                Utils.loadImage("assets/images/players/explosions/0.png"),
                Utils.loadImage("assets/images/players/explosions/2.png"),
                Utils.loadImage("assets/images/players/explosions/4.png"),
                Utils.loadImage("assets/images/players/explosions/6.png"),
                Utils.loadImage("assets/images/players/explosions/7.png")
        );
        this.renderer = animation;

    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        if (this.animation.isFinished()) {
            this.isActive = false;
        }
    }

    @Override
    public void refresh() {
        super.refresh();
        animation.reset();
    }

}
