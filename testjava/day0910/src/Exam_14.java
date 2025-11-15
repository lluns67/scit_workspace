import java.util.Scanner;

public class Exam_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫  번째 수 입력 : ");
        int a = sc.nextInt();
        System.out.print("두  번째 수 입력 : ");
        int b = sc.nextInt();
        System.out.println("=============");
        System.out.println("1.덧셈");
        System.out.println("2.뺼셈");
        System.out.println("3.곱셈");
        System.out.println("4.나눗셈");
        System.out.println("=============");
        System.out.print("메뉴 선택 : ");
        int ch = sc.nextInt();
        int result = 0;
        String aaa = null;
        switch (ch){
            case 1: {result = a + b; aaa = "덧셈"; break;}
            case 2: {result = a - b; aaa = "뺼셈"; break;}
            case 3: {result = a * b; aaa = "곱셈"; break;}
            case 4: {result = a / b; aaa = "나누셈"; break;}
        }
        System.out.printf("%s 결과 : %d", aaa, (int)result);
    }
}
