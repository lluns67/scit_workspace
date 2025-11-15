package settest;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Friend{
    String name;
    String phone;

    public Friend(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Friend friend)) return false;
        return Objects.equals(name, friend.name) && Objects.equals(phone, friend.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}

public class SetAPITest_02 {
    public static void main(String[] args) {
        Set<Friend> group = new HashSet<>();

        // 등록
        group.add(new Friend("호랑이", "010"));
        group.add(new Friend("여우", "019"));
        group.add(new Friend("토끼", "011"));
        group.add(new Friend("고양이", "123"));
        group.add(new Friend("강아지", "111"));

        //그룹 인원수 체크
        System.out.println("그룹 인원 수: " + group.size());
        //간단히 한 개의 데이터를 꺼낼 수 없다는 사실을 알게디었음.
        //같으 데이터라고 생각되는 데이터를 넣어보면?
        //중복됨!
        //중복된 데이터가 들어가지 않도록하려면? hasgCode()와 equals()를 오버라이딩해야함!
        group.add(new Friend("토끼","011"));
        System.out.println("그룹 인원수: " + group.size());

    }
}
