public class Exam_27 {
    public static void main(String[] args) {
        for (int i = 'A'; i <= 'z'; i++) {
            if(i > 90 && i <97) continue;
            System.out.printf("%c : %d\n", (char)i, i);
        }
    }
}
