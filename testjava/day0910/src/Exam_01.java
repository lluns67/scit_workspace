import java.util.Scanner;

public class Exam_01 {
    public static void main(String[] args) {
        System.out.print("제품가격을 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int price = scanner.nextInt();
        System.out.printf("제품의 부가세 : %.1f\n", price*0.1);
        System.out.printf("제품 원가 : %.1f", price*0.9);
    }
}
