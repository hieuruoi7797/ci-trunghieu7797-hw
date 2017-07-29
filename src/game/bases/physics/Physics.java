package game.bases.physics;

import game.bases.BoxCollider;

import java.util.Vector;

/**
 * Created by Admin on 7/25/2017.
 */
public class Physics {
    private static Vector<PhysicsBody> bodies = new Vector<>();

    public static void add(PhysicsBody body){
        bodies.add(body);
    }

    public static <T extends  PhysicsBody> T bodyInRect(BoxCollider boxCollider, Class<T> classz){
        for(PhysicsBody body: bodies){
            if (body.isActive() && body.getBoxCollider().collideWith(boxCollider)){
                if(body.getClass() == classz)
                return (T) body;
            }
        }
        return null;
    }
}
