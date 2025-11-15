import java.util.Scanner;

public class Exam_26 {
    public static void main(String[] args) {
        System.out.print("정수 입력 : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int primeCount = 0;

        boolean ox;
        for (int i = 2; i <= a;i++) {
            ox = true;
            for (int j = 2; j < i; j++) {
              
                if(i %j==0) { ox=false; break;}


            }//j
               if(ox==true) {System.out.printf("%d\t", i);
               primeCount++;}
        }//i
        System.out.printf("\n2~%d까지 소수의 개수는 %d개 입니다.",a, primeCount);
    }
}
