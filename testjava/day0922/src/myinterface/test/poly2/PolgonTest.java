package myinterface.test.poly2;

public class PolgonTest {
    public static void main(String[] args) {
        Polygon polygon = null;

        polygon = new Triangle();
        polygon.edgeCount =3;
        polygon.print();


        polygon = new Rectangle();
        polygon.edgeCount = 4;
        polygon.print();

    }

}
