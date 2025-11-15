import java.util.Scanner;

public class Exam_28 {
    public static void main(String[] args) {
        final int cnt = 10;
        int[][] answer = new int[2][cnt];
        char[] result = new char[cnt];
        int rightCnt = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("정답을 입력하세요 : ");

        for (int i = 0; i <cnt ; i++) {
            answer[0][i] = sc.nextInt();
        }
            System.out.print("학생의 답을 입력하세요 : ");
//            sc.next();
        for (int i = 0; i <cnt ; i++) {
            answer[1][i] = sc.nextInt();
        }
        for (int i = 0; i < cnt; i++) {
            if(answer[0][i] == answer[1][i]) {
                rightCnt++;result[i]='o';
            }
            else result[i] = 'x';
        }
            System.out.print("결과");
        for (int i = 0; i < cnt; i++) {
            System.out.printf("%c  ",result[i]);
        }
        System.out.printf("(맞은 개수 : %d개)",rightCnt);
    }
}
