import java.awt.*;
import java.util.Scanner;

public class Exam_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float wei;
        float hei;
        double std;
        System.out.print("키입력 : ");
        hei = sc.nextFloat();
        System.out.print("몸무게입력 : ");
        wei = sc.nextFloat();
        std = (hei-100) * 0.9;
        if ( wei < std-10){
            System.out.println("저체중입니다.");
        } else if (wei <= std+10){
            System.out.println("표준체중입니다.");
        } else System.out.println("과체중입니다.");
    }
}
