package myinterface.test.poly2;

public abstract class Polygon {
    int edgeCount;
    abstract double area();
    void print(){
        System.out.println("변의 개수: "+ this.edgeCount);
    }
}

class Triangle extends Polygon {

    @Override
    double area() {
        return 0;
    }
}

class Rectangle  extends Polygon{

    @Override
    double area() {
        return 1;
    }
}