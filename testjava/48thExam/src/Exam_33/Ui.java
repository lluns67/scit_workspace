package Exam_33;

import Exam_33.vo.Client;

import java.util.Scanner;

public class Ui {

    Scanner sc = new Scanner(System.in);
    String choice;
    Service serv = new Service();
    public void showmenu(){

            while (true) {
                System.out.println("======");
                System.out.println("1.등록");
                System.out.println("2.출력");
                System.out.println("3.프로그램 종료");
                System.out.println("======");
                System.out.print("선택 : ");
                choice = sc.next();
                sc.nextLine();
                switch (choice) {
                    case "1":
                        regist();
                        break;
                    case "2":
                        serv.print();
                        break;
                    case "3":
                        System.exit(0);
                    default:
                        System.out.println("다시 입력바랍니다.");
                }
            }

    }

    private void regist(){
        System.out.print("이름 입력 : "); String name = sc.nextLine();
        System.out.print("회원번호 입력 : "); String csn = sc.nextLine();
        System.out.print("몸무게(kg) 입력 : "); double weight = sc.nextDouble();
        System.out.print("키(cm) 입력 : "); double height = sc.nextDouble();
        sc.nextLine();
        if(serv.checker(csn)){
            serv.addregister(csn,name,weight,height);
            System.out.println("등록 완료");
        } else {
            System.out.println("같은 회원번호가 었습니다");
        }


    }

}
