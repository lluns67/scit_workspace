import java.util.Scanner;

/*
키보드로 세과목의 점수를 입력받는다.
합계와 평균(double)을 연산을 한다.
90점 이상이면 a학점
90점 이상이면 b학점
90점 이상이면 c학점
90점 이상이면 d학점
나머지는 f
*/
public class IfTest_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kor, eng, math;
        double avg;
        int temp;

        System.out.println("국영수 점수를 입력하시오");
        kor = scanner.nextInt(); eng = scanner.nextInt(); math = scanner.nextInt();
        avg = (kor + eng + math) / 3.0;
//
//        if(kor >= 90){
//            kor = (char)(kor = 65);
//        }
//
//        System.out.println("국어 : %c 영어 : %c 수학 : %c", kor, eng, math,  );


    }
}
