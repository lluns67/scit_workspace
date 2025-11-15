public class Exam_24 {
    public static void main(String[] args) {
        int exp[] = new int[5];
        int i,j,k,tmp,tt;
        i=0;
        while (i < 5) {
            exp[i] = ++i;
        }
        int result[][] = new int[4][5];
        i=0;
        while (i <4){

            j=0;
            while(j <5){
                k=1; tmp = i+2; tt=tmp;
                while (k < exp[j]){
                    tmp *= tt;
                    k++;
                }
                result[i][j] = tmp;
            j++;}
        i++;}

        i=0;
        while (i < 5){
            System.out.printf("%10d", exp[i]);
            i++;
        }
        System.out.println();
        i =0;
        while(i < 4){
            j=0;
            while(j <5){
                System.out.printf("%10d", result[i][j]);
                j++;
            }
            System.out.println();
            i++;
        }
    }
}