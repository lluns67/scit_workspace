package Exam_30;

import java.util.Scanner;

public class Service {
    Scanner sc = new Scanner(System.in);
    private Vo[] vo = new Vo[1000];
    private String tmp = null;
    public String choice;
    private int count = 0;



    public void menu(){
        while(true){
        System.out.println("===============");
        System.out.println("1.예약");
        System.out.println("2.조회");
        System.out.println("3.전체출력");
        System.out.println("4.프로그램종료");
        System.out.println("===============");
        System.out.print("선택 : ");

        choice = sc.next();
        sc.nextLine();


            switch (choice){
                case "1": reservation(); break;
                case "2": retreive(); break;
                case "3": print(); break;
                case "4": exit(); break;
                default:
                    System.out.println("다시 입력 해주세요");
            }
        }
    }
    public void reservation(){
        Vo vo_reg = new Vo();
        System.out.print("이름을 입력 : "); vo_reg.setName(sc.nextLine());
        System.out.print("차번호를 입력 :"); vo_reg.setCarnumber(sc.nextLine());
        System.out.print("전화번호를 입력 : ");
        vo_reg.setPhonenumber(sc.nextLine());
        System.out.print("위치를 입력 : "); vo_reg.setLocation(sc.nextLine());
        vo[count] = vo_reg; count++;


    }
    public void retreive(){
        System.out.print("전화번호 입력 :"); tmp = sc.next();
        for (int i = 0; i < count; i++) {
            if(vo[i].getPhonenumber().equals(tmp)){
                System.out.println("====================");
                System.out.println("이름 : " + vo[i].getName());
                System.out.println("차번호 : " + vo[i].getCarnumber());
                System.out.println("전호번호 : " + vo[i].getPhonenumber());
                System.out.println("위치 : "+ vo[i].getLocation());
                System.out.println("====================");
                return;
            }
        }
        System.out.println("검색결과기 없습니다.");


    }
    public void print(){
        if(count == 0) {
            System.out.println("예약된 정보가 하나도 없습니다."); return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("====================");
            System.out.println("이름 : " + vo[i].getName());
            System.out.println("차번호 : " + vo[i].getCarnumber());
            System.out.println("전호번호 : " + vo[i].getPhonenumber());
            System.out.println("위치 : "+ vo[i].getLocation());
            System.out.println("====================");
        }
    }
    public void exit(){
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}
