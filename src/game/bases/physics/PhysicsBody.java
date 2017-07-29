package game.bases.physics;

import game.bases.BoxCollider;

/**
 * Created by Admin on 7/25/2017.
 */
public interface PhysicsBody {
    BoxCollider getBoxCollider();
    boolean isActive();
}
