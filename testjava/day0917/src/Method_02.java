public class Method_02 {
    public static void main(String[] args) {
        int[] ary = {10,20};

        System.out.println("[0] = " + ary[0] + ", [1] ="+ary[1]);
        System.out.println(ary);
        exchange(ary);
        System.out.println("[0] = " + ary[0] + ", [1] ="+ary[1]);
        System.out.println(ary);
    }
    public static void exchange(int[] ary){
            int temp = ary[0];
            ary[0] = ary[1];
            ary[1] = temp;
    }
}
