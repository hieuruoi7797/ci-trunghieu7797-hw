package game.bases;

import java.util.Vector;

/**
 * Created by Admin on 7/25/2017.
 */
public class GameObjectPool {
    private static Vector<GameObject> pool = new Vector<>();

    public static <T extends GameObject> T recyle(Class<T> classz) {
        for (GameObject gameObject : pool) {
            if (!gameObject.isActive() && gameObject.getClass() == classz) {
                gameObject.setActive(true);
                return (T) gameObject;
            }
        }
        try {
            T newGameObject = classz.newInstance();
            pool.add(newGameObject);
            GameObject.add(newGameObject);
            return newGameObject;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
