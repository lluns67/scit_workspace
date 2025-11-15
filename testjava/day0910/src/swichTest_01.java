import java.util.Scanner;

public class swichTest_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("출생년도는 : ");
        int birthyear = scanner.nextInt();
        String zodiac = null;
        zodiac = switch(birthyear%12){
            case 0 ->
                 "원숭이";
            case 1 -> "양";
                
            case 2->
                "개";
            case 3->
                "돼지";
            case 4->
                "쥐";
            case 5->
                "소";
            case 6->
                "호랑이";
            case 7->
                "토끼";
            case 8->
                "용";
            case 9->
                "뱀";
            case 10->
                "말";
            case 11->
                "양";

            default -> throw new IllegalStateException("Unexpected value: " + birthyear%12);
        };
        System.out.printf("띠는 %s", zodiac);



    }}