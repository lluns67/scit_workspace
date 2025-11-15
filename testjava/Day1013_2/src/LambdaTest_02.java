//상수변수, 메소드선언부, static, default

interface SimpleCalc {
    public int plus(int a, int b);
    public int minus(int a, int b);
}
public class LambdaTest_02 {
    SimpleCalc calc = new SimpleCalc() {
        @Override
        public int plus(int a, int b) {
            return a +b;
        }

        @Override
        public int minus(int a, int b) {
            return a-b;
        }
    };

}
