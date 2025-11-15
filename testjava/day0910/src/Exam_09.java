import java.util.Scanner;

public class Exam_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b,c, temp;
        System.out.println("1번째수 입력 :");
        a = scanner.nextInt();
        System.out.println("2번째수 입력 :");
        b = scanner.nextInt();
        System.out.println("3번째수 입력 :");
        c = scanner.nextInt();

        if ( a < b) {
            temp = a;
            a = b;
            b = temp;
            }
        if ( a < c) {
            temp = a;
            a = c;
            c = temp;


        }
        if ( b < c) {
            temp = c;
            c = b;
            b = temp;


        }
        System.out.printf("%d %d %d",a, b, c);
        }
    }

