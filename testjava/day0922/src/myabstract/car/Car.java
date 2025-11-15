package myabstract.car;

public class Car extends Vehicle{
    private int displacement; //배기량
    private int taxMoney; //계산된 세금

    public Car() {
    }



    public Car(int displacement, int taxMoney) {
        this.displacement = displacement;
        this.taxMoney = taxMoney;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getTaxMoney() {
        return taxMoney;
    }

    public void setTaxMoney(int taxMoney) {
        this.taxMoney = taxMoney;
    }
    @Override
    //상속받은 추상 메소드를 구현
    public int tax() {


        if(displacement < 1500) taxMoney = (int)(getPrice() * 0.01);
        else if(displacement <3000) taxMoney = (int)(getPrice() * 0.03);
        else taxMoney = (int)(getPrice() * 0.05);
        return taxMoney;
    }
}
