package Game.dragonball;
import Game.Utils;
import Game.bases.GameObject;
import Game.bases.ImageRenderer;
import Game.bases.Vector2D;
import Game.player.PlayerSpell;
import java.util.Vector;
/**
 * Created by Admin on 7/25/2017.
 */
public class BallSpell extends GameObject {
    Vector2D velocity ;
    public BallSpell() {
        velocity = new Vector2D();
        renderer = new ImageRenderer(Utils.loadImage("assets/images/sphere-bullets/0.png"));
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        this.position.addUp(velocity);
    }
}
