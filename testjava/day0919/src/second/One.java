package second;

public class One {
    private int oneData;
    public One(){}

    public One(int oneData) {
        this.oneData = oneData;
    }

    public int getOneData() {
        return oneData;
    }

    public void setOneData(int oneData) {
        this.oneData = oneData;
    }
    public void output(){
        System.out.println("One==>" + oneData);
    }

}
