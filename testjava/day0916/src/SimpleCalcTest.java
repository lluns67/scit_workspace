public class SimpleCalcTest {
    public static void main(String[] args) {
        SimpleCalc calc = new SimpleCalc();
        int a;
        a = calc.plus(12,23);
        System.out.println("plus 결과 ?:"  + a);
        a = calc.minus(12,23);
        System.out.println("minus 결과? :"  + a);
        a = calc.multiply(12,23);
        System.out.println("multiply 결과? :"  + a);
    }
}
