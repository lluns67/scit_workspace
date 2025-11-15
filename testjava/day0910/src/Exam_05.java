import java.util.Scanner;

public class Exam_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double value, chanvalue;
        int choice;

        System.out.println("입력단위는 (1. cm, 2. Inch) : ");
        choice = scanner.nextInt();
        System.out.println("길이 입력 : ");
        value = scanner.nextDouble();
        if (choice == 1) chanvalue = value *0.3937;
        else chanvalue = value * 2.54;

        System.out.printf("%f %s = %f %s", value, (choice ==1 ? "cm" : "inch"), chanvalue, (choice ==2 ? "cm" : "inch"));

    }
}
