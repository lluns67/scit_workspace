package abstractPack;
class Myclass{
    String name = "이름 없음";
}
abstract class MyAbstract{
    int age = 10;
    public MyAbstract(){}
    public void output(){
        System.out.println("나이는 " + age);
    }
    //abstract 키워드 and 메소드 시그니처만 있는 메소드
    public abstract void add(int a, int b);
}
class ChildAbstract extends MyAbstract{

    @Override
    public void add(int a, int b) {
        System.out.println("구현한 메소드의 결과 " + (a+b));
        ChildAbstract c = new ChildAbstract();
    }
}
public class Temp {
    public static void main(String[] args) {
        Myclass a = new Myclass();
        System.out.println(a.name);


    }
}
