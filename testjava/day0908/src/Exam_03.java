import java.util.Scanner;

public class Exam_03 {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        double height, stdWeight;
        System.out.println("\n키와 몸무게는 ?");
        height = keyin.nextDouble();

        stdWeight = (height - 100) * 0.9;
        System.out.printf("%fcm 적정 몸무게는 %f", height, stdWeight);
    }
}
