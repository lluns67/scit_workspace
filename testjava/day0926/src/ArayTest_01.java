import java.time.LocalDate;
import java.util.ArrayList;

public class ArayTest_01 {
    public static void main(String[] args) {
        String[] ary = new String[10];
        ArrayList<String> list = new ArrayList<>();

        ary[0] = "후식";
        list.add("한가위");
        list.add("추석");

        String s1 = ary[0];
        String s2 = list.get(0);

        System.out.println(ary.length);
        System.out.println(list.size());

        System.out.println(ary);
        System.out.println(list);
    }
}
