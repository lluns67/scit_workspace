import java.util.Scanner;

public class BufferTest_02 {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        String name;
        int age;
        String address;

        System.out.print("이름: "); name = keyin.next();
        System.out.print("나이: "); age = keyin.nextInt(); // (엔터)24(엔터)
        keyin.nextLine();
        System.out.print("주소: "); address = keyin.nextLine(); //(엔터)

        System.out.println();

        System.out.printf("당신은 %s, %d살, %s\n", name, age, address);
    }
}
