public class OverloadTest_01 {
    public static void main(String[] args) {
        add(10);
        add(10,20);
        add(1.2);
        int a= 0;
        System.out.println("a");
        System.out.println('a');
        System.out.println(a);
    }
    public static int add(int a){
        return 0;
    }
    public static int add(double a){
        return 0;
    }
    public static int add(int a, int b){
        return a+b;
    }
}
