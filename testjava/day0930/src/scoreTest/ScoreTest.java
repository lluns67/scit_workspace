package scoreTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreTest {
    public static void main(String[] args) {
        List<Score> list = Arrays.asList(
                new Score("23","홍길동",89,45),
                new Score("24","김춘향",24,56),
                new Score("25","이몽룡",44,49),
                new Score("26","용기사",32,67),
                new Score("99","손오공",999,999)
        );

        //학번 순으로 전체 출력
        print(list);
    }
    private static void print(List<Score> list){
        list.sort((x,y)->x.compareTo(y));

        for (int i = 0; i < list.size(); i++) {
            try {
                Score score = list.get(i);
                System.out.print(list.get(i));

                if(score.getAvg() < 60 ) throw new ScoreException("재시험 대상자");
                System.out.println();
            } catch (ScoreException e){
                System.out.println(" " + e.getMessage());
            }
        }
    }
}
