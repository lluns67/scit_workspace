import java.util.Scanner;

public class Exam_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("년도 입력 :" );
        int year = sc.nextInt();
        System.out.printf("1년도 %d까지 돼지의 해 :", year );
        int i = 1;
        int cnt = 0;
        while (i <= year){
            if(i%12 == 3){
                System.out.println(i + "년");
                cnt++;
            }
            i++;
        }
        System.out.printf("1년에서 %d년까지 돼지의 해는 %d번 있습니다.", year, cnt);
    }
}
