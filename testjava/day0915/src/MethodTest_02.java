import java.util.Scanner;

public class MethodTest_02 {
    public static void main(String[] args) {
        int result=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("두개의 숫자 :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print("이번연산(+,-,*)? ");
        String op = sc.next();
        switch (op){
            case  "+": result =plus(a,b); op="더하기";break;
            case "-" : result =minus(a,b); op="뺴기";break;
            case "*" : result =multiply(a,b); op="곱하기";break;
            default:
                System.out.println("연산자를 잘못 입력했습니다.");
//                System.exit(4885); // 프로그램 강제 종료
                return; //메인메소두거 반환됨
        }


        System.out.printf("%s %d ", op, result);
    }
    public static int plus(int a, int b){
        return a+b;
    }
    public static int minus(int a, int b){
        return a-b;
    }
    public  static int multiply(int a, int b){
        return a*b;
    }
}
