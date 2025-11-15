public class OperTest2 {
    public static void main(String[] args) {
        int age = 21;
        // 성인이면 true, 아니면 false가저장되도록 3항연산자로 만들어보세요.
        boolean isAdult = (age >= 18) ? true : false;
        System.out.println(isAdult);
        //입장료가 3500원인 놀이동산에서 할인율을 계산하고 싶다.
        //만 8세 이하이거나 65세 이상이면 20% 할인을 한다.
        int fee = 35000;
        age = 65;
        double descountRatio = (age <= 8 || age >= 65) ? 0.2 : 0;
        System.out.println(descountRatio);
        System.out.printf("지불 요금, : %,d원입니다.%n", (int)(fee*(1-descountRatio)));
    }
}
