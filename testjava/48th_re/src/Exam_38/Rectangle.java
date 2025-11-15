package Exam_38;

public class Rectangle extends Point{
    private int w;
    private int h;

    public Rectangle() {
    }

    public Rectangle(int x, int y, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;
    }
}
