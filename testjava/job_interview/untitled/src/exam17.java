import java.util.ArrayList;
import java.util.Arrays;

public class exam17 {
	public static void main(String[] args) {
		ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(31, 25, 12, 22, 11 ));
		
		for (int i = 1; i < integers.size(); i++) {
			int key = integers.get(i);
			int j = i-1;
			
			while (j >=0 && integers.get(j) > key){
				integers.set(j+1, integers.get(j));
				j--;
			}
			integers.set(j+1, key);
		}
		System.out.println(integers);
	}
}