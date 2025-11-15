package comparetest;

public class MyCompareTest_01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        String result = (a-b) > 0 ? "a가 b보다 크다":
                        (a-b) < 0 ? "b가 a보다 크다" : "a와b가 같다";

        System.out.println(result);

        String x = "Korea";
        String y = "Corea";

        result = x.compareTo(y) > 0 ? "Korea 가 Corea보다 크다":
                x.compareTo(y) < 0 ? "Korea가 Corea보다 작다" : "Korea와 Corea가 같다.";
        System.out.println(result);
    }
}
