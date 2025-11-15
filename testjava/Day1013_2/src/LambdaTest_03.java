//상수변수, 메소드선언부, static, default

@FunctionalInterface
interface SimpleCalc3 {
    public int plus(int a, int b);
    int value =1;
    static void func1(){}
    static void func2(){}


}
public class LambdaTest_03 {
    public static void main(String[] args) {


//        SimpleCalc3 calc = new SimpleCalc3() {
//            @Override
//            public int plus(int a, int b) {
//                return a + b;
//            }
//
//
//        };
//        SimpleCalc3 c = ( a, b) -> a * b;
//
//        System.out.println(c.plus(10,20));
       int result  = myFunction((a,b) -> a+b);
        System.out.println(result);


    }
    public static int myFunction(SimpleCalc3 c){
        return c.plus(1,2);
    }
}
