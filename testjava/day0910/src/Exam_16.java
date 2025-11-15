import java.util.Scanner;

public class Exam_16 {
    public static void main(String[] args) {
        int egg = 0;
        int weight = 0;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("#달걀무게를 입력하시오(g단위) : ");
            weight = scanner.nextInt();
            if (weight < 150) System.out.println("* 메추리알 가지고 장난하지 마시오~ ^^\n");
            else System.out.printf("* 달걀개수 : %d\n",++egg);
            if (egg == 10) break;
            else continue;

        }
        System.out.println("\n*** 달걆포장이 끝났습니다.");
    }
}
