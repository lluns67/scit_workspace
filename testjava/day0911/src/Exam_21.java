import java.util.Scanner;

public class Exam_21 {
    public static void main(String[] args) {
        System.out.print("정수를 입력하세요:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a<2 | a>9 ) System.out.println("에러~ 2~9까지만");
        else {
        for (int i = 1; i < 10; i++) {
            System.out.println(a + " x " + i + " = " + a*i);
        }}
    }
}
