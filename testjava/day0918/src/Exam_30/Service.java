package Exam_30;

import java.util.Scanner;

public class Service {
    private Vo vo = new Vo();
    Scanner sc = new Scanner(System.in);

    public Service() {


        String choice;


        while (true) {
            menu();
            choice = sc.next();
            switch (choice) {
                case "1":
                    reservation();
                    break;
                case "2":
                    reterive();
                    break;
                case  "3":
                    print();
                    break;
                case  "4":
                    exit();
            }

        }
    }



    private void reservation(){
        System.out.print("이름을 입력 :");
        System.out.println(vo);
        vo.setName(sc.next());
        System.out.print("차번호를 입력 :"); vo.setCarnumber(sc.next());
        System.out.print("전화번호를 입력 :"); vo.setPhonenumber(sc.next());
        System.out.print("위치를 입력 : "); vo.setPlace(sc.next());

    }
    private void reterive(){
        System.out.println("전화번호 입력 :"+vo.getPhonenumber());
    }
    private void print(){
        System.out.println("이름 :" + vo.getName());
        System.out.println("차번호 : "+ vo.getCarnumber());
        System.out.println("전화번호" +vo.getPhonenumber());
        System.out.println("위치를 입력 : " +vo.getPlace());
    }

    private void menu(){
        System.out.println("=============");
        System.out.println("1.예약");
        System.out.println("2.조회");
        System.out.println("3.전체출력");
        System.out.println("4.프로그램종료");
        System.out.println("=============");
        System.out.print("선택 : ");
    }
    private void exit(){
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

}
