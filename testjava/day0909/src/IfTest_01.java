//if 실행문이 딱 1개일 경우 {}을 삭제해도 됨;

public class IfTest_01 {
    public static void main(String[] args) {
        int data = 15;

        if(data>10)System.out.println("10이 넘습니다. ");
        if(data%2==0) System.out.println("짝수"); else System.out.println("홀수");

        if(data % 3 == 0) System.out.println("나머지가 0인 수");
        else if (data % 3==1) {
            System.out.println("나머지가 1인수");


        } else if (data % 3== 2) {
            System.out.println("나머지가 2인수"

            );
        }

        System.out.println("끝");
    }
}
