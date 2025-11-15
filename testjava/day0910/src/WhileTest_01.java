public class WhileTest_01 {
    public static void main(String[] args) {
        int i = 1;
        int total = 1;
        while(i <= 10){
            System.out.println((i) );
            total =total * i;
            ++i;
        }
        System.out.println(total);
    }
}
