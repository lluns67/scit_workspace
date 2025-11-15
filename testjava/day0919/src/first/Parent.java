package first;

public class Parent {
    private int money;

    public Parent(){}

    public int getMoney(){return money;}
    public void setMoney(int money){ this.money = money;}
    void output(){
        System.out.println("부모의 데이터 " + money);
    }
}
