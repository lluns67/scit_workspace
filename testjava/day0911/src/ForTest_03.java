import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ForTest_03 {
    public static void main(String[] args) throws IOException {
//        for (int i = 0; i < 128; i++) {
//            System.out.printf("%d : %c\n",i, (char)i );
//        }
//        System.out.printf("%d", (int)' ');
//        for (char ch = 12354; ch <= 20000 ; ch++) {
//            System.out.printf("%c%d%c",ch,(int)ch, ch%40 == 0 ? '\n' :' ');
//        }
            InputStream keyin = System.in;
        Scanner sc = new Scanner(System.in);
//        int data;
        String str = null;
        while (true){
//            data = sc.nextInt();
//            System.out.println(data);
            System.out.printf("글자를 입력 :");
//            str = sc.next(); //입력버퍼의 모든 데이터
            str = sc.nextLine();
            System.out.println(str);

        }
    }
}