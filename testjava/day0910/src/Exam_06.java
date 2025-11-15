import java.util.Scanner;

public class Exam_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수입력 :");
        int a = scanner.nextInt();
        if(a % 4 ==0 && a % 5 == 0) System.out.println("4와 5로 나누어집니다.");
        else System.out.println("4와5로 나누어 지지 않습니다.");
        if (a % 4 == 0 || a % 5 == 0) {
            System.out.println("4또는 5로 나누어 집니다.");
          if (a % 4 ==0) System.out.println("4로 나누어 떨어집니다.");
           else System.out.println("5로 나누어집니다.");
        }
    }
}
