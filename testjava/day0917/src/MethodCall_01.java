public class MethodCall_01 {
    public static void main(String[] args) {
        int a, b;
        a=11;
        b=20;
        System.out.println("a + " +a+" b = "+b);

        exchange(a,b);
    }
    public static void exchange(int a,int b){
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a + " +a+" b = "+b);
    }
}
