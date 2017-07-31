package game.enemies;

import game.GameWindow;
import game.Utils;
import game.bases.BoxCollider;
import game.bases.Contraints;
import game.bases.GameObject;
import game.bases.physics.Physics;
import game.bases.physics.PhysicsBody;
import game.bases.renderers.ImageRenderer;
import game.bases.Vector2D;
import game.player.Player;
import game.scenes.BackGround;

/**
 * Created by Admin on 7/23/2017.
 */
public class EnemyBullet extends GameObject implements PhysicsBody {
    public Vector2D velocity;
    private Contraints contraints;
    private BoxCollider boxCollider;


    public EnemyBullet() {
        super();
        boxCollider = new BoxCollider(30,30);
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer(Utils.loadAssetImage("enemies/bullets/white.png"));
        children.add(boxCollider);
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        this.position.addUp(velocity);
        this.hitPlayer();
        if ((this.position.y > BackGround.getHeight())||(this.position.x > BackGround.getWidth())) {
            this.isActive = false;
        }
    }
    public void setContraints(Contraints contraints) {
        this.contraints = contraints;
    }
//    public void setContraints(Contraints contraints) {
//        this.contraints = contraints;
//    }
    private void hitPlayer(){
        Player hitPlayer = Physics.bodyInRect(this.boxCollider, Player.class );
        if (hitPlayer != null) {
            hitPlayer.getHit(1);
            hitPlayer.isActive = false;
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
