public class DoubleLoop_02 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            System.out.print("i=" + i + ", j=");
            for (int j = 0; j < 5; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
//        int i=0,j=0;
//        while(i <10){
//            j=0;
//            System.out.print("i=" + i + ", j=");
//            while(j < 5){
//                System.out.print(j + " ");
//                ++j;
//            }
//            ++i;
//            System.out.println();
//        }
    }
}
