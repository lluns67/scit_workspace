import java.lang.reflect.Array;
import java.util.Arrays;

public class exam1 {
	public static void main(String[] args) {
		int[] ints = { 5, 10, 23, 50, 34, 100, 23, 2, 3, 20};
		int min = ints[0];
		int max = ints[0];
		for (int i = 1; i < ints.length; i++) {
			min = ints[i] < min ? ints[i]:min;
			max = ints[i] > max ? ints[i]:max;
		}
		System.out.println(Arrays.toString(ints));
		System.out.println(max);
		System.out.println(min);
	}
}
