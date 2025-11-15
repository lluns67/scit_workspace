import java.util.Scanner;

public class Exam_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("박테리아가 몇 마리입니까?");
        int vac = scanner.nextInt();
        System.out.print("경과시간을 입력 해주세요. (분) ");
        int min = scanner.nextInt();
        System.out.println("총 박테리아 수 : " +(vac + (int)((vac*0.1)*(min/30))));
    }
}
