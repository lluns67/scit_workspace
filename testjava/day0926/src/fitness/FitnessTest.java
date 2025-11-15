package fitness;

import java.util.ArrayList;
import java.util.List;

public class FitnessTest {
    public static void main(String[] args) {
        // 1명의 뎅터를 입력하고 출력
        Fitness mem1 = new Fitness("1","김홍련",false,165.7,57.66);
        System.out.println(mem1);
        Fitness mem2 = new Fitness("2","손오공",true,165.7,57.66);

        List<Fitness> list = new ArrayList<>();
        list.add(mem1);
        list.add(mem2);
        list.add(new Fitness("3", "김경화", false, 155, 50));
        System.out.println(list);
    }
}
