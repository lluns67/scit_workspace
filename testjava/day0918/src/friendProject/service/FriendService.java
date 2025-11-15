package friendProject.service;

import friendProject.vo.Friend;

import java.util.Scanner;

public class FriendService {
    private Friend friend;
    Scanner scanner = new Scanner(System.in);

    public FriendService() {
        String choie;

        while (true) {
            menu();
            choie = scanner.next();

            switch (choie) {
                case "1":
                    create();
                    break; //Freind 객체생성
                case "2":
                    retrieve();
                    break; //Friend 객체 출력
                case "3":
                    update();
                    break;  //Frienx 객체의 내용 수정
                case "4":
                    delete();
                    break; //참조를 끝는 작업
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);

                default:
                    System.out.println("err> 메뉴선택을 다시하세요.");
                    scanner.nextLine();
            }
        }
    }
    //메뉴
    public void menu(){
        System.out.println("-----[메인 메뉴]------");
        System.out.println("      1.입 력     ");
        System.out.println("      2.조 회     ");
        System.out.println("      3.수 정     ");
        System.out.println("      4.삭 제     ");
        System.out.println("      0.종 료     ");
        System.out.println("----------------------");
        System.out.print("     선택 >");
    }
    //입력
    public void create(){
        System.out.println("\n[[[[[[입 력]]]]]]");
        String name;
        int age;
        String type;

        if(friend != null){
            System.out.println("## 이미 등록된 친구가 있어서 새롭게 등록할 수 없습니다.");
            return;
        }

        System.out.print("** 이름: "); name = scanner.next();
        System.out.print("** 나이: "); age = scanner.nextInt();
        System.out.print("** 성격(외향적 : t, 내향적: f) "); type = scanner.next();

        //문자열은 boolean이 아니므로 변환하는 작업이 필요
        //casting : int -> double, double -> int 와 같이
        //숫자타입의 기초자료형만 casting가능
        //상속관계를 가진 캐스팅 가능

        //문자열을 boolean으로 바꾸는 방법
        //pasing 하거나 if을 사용하거나!
        /*boolean mytype = false;
        if(type.equals("t")) mytype = true;
        else mytype = false;

        mytype = (type.equals("t")) / true : false ;*/

        friend = new Friend(name, age, (type.equals("t")) ? true : false);
    }
    //조회
    public void retrieve(){
        System.out.println("\n[[[[[[조  회]]]]]]");
        if(friend == null){
            System.out.println("##등록된 친구 정보가 없습니다.");
            return;
        }
        friend.output();
        System.out.println();

    }
    //수정
    public void update(){
        System.out.println("\n[[[[[[수 정]]]]]]");

        int age;
        String type;

        if(friend == null){
            System.out.println("## 이미 등록된 없습니다.");
            return;
        }
        friend.output();

        System.out.print("** 나이:"); age = scanner.nextInt();
        System.out.print("** 성겨(외향적: t, 내성적: f): "); type = scanner.next();

        friend.setAge(age);
        friend.setType((type.equals("t")) ? true : false);
    }
    //삭제
    public void delete(){
        System.out.println("\n[[[[[[삭 제]]]]]]");
        String confirm;

        if(friend==null){
            System.out.println(" ## 등로된 치구 정보가 없습니다.");
            return;
        }

        friend.output();
        System.out.print("정말로 삭제할까요? (y/n");
        confirm = scanner.next();
        if(confirm.equals("Y") || confirm.equals("y")){
            friend = null;
            System.out.println("## 삭제가 완료되었습니다.");
            return;
        }
        System.out.println("## 취소되었습니다.");

    }
    }
