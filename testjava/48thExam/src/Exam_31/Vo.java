package Exam_31;

public class Vo {

    private String name;
    private String race;
    private String age;



    public Vo(String name, String race, String age) {
        this.name = name;
        this.race = race;
        this.age = age;



    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getAge() {
        return age;
    }
    public void print(){

            System.out.printf("이름 : %s, 나이 : %s, 종류 : %s\n", name,age,race);

    }
}
