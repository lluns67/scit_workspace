package Exam_38;

public class Circle extends Point{
    private int r;

    public Circle() {
        super();
    }

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }
    public double area(){
        return r*r*3.14;
    }

    @Override
    public String toString() {
        return "Circle" + x + y;
    }
}
