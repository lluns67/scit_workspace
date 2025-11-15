import java.util.Scanner;

public class Exam_23 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d 번째 데이터 =>", i+1);
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println(arr[i]);
        }
    }
}
