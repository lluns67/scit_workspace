package comparetest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Friend implements Comparable<Friend>{
String name;
String phone;

public Friend(String name, String phone) {
    this.name = name;
    this.phone = phone;
}

    @Override
    public int compareTo(Friend o) {
        int result = (this.name.compareTo(o.name)) > 0 ? 1 :
                (name.compareTo(o.name)) < 0 ? -1: 0;
        return result;
    }
}
public class MyCompareTest_02 {
    public static void main(String[] args) {
        Friend f1 = new Friend("손오공", "010-1234-5678");
        Friend f2 = new Friend("전우치", "019-0101-3456");
        Friend f3 = new Friend("전우치", "019-0101-3456");
        //우리가 직ㄱ접 작성한 객체를 비겨하고 싶으면??
        //클래스 내부에 비교가 가능한 compareTo를 만들면 됨
        //비교할 수 있도록 해주는 인터페이스를 구현하면 됨!
        //왜 구현해야하나요? 정렬해서 출력하기 위해!
        //String 클래스도 Compareable 인터페이스를 구현해던 것이었다!
        int result = f1.compareTo(f2);
        System.out.println(result);

        result = f2.compareTo(f3);
        System.out.println(result);

        // 1)정렬하기 --> 그 객체에 compareTo가 오버라이딩이 되어 있어야 한다.
        List<Friend> list = new ArrayList<>();

        list.add(new Friend("이몽룡", "1234"));
        list.add(new Friend("성춘향", "5678"));
        list.add(new Friend("심봉사", "0101"));
        list.add(new Friend("김방자", "22424"));
        list.add(new Friend("한향단", "0457"));

        list.sort((c,d) -> c.compareTo(d));

        for(Friend f : list){
            System.out.println(f.name + " : " + f.phone);
        }
        System.out.println();
        list.sort((c,d) -> d.compareTo(c));

        for(Friend f : list) {
            System.out.println(f.name + " : " + f.phone);
        }
            Collections.sort(list, (c,d)->
                    (c.phone.compareTo(d.phone) > 0) ? 1 :
                            ((c.phone.compareTo(d.phone) < 0) ? -1 : 0));

            System.out.println("=== 전화번호 순으로 정렬===");
            for(Friend f : list) {
                System.out.println(f.name + " : " + f.phone);

        }
    }
}