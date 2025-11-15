class Student {
    private String name;
    private int age;

    public Student(){

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Junior extends Student{
    private String grade;

    public Junior() {
    }

    public Junior(String grade) {
        this.grade = grade;
    }

    public Junior(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
}

public class ObjectAPITest_01 {
    public static void main(String[] args) {
        Student s = new Student();
        Junior j = new Junior();

        System.out.println(s instanceof Student);
        System.out.println(j instanceof Student);
        System.out.println(j instanceof Junior);
        System.out.println(s instanceof Object);
        System.out.println(s instanceof Junior);
//        System.out.println(s instanceof String);  비교할 수 없는 관계
        Student ss = new Junior();
        System.out.println(ss instanceof Student);
        System.out.println(ss instanceof Junior);



    }
}
