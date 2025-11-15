package vo;

import java.time.LocalDate;

public class Friend {
    private String name;
    private String sns;
    private LocalDate birthday;
    private int age;
    private boolean type; // 외향적 true, 내성적 false

    public Friend(String name, String sns, LocalDate birthday, int age, boolean type) {
        this.name = name;
        this.sns = sns;
        this.birthday = birthday;
        this.age = age;
        this.type = type;
    }

    public Friend() {this("자바", "kakao", LocalDate.now(),22,false);}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
    public void output(){
        System.out.printf("이름: %s, sns: %s, 생일: %s, 나이: %d, 성격: %b\n",
                name, sns, birthday, age, type);
    }
}
