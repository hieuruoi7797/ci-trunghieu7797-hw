package Game.enemies;

import Game.Utils;
import Game.bases.GameObject;
import Game.bases.ImageRenderer;
import Game.bases.Vector2D;

/**
 * Created by Admin on 7/23/2017.
 */
public class EnemyBullet extends GameObject {
    public Vector2D velocity;

    public EnemyBullet() {
        super();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer(Utils.loadAssetImage("enemies/bullets/white.png"));
    }
    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        this.position.addUp(velocity);
    }

}
