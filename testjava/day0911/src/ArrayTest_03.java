import java.util.Scanner;

public class ArrayTest_03 {
    public static void main(String[] args) {
        String[] iary = new String[5];
        Scanner keyin = new Scanner(System.in);
            System.out.print("오늘 먹고싶은거 입력 : ");
        for (int i = 0; i < iary.length; ++i) {
            iary[i] = keyin.next();
        }
        System.out.println();
        for (int i = 0; i < iary.length; i++) {
            System.out.println(iary[i]);

        }
    }
}
