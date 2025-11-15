import java.util.Scanner;

public class Exam_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        byte temp = scanner.nextByte();
        if ((temp >=65 && temp <= 90) || (temp >= 97 && temp <= 122))
        System.out.println((char)temp);
        else System.out.println("알파벳에 해당하는코드 값을 입력하시오.");
    }
}
