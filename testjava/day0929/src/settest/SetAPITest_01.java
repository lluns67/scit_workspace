package settest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetAPITest_01 {
    public static void main(String[] args) {
        Set<String> poket = new HashSet <>();

        poket.add("구슬");
        poket.add("연필");
        poket.add("지우개");
        poket.add("삼각자");
        poket.add("사탕");

        System.out.println("주머니에 몇개있니? " + poket.size());
        System.out.println("주머니에 사탕이 있니? " + poket.contains("사탕"));

        poket.add("젤리");
        System.out.println("주머니에 하리보젤리가 있니? " + poket.contains("하리보젤리"));

        System.out.println("주머니에 있는 물건 죄다 꺼내기==");
        Iterator<String> iter = poket.iterator();

        while (iter.hasNext()){ //꺼낼 수 있는지 확인
            System.out.println(iter.next()); //꺼내기
        }

        poket.add("젤리"); // 이 젤리는 안들어감
        poket.clear();

        System.out.println("주머니에 몇 개있니? " + poket.size());

    }
}
