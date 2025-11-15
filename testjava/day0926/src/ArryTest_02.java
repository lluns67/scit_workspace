import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArryTest_02 {
    public static void main(String[] args) {
        List<String> market = new ArrayList<>();

        market.add("바나나");
        market.add("망고");
        market.add("메론");
        market.add("감자");
        market.add("사과");

        System.out.println("데이터의 갯수: "+market.size());
        String temp = market.get(2);
        System.out.println("꺼낸 데이터 3번: ^" + temp);
        //일반 for
        for (int i = 0; i < market.size(); i++) {
            System.out.print(market.get(i) + " ");
        }
        System.out.println();
        // for~in 반복문으로 꺼내기
        for(String i:market){
            System.out.print(i + " ");
        }
        System.out.println();
        //Iterator로 꺼내기
        Iterator<String> iter = market.iterator();
        while(iter.hasNext()) System.out.print(iter.next()+" ");
        System.out.println();
        //Lambda 메소드로 꺼내기
        market.forEach(s-> System.out.print(s+" "));

        //consumer(전달받기만 하고 반환은 안하는 메ㅗ드,
        // produce (받는 건 없이 반환만 하는 것 random)
    }
}
