public class OperTest_01
{
    public static void main(String[] args) {
        int a= 10; //0000 0000 0000 0000 0000 0000 0000 0000
        int b =-1;
        System.out.println(a);
        System.out.printf("%d의 비트모양 ==> %s%n", a, Integer.toBinaryString(a));
        System.out.printf("%d의 비트모양 ==> %s%n", ~a, Integer.toBinaryString(~a));

        int c=1;
        System.out.printf("%d의 비트모양 ==> %s%n", c, Integer.toBinaryString(c));
        c = c << 1;
        System.out.printf("%d의 비트모양 ==> %s%n", c, Integer.toBinaryString(c));

        int d, e, f;
        d = 0b1101;
        e = 0b1010;

        f = d & e; //
        System.out.printf("%d의 비트모양 ==> %s%n", f, Integer.toBinaryString(f));
        f = d | e;
        System.out.printf("%d의 비트모양 ==> %s%n", f, Integer.toBinaryString(f));
        f = d ^ e;
        System.out.printf("%d의 비트모양 ==> %s%n", f, Integer.toBinaryString(f));

        int finalData = 2147483647;
        ++finalData;
        System.out.printf("%d의 비트모양 ==> %s%n", finalData, Integer.toBinaryString(finalData));
    }
}
