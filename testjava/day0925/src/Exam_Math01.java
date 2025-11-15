import java.time.LocalDate;

public class Exam_Math01 {
    public static void main(String[] args) {

    int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random()*50+50);
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < 10; i++) {
            min =Math.min(min,arr[i]);
            max =Math.max(max,arr[i]);
        }

        System.out.println("최댓값: " +max);
        System.out.println("최솟값: "+min);

    }
}
