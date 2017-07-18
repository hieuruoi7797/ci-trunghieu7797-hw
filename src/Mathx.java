/**
 * Created by Admin on 7/16/2017.
 */
public class Mathx {


    public float clamp (float x, float min, float max) {
        if (x < min) {
            return min;
        } else if (x > max) {
            return max;
        }
        return x;
    }

}
