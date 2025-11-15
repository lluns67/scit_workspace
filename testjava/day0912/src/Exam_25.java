import java.util.Scanner;

public class Exam_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int visit, under, over;
        while(true){
            System.out.println("다음 손님 입장해 주세요.");
            System.out.printf("총 몇  명?");
            visit = sc.nextInt();
            if(visit ==0) continue;
            System.out.print("미성년 인원수는? ");
            under = sc.nextInt();
            System.out.print("노인 인원수는? ");
            over = sc.nextInt();
            if(visit < under + over) break;

            System.out.print("1인 기본요금: 43,000 원\n");
            System.out.printf("미성년 할인요금: %,d 원\n", (int)(43000*(0.15)*under));
            System.out.printf("노인 우대요금: %,d 원\n",(int)(43000*(0.15)*over));
            System.out.printf("총 지불금액은 %,d원입니다.\n", 43000*visit - ((int)(43000*(0.15)*under)+(int)(43000*(0.15)*over)));

        }
        System.out.println("시스템 종료합니다.");
    }
}
