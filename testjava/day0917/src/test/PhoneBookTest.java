//키보드로 5개의 정보를 입력받아 phonebook 클래스로 생성하시오.
package test;

import vo.PhoneBook;

import java.util.Scanner;

public class PhoneBookTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name, phone, relation, address, memo; //임시 지역변수

        System.out.print("이름: "); name = scanner.next();
        System.out.print("전화번호: "); phone = scanner.next();
        System.out.print("관계: "); relation = scanner.next();
        System.out.print("주소: "); address = scanner.next();
        System.out.print("메모: "); memo = scanner.next();

        PhoneBook pb = new PhoneBook();
        pb.setName(name);
        pb.setRelation(relation);
        pb.setPhone(phone);
        pb.setAddress(address);
        pb.setMemo(memo);

        pb.output();
        PhoneBook pb2 = new PhoneBook(name, phone);
        pb.output();
        PhoneBook pb3 = new PhoneBook(name,phone,relation,address,memo);
        pb.output();

    }
    //출력 메소드

}
/*private String name;
    private String phone;
    private String relation;
    private String address;
    private String memo;
* */