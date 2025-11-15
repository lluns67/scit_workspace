import java.util.Scanner;

public class Exam_02 {
    public static void main(String[] args) {
        float r;
        Scanner scanner = new Scanner(System.in);
        System.out.println("원의 반지름");
        r = scanner.nextFloat();
        System.out.printf("반지름 %.2f인 원의 면적 : %.2f", r, r*r*3.14);

    }
}
