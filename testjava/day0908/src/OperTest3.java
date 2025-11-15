public class OperTest3 {
    public static void main(String[] args) {
        int a = 0, b;

        ++a;
        System.out.printf("a = %d\n", a);
        a++;
        System.out.printf("a = %d\n", a);

        a = 0;
        b = ++a;
        System.out.printf("a = %d, b = %d\n", a, b);

        a = 13;
        b = a++;
        System.out.printf("a = %d, b = %d\n", a, b);

    }
}
