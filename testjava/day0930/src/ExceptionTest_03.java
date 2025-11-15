import java.util.Scanner;

public class ExceptionTest_03 {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int a,b;
            int result = 0;
        for (int i = 0; i < 5; i++) {
            try {
                System.out.print("## 정수 2개 입력: ");
                a = keyin.nextInt();
                b = keyin.nextInt();
                result = divide(a, b);

            } catch (Exception e){
                if(e.getMessage() == null) System.out.println("정수만 입력하세요!");
                else System.out.println(e.getMessage());
                keyin.nextLine();
                continue;
            }
            System.out.println("a/b나누기 결과: " + result);
        }
    }
    public static int divide(int a, int b) throws Exception{
        if(b==0) throw new Exception("분모의 값으로 0이 전달되어 오류");
        return a/b;
    }
}