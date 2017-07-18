package Game.bases;

import java.util.Vector;

/**
 * Created by Admin on 7/16/2017.
 */
public class Vector2D {

    public float x;
    public float y;

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public Vector2D(){
        this(0,0);
    }
    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void addUp( float x, float y){
        this.x += x;
        this.y += y;
    }
    public void addUp(Vector2D other) {
        addUp(other.x,other.y);

    }
    public Vector2D add(float x, float y){
        return new Vector2D( this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D other) {
        return add(other.x, other.y);
    }

    public Vector2D multiply(int x) {
        Vector2D vectorMulti = new Vector2D();
        vectorMulti.x = this.x * x;
        vectorMulti.y = this.y * x;
        return vectorMulti;

    }

    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2D normalize() {
        Vector2D vectorNormal = new Vector2D();
        vectorNormal.x = (this.x)/(this.magnitude());
        vectorNormal.y = (this.y)/(this.magnitude());
        return vectorNormal;
    }

    public Vector2D cloneVector(){
        Vector2D vectorClone = new Vector2D();
        vectorClone.x = this.x;
        vectorClone.y = this.y;
        return vectorClone;
    }

    public Vector2D invert(){
        Vector2D vectorInvert = new Vector2D();
        vectorInvert.x= -this.x;
        vectorInvert.y= -this.y;
        return vectorInvert;
    }

    public Vector2D subtract(Vector2D sub){
        Vector2D subtract = new Vector2D();
        subtract.x = this.x - sub.x;
        subtract.y = this.y - sub.y;
        return  subtract;
    }
    public void set(float x, float y){
        this.x = x;
        this.y = y;
    }
    public void set(Vector2D other){
        set(other.x, other.y);
    }


    public static void main(String args[]){
        Vector2D a= new Vector2D();
        Vector2D b= new Vector2D();
        Vector2D add= new Vector2D();
        Vector2D multiply= new Vector2D();
         Vector2D clone = new Vector2D();
        Vector2D normal= new Vector2D();
        Vector2D invert = new Vector2D();
        Vector2D subtract = new Vector2D();
        a.x = 3;
        a.y = 4;
        b.x = 1;
        b.y = 2;

        add = a.add(b);
        multiply = a.multiply(10);
        normal = a.normalize();
        clone = a.cloneVector();
        invert = a.invert();
        subtract = a.subtract(b);


        System.out.println(a.magnitude());
        System.out.println(add);
        System.out.println(String.format("{%s,%s}", multiply.x, multiply.y));
        System.out.println(String.format("{%s,%s}", normal.x, normal.y));
        System.out.println(String.format("{%s,%s}", clone.x, clone.y));
        System.out.println(String.format("{%s,%s}", invert.x, invert.y));
        System.out.println(String.format("{%s,%s}", subtract.x, subtract.y));
    }

}
