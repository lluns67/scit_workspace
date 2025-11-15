import java.util.Scanner;

public class Exam_13 {
    public static void main(String[] args) {
        int use, rate,choice;
        Scanner sc = new Scanner(System.in);
        System.out.print("사용자 코드를 입력하시오(1 : 가정용 /" +
                " 2: 상업용 / 3 : 공업용)");
        choice = sc.nextInt();
        rate = switch (choice){
            case 1 -> 50;
            case 2 -> 45;
            case 3 -> 30;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
        System.out.print("사용량을 입력하시오(ton단위) : ");
        use = sc.nextInt();
        System.out.println("사용자 코드 : "+choice+"(가정용)");
        System.out.println("사용량 : " +use+"ton");
        System.out.println("총 수도요금 : " + (int)(use*rate*1.05 )+ "원");
    }
}
