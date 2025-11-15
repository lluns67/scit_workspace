package maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Friend{
    String name;
    String phone;

    public Friend(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class MapAPITest_02 {
    public static void main(String[] args) {
        Map<Integer, Friend> map = new HashMap<>();

        //삽입
        map.put(1, new Friend("이몽룡", "1234"));
        map.put(2, new Friend("성춘향", "0101"));
        map.put(3, new Friend("김방자", "2424"));
        map.put(4, new Friend("황단단", "1111"));
        map.put(5, new Friend("심봉사", "2222"));

        //수정
        Friend f = new Friend("성충향", "0111");
        map.put(2,f); //2번이 존재하기 떄문에 또 2번을 넣으면  수정된다.

        // 삭제
        map.remove(4);
        System.out.println("향단이가 지워졌지? " + ((f != null)? "지워짐":"못지웠음"));

        //조회
        f = map.get(5);
        System.out.println("심봉사의정보: " + (f.name) + ", " + (f.phone));

        //전체 출려
        System.out.println(map); //toString()으로 출력됨
        System.out.println("친구는 " + map.size() + "명");

        //모든 목록을 순회하기 --> 먼저 Key(Set)만 따로 조회를 한다.
//        Set<Integer> key = map.keySet(); //set에 키들만 따로 가져옴
        Iterator<Integer> iter =map.keySet().iterator();
        while (iter.hasNext()){
            Integer k = iter.next();
            Friend friend = map.get(k);
            System.out.println(friend.name + " : " + friend.phone);
        }
    }
}
