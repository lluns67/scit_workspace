package Exam_32.service;

import Exam_32.vo.Accountvo;

import java.util.Scanner;

public class Accountservice {
    Scanner sc = new Scanner(System.in);
    private Accountvo av[] = new Accountvo[100];
    private int cnt = 0;
    String choice;




    public void menu(){
        while(true){
        System.out.println("=======은행계좌관리=======");
        System.out.println("1.계좌등록");
        System.out.println("2.전체출력");
        System.out.println("3.입금");
        System.out.println("4.출금");
        System.out.println("5.송금");
        System.out.println("6.프로그램종료");
        System.out.println("=======================");
        System.out.print("선택 : ");
            choice = sc.next();
            sc.nextLine();

            switch (choice){
                case "1": accrountegister(); break;
                case "2": print(); break;
                case "3": deposit(); break;
                case "4": withdraw(); break;
                case "5": remit();break;
                case "6": exit();
                default:
                    System.out.println("다시입력해주세요");
            }
        }
    }
    private void accrountegister(){
        Accountvo avtmp = new Accountvo();
        System.out.print("계좌주 이름 입력: "); avtmp.setName(sc.nextLine());
        System.out.print("계좌 번호 입력: "); avtmp.setAccNo(sc.nextLine());
        System.out.print("잔고입력 : "); avtmp.setBalance(sc.nextInt());
        sc.nextLine();
        av[cnt++] = avtmp;

    }
    private void print(){
        for (int i = 0; i < cnt; i++) {
            System.out.println(av[i].toString());
        }

    }
    private void deposit(){
        String acctmp;
        int balancetmp;
        System.out.print("입금할 게좌번호 입력 : "); acctmp = sc.nextLine();
        for (int i = 0; i < cnt; i++) {
            if(av[i].getAccNo().equals(acctmp)){
                System.out.print("입금금액 입력 : "); balancetmp = sc.nextInt();
                av[i].deposit(balancetmp);
            return;
            }
        }
        System.out.println("계좌가 없습니다.");
    }
    private void withdraw(){
        String acctmp;
        int balancetmp;
        System.out.print("출금 할 게좌번호 입력 : "); acctmp = sc.nextLine();
        for (int i = 0; i < cnt; i++) {
            if(av[i].getAccNo().equals(acctmp)){
                System.out.print("출금금액 입력 : "); balancetmp = sc.nextInt();
                av[i].withdraw(balancetmp);
            return;
            }
        }
        System.out.println("계좌가 없습니다.");
    }
    private void remit(){
        String acctmpgive;
        String acctmptake;
        int  givetmp = 0;
        int  taketmp = 0;
        int balancetmp = 0;
        boolean bu = false;
        System.out.print("송금할 계좌번호 입력 : "); acctmpgive =sc.nextLine();
        for (int i = 0; i < cnt; i++) {
            if (av[i].getAccNo().equals(acctmpgive)) {
                givetmp = i;
                bu = true; break;
            }
        }
        if(bu == false) {System.out.println("송금할 계좌가 없습니다."); return;}
        bu = false;
        System.out.print("송금 받을 계좌번호 입력 : "); acctmptake =sc.nextLine();
        for (int i = 0; i < cnt; i++) {
            if (av[i].getAccNo().equals(acctmptake)) {
                taketmp = i;
                bu = true; break;
            }
        }
        if(bu == false) {System.out.println("송금받을 계좌가 없습니다."); return;}

        System.out.print("송금금액 입력 : "); balancetmp = sc.nextInt();
        if(av[givetmp].getBalance()-balancetmp <0){
            System.out.println("송금할 돈이 없네요"); return;
        } else {
            av[givetmp].withdraw(balancetmp);
            av[taketmp].deposit(balancetmp);
        }
                
            
        

        

    }
    private void exit(){
        System.out.println("프로그램을 종룧합니다.");
        System.exit(0);
    }
}
