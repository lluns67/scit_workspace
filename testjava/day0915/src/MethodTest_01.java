public class MethodTest_01 {
    public static void main(String[] args) {
        int result = add(1,10);
        System.out.println("메소드 실행결과: " + result);

    }
    public static int add(int a, int b){
        int result = a+ b;
        output(a,b);
        return result;
    }
    public static void output(int a, int b){
        if(a<b){
            for (int i = a; i < b; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
