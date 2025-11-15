import java.util.Scanner;

public class Exam_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요");
        int a = sc.nextInt();
        int i = 1;
        while (i <= (int)(a/2)){
            if (a%i == 0){
                System.out.println(i);
            }
            ++i;
        }
    }
}
