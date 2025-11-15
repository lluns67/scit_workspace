public class WrapperTest_02 {
    public static void main(String[] args) {
        String score = "홍길동 100 75 85";
        String[] strings = score.split(" ");
        int sum =  Integer.valueOf(strings[1]) + Integer.valueOf(strings[2]) + Integer.valueOf(strings[3]);
        System.out.println(strings[0]+ "학생의 점수" + sum + "평균은 :" + sum/3);


    String str = "12";
    int i1 = Integer.valueOf(str);

    int i2 = Integer.parseInt(str, 7);
        System.out.println(i2);
    }
}