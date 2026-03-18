import java.util.Arrays;

public class exam16 {
	public static void main(String[] args) {
		int[] ints = { 5, 3, 7, 2, 11 };
		int tmp = 0;
		for (int i = 0; i < ints.length-1; i++) {
			for (int j = 0; j < ints.length-1-i; j++) {
				if(ints[j] < ints[j+1]){
					tmp = ints[j];
					ints[j] = ints[j+1];
					ints[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(ints));
	}
}
