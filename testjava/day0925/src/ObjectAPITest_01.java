import java.awt.*;
import java.util.Objects;

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}


public class ObjectAPITest_01 {
    public static void main(String[] args) {
        Person p = new Person("홍길덩",24);
        System.out.println(p.toString());

        Person p2 = new Person("홍길덩",24);
        System.out.println(p2.toString());

        System.out.println(p == p2);
        System.out.println(p.equals(p2));
    }
}
