import java.util.Scanner;

public class Exam_20 {
    public static void main(String[] args) {
        System.out.print("정수 입력 :");
        Scanner sc = new Scanner(System.in);
        int sum =0;
        int j = sc.nextInt();
        for (int i = 1; i <= j  ; i++) {
            sum += i;
        }
        System.out.printf("1~%d까지 더한 값 : %d",j, sum);

    }
}
