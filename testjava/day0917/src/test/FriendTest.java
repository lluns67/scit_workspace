package test;

import vo.Friend;



import java.time.LocalDate;
import java.util.Scanner;

public class FriendTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String sms;
        LocalDate birthday;
        int age;
        Boolean type;
        System.out.print("이름: "); name=scanner.next();
        System.out.print("sns: "); sms =scanner.next();

        System.out.print("생일: "); birthday = LocalDate.parse(scanner.next());

        System.out.print("나이: "); age =scanner.nextInt();
        System.out.print("성격: "); type =scanner.nextBoolean();

        Friend fd = new Friend(name, sms, birthday, age, type);

        fd.output();
        Friend fd2 = new Friend();
        fd2.output();


    }
}
/* private String name;
    private String sns;
    private LocalDate birthday;
    private int age;
    private boolean type; //

    ~129p
    */