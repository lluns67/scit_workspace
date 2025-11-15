import java.time.LocalDate;

public class BankAccount {
    //멤버변수(필드, 인스턴스변수)
    private String customerName;
    private String accountNo;
    private int balance;
    private LocalDate creatDate;

    //멤버 메소드
    //우리멤버변수의 접근해서 값을 넣는 메소드 ==> setter
    //우리멤버 하나에접근해서 값을 넣는 역할담당
    // public void setCustomerName()
    // public void setAccountNo()
    //우리멤버변수의 접근해서 값을 외부로 전달하는 메소드 ==> getter

/////setter
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public void setAccountNo(String accountNo){
        this.accountNo = accountNo;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public void setCreatDate(LocalDate creatDate){
        this.creatDate = creatDate;
    }
/// //getter
    public String getCustomerName() {
        return customerName;
    }
    public String getAccountNo(){
        return accountNo;
    }
    public int getBalance(){
        return balance;
    }

    public LocalDate getCreatDate() {
        return creatDate;
    }
}
