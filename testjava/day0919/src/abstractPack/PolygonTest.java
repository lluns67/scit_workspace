package abstractPack;
abstract class polygon {
    int x,y;
    abstract double area();
    void output(){
        System.out.printf("x=%d, y=%d ", x,y);
    }
}
class MyCircle extends polygon{
    double radius;
    @Override
    double area() {
        return radius*radius*Math.PI;
    }
    @Override
    void output(){
        super.output();
        System.out.printf("radius = %f, area = %f", radius, this.area());
    }
}
class MyRectangle extends polygon{
    int width;
    int height;

    @Override
    void output() {
        super.output();
        System.out.printf(", width = %d, height = %d, area =%f", width, height, this.area());
    }

    @Override
    double area() {
        return width*height;
    }


}
public class PolygonTest {
    public static void main(String[] args) {
        MyCircle c = new MyCircle();
        c.x = 1;
        c.y = 5;
        c.radius = 7;
        c.output();
        System.out.println();
        MyRectangle r = new MyRectangle();
        r.x =5;
        r.y = 10;
        r.width =4;
        r.height = 3;
        r.output();
    }
}
