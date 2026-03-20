import java.util.ArrayList;
import java.util.Arrays;

public class exam18 {
	public static void main(String[] args) {
		ArrayList<Integer> integers = new ArrayList<>(Arrays.asList( 9, 1, 6, 8, 4, 3, 2, 0 ));
		for (int i = 0; i < integers.size()-1; i++) {
			int min = integers.get(i);
			int key = i;
			for (int j = i; j < integers.size(); j++) {
				if(integers.get(j)< min){
					min = integers.get(j);
					key = j;
				}
			}
			if(key != i){
				int tmp = integers.get(i);
				integers.set(i, min);
				integers.set(key, tmp);
			}
		}
		System.out.println(integers);
	}
}