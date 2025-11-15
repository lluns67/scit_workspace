import java.util.Scanner;

public class Exam_29 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] reseve = new String[10];
        String name;


        int seat, count;
        count = 0;
        while(count < 10){
            System.out.println("좌석 예약 상태");
            for (int i = 0; i < reseve.length; i++) {
                if(reseve[i] == null) System.out.print("[     ]");
                else System.out.print("["+reseve[i]+"]");
            }
            System.out.println();
            System.out.print("\n예약자 이름 입력 : ");
            name = sc.next();

            System.out.print("좌석 입력 (1~10: ");
            seat = sc.nextInt();
            if( seat <1 || seat > 10){
                System.out.println("\n##예약을 다시 진행해 주세요"); continue;
            }
            if(reseve[seat-1] != null){
                System.out.println("(warning) 이미 예약된 좌석입니다, "); continue;
            }

            reseve[seat-1] = name;
            count++;
    }
        for (int i = 0; i < reseve.length; i++){
            System.out.print("["+reseve[i]+"]");
        }
}}
