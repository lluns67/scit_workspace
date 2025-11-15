import java.util.Scanner;

public class Exam_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("* 연간 글로소득입력 : ");
        int inc  = sc.nextInt();
        double tax;
        if (inc <= 2000) {
            tax = inc*0.05;
        } else if (inc <= 4000){
            tax = inc*0.15;
        } else if (inc <= 8000){
            tax = inc*0.25;
        } else {
            tax =inc*0.4;
        }
        System.out.printf("당신의 소득세는 :  %d 입니다.", (int)tax);
    }
}
