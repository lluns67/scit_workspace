import java.time.LocalDate;

public class SCBankTest {
    public static void main(String[] args) {
        SCBank b1 =new SCBank();
        b1.customerName = "전우치";
        b1.accountNo = "1234";
        b1.balnace = 100000;
        b1.password = "1234";
        b1.createDate = LocalDate.now();
        print(b1);

        SCBank b2 =new SCBank();
        b2.customerName = "손오공";
        b2.accountNo = "5678";
        b2.balnace = 5100000;
        b2.password = "3456";
        b2.createDate = LocalDate.of(2005, 9,2);
        print(b2);
    }

    public static void print(SCBank b){
        System.out.printf("고객명: %s, 계좌번호: %s, 잔액:%,d원, 비밀번호: %s, 개설일: %s\n",
                b.customerName, b.accountNo, b.balnace, b.password, b.createDate);
    }
}
