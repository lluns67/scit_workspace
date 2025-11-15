import java.sql.SQLOutput;

public class ExceptionTest_04 {
    public static void main(String[] args) {
        int a = 10;
        int b = 29;
        int result = 0;

        // a값이 b값보다 작으면 익셉션이 발생하도록 한다.
        try {

        if(a < b)
            throw new Exception("a값은 b값보다 커야합니다.");
        } catch (Exception e){
            System.out.println("에러가 발새욈");
            return;
        } finally {
            System.out.println("리소스 저ㅓㅇ리하는 코드");
        }
            result = a/b;
        System.out.println("결과: "+ result);
    }
}
