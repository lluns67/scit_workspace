import java.util.ArrayList;
import java.util.List;

public class ArrayTest_03 {
    public static void main(String[] args) {
        List<String> market = new ArrayList<>();

        market.add("바나나");
        market.add("망고");
        market.add("메론");
        market.add("사과");
        market.add("감자");
        market.add("사과");
        market.add("사과");

        market.add(1,"주스");
        System.out.println(market);

        Boolean result = market.contains("소고기");
        System.out.println("소고기를 추가했나" + result);
        String data = market.set(2,"돼지고기 앞다리살");
        System.out.println("장바구니에서 뺀 물건: "+data);

        result = market.remove("사과");
        System.out.println("사과 뺏니?" + result);
        System.out.println(market);
        System.out.println("장바구니에 넣은 물건개수: "+market.size());
        System.out.println("장바구니가 비었니? " + market.isEmpty());

        market.clear();
        System.out.println("장바구니가 비었니? " + market.size());

    }
}
