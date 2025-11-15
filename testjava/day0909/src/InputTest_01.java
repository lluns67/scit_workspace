import java.util.Scanner;

public class InputTest_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //System 이라는클래스 안의in 이라는 이름의 변수명

        String name;
        double height, weight;
        boolean gender; //성별, true이면 남성, false이면 여성이라고 합시다.

        double stdweight;
        double bmi;

        //입력 (이름, 성별, 키, 몸무게);
        System.out.print("이름 : ");
        name = scanner.next();
        System.out.print("성별 : ");
        gender = scanner.nextBoolean();
        System.out.print("키(cm) : ");
        height = scanner.nextDouble();
        System.out.print("몸무게 : ");
        weight = scanner.nextDouble();
        bmi = weight / (height*0.01) * (height*0.01);
        stdweight = (height - 100) * 0.9;
        System.out.printf("이름은 %s 성별은 %s, 키 : %.2fcm, 몸무게 %.2fcm, bmi는 %.2f, 표준체중은%.2f"
                , name, gender ? "남성" : "여성", height, weight, bmi, stdweight);

    }
}
