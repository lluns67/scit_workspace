public class ArrayTest_02 {
    public static void main(String[] args) {
        int[] iary = new int[] { 1,2,3,4,5,6,7,8,9,0, 6};
        System.out.println("iary는 방이몇 개?" + iary.length);
        System.out.println("iary는 방이몇 개?" + (iary.length -1));
        for (int i = 0; i < iary.length; i++) {
            System.out.println(iary[i]);
        }
    }
}
