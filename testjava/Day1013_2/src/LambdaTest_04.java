import java.util.List;
import java.util.function.Consumer;

@FunctionalInterface
interface Myfunc{
    void access(String s);
}
@FunctionalInterface
interface YourFunc{
    Double method();
}
public class LambdaTest_04 {
    public static void main(String[] args) {
        test(a -> System.out.println(a)); //타입추정
        test3(a-> System.out.println(a+ " " + a));

        List<String> list = List.of("a","b","c");
        list.forEach((String a) -> System.out.println(a));
        test4(()->Math.random());

        test4(()-> Math.PI);

        String str = "동해물과 백두산이";
        String[] strings = str.transform((a) -> str.split(a));
        System.out.println(strings);

    }
    public static void test(Myfunc t){
        t.access("korea");
    }
    public static void test2(Myfunc t){
        t.access("corea");
    }
    public static void test3(Consumer<String> t){
        t.accept("Korea");

    }
    public static void test4(YourFunc y){
        System.out.println(y.method());
    }
}
