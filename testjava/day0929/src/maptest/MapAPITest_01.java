package maptest;

import java.util.HashMap;
import java.util.Map;

public class MapAPITest_01 {
    public static void main(String[] args) {
        Map<String, Integer > map = new HashMap<>();
        map.put("전우치", 85);
        map.put("저팔계", 90);
        map.put("홍길동", 80);
        map.put("사오정", 95);

        System.out.println("인원수:" + map.size());
        System.out.println("등록된 인원이 없니? " + map.isEmpty());
        System.out.println("손오공은 등록됐니?  +" +map.containsKey("손오공"));
        System.out.println("점수가 100인 친구가 있니."+ map.containsValue(100));

        Integer delData = map.remove("사오정");
        System.out.println("오정 삭제: " + (((delData) ==null) ? "삭제못함":"삭제완료"));

        // put() 메소드는 삽입잉 잘뙜으면null이 튀어나옴
        Integer result  = map.put("삼장법사", 100);
        System.out.println("삽입결과: " + result);

        // put()) 메소드는 null이 아닌값이튀어나오면 수정됐다는 의미
        result  = map.put("삼장법사", 92);
        System.out.println("수정결과: " + result);
        //키는 중복되면 안됨. 키가 같은 경우의 데이터가존재하면 기존 데잍터가 날아가고
        //새로운 데이터로 대체됨
        //유일한 값이어야 한다. equals() hashcode()가 오버라이드가 되어 있는 클래스는
        //키가 될 수 있다.
        //hashCode()가 같다고 해서 같은 객체가 아니다!! 매우 중요
    }
}