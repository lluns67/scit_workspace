import java.util.ArrayList;

public class ExpceptionTest_01 {
    public static void main(String[] args) {
        try {
            String[] str = {"abc", "123", "0", "12"};

            System.out.println("매여릐 크기" + str.length);
            String temp = str[str.length-1];

            // 문자열로 처리된 숫자를 연산이가능한 형태로 변환 ==> 파싱
            int i1 = Integer.parseInt(str[3]);
            int i2 = Integer.parseInt(str[2]);
            System.out.println("연산의 결과 " + (i1/i2));

            System.out.println("에러가 발생하지 않으면ㅁ 추력!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(); //            권장 o
            System.out.println("에ㅔ러");
            String msg = e.getMessage();
            System.out.println(msg);
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());  // 권장 x
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
