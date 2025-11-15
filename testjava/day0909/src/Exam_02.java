
import java.util.Scanner;

/*점수 3개 (if, japanese, common) 을 입력받는다. (점수는 0~100까지)
It 40 japanese 30, common 30%로 환산한 점수의 합이 70점 이상이면 pass, 아니면 fail
최종 결과점수 : ( 75 * 0.4 + 80 * 0.3 + 70 * 0.3) >= 70면 pass 아니면 fail
 */
public class Exam_02 {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int it, japanese, common;
        System.out.println("it, japne, common 입력");
        it = keyin.nextInt() ; japanese = keyin.nextInt(); common = keyin.nextInt();
        double final_score = it*0.4 + japanese * 0.3 + common * 0.3;

        boolean isFailure = (it < 40 || japanese < 40 || common < 40) ? true : false;

        String result = final_score >= 70 ? "pass": "fail";
        System.out.printf("최종점수는 %f이고 과락이 %s음, 최종%s입니다.", final_score,(isFailure) ? "있" : "없", result);
    }
}
