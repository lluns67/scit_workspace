package first;

public class Inheritest {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.setMoney(50);
        p.output();

        Child c = new Child();
        c.setProperty(1500);
        c.output();

        c.setMoney(100);


        c.output();
    }
}
