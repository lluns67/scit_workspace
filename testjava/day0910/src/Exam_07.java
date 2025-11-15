import java.util.Scanner;

public class Exam_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double incom;
        double tax;
        System.out.println("1주일 간의 근무시간을 입력하시오 : ");
        float hour = scanner.nextFloat();
        if (hour > 40) {
            incom = (40 * 10320) + ((hour - 40) * 10320* 1.5);
        }
        else incom = (int)(hour * 10320);


        if (incom > 300000){
            tax = (300000 * 0.15) + (incom - 300000)*0.25;
        } else tax = incom * 0.15;

        System.out.println("# 총수입 : " + (int)incom + "원");
        System.out.println("# 세금   : " + (int)tax + "원");
        System.out.println("# 실수입 : " + (int)(incom-tax) + "원");
    }
}
