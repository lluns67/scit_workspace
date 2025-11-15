package second;

public class Three extends Two {
    private int threeData;

    public Three() {
    }
    public int getThreeData(){return  threeData;}
    public void setThreeData(int threeData){this.threeData = threeData;}

    @Override
    public void output() {
        System.out.println("three==>" + threeData);
        super.output();
    }
}
