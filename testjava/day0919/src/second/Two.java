package second;

public class Two extends One{
    private int twoData;

    public Two(){}

    public Two(int twoData) {
        this.twoData = twoData;
    }

    public Two(int oneData, int twoData) {
        super(oneData);
        this.twoData = twoData;
    }
    public void setTwoData(int twoData){this.twoData = twoData;}

    @Override
    public void output() {
        super.output();
    }
}
