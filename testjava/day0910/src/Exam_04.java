import java.util.Scanner;

public class Exam_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b,c;
        System.out.print("전공 이수 하점 :");
        a = scanner.nextInt();
        System.out.print("교양 이수 하점 :");
        b = scanner.nextInt();
        System.out.print("일반 이수 하점 :");
        c = scanner.nextInt();
        if(a+b+c >= 140 && a >= 70
                && ((b == 30 || c == 30) || (b+c)>80 ) ){
            System.out.println("졸업가능");
        }
        else System.out.println("졸업불가능");
    }
}
