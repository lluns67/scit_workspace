package Exam_32.vo;

public class Accountvo {
    private String name;  //이름
    private String accNo; //계좌번호
    private int balance; //잔고

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void deposit(int tmp){
        balance += tmp;
    }

    public void withdraw(int tmp){

        if (balance- tmp < 0){
            System.out.println("뺄 돈이 없어요");
        } else balance-= tmp;
    }

    @Override
    public String toString() {
        return "성명 : " +name+ " 계좌번호 : " +accNo + " 잔고 : " + balance;
    }
}
