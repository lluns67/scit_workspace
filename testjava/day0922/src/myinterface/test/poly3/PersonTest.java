package myinterface.test.poly3;

class Person {
    String memo;
    int age;

    public Person() {
    }

    public Person(String memo, int age) {
        this.memo = memo;
        this.age = age;
    }
}
class Junior extends Person{

}
class Senior extends Person{

}
public class PersonTest {
    public static void main(String[] args) {


        int[] iary = new int[10];
        int[] iarr = {1,2,3,4,5};

        Person[] pary = new Person[10];
        pary[0] = new Person("전우치", 21);
        Person p = new Person("홍길동", 22);

        Person[] arr = {
                new Person("손오공", 26),
                new Person("저팔계", 33)
        };
        Person[] par = {
            new Junior(), new Senior()};

    }
}
