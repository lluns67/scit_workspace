package first;

public class Child extends Parent {
    private int property;

    public Child() {

    }

    public int getPropety() {
        return property;
    }
    public void setProperty(int property){
        this.property = property;
    }
    @Override
    public void output() {
        System.out.println("자식의 데이터: " + property);
    }
}