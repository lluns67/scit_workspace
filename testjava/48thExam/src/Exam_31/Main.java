package Exam_31;

import java.util.Scanner;

public class Main {
    private static String name;
    private static String race;
    private static String age;
    static Scanner sc;
//    private static Vo vo;
    private static Vo[] vol = new Vo[100];
    private static int cnt =0;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        String choice;
        while (true){
            System.out.println("====================");
            System.out.println("1.애완동물등록");
            System.out.println("2.전체출력");
            System.out.println("3.프로그램 종료");
            System.out.println("====================");
            System.out.print("선택 : ");
            choice = sc.next();
            sc.nextLine();
            switch (choice){
                case "1": {regist(); break;}
                case "2": print(); break;
                case "3": System.exit(0);

            }
        }
    }
        private static void regist(){

            System.out.print("이름을 입력해 주세요"); name = sc.nextLine();
            System.out.print("종류를 입려해 주세요"); race = sc.nextLine();
            System.out.print("나이를 입력 해주세요"); age = sc.nextLine();

            vol[cnt++] = new Vo(name, race, age);


        }
        private static void print(){
            for (int i = 0; i < cnt; i++) {
                vol[i].print();
            }

        }

}
