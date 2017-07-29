package tklibs;

/**
 * Created by huynq on 5/20/17.
 */
public class Mathx {
    public static double lerp(double a, double b, double f) {
        return a + f * (b - a);
    }

//    /**
//     *
//     * @param origin
//     * @param destination
//     * @param f = currentime / time [0 1]
//     * @return
//     */
//    public static game.bases.Vector2D lerp(game.bases.Vector2D origin, game.bases.Vector2D destination, double f) {
//        return origin.multiply(1  - f).add(destination.multiply(f));
//    }

    public static double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
    public static boolean inRange(float value, float min, float max){
        return value >= min && value <= max;
    }
}
