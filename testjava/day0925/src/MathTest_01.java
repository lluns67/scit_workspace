public class MathTest_01 {
    public static void main(String[] args) {
        double rand;
        for (int i = 0; i < 10; i++) {
            rand = Math.random()*100;
            System.out.println((int)rand+","+rand);
        }
    }
}
