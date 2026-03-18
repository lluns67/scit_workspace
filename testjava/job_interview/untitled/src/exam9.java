import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exam9 {
	public static void main(String[] args) {
		System.out.print("입력");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String[] s = string.split(" ");
		int i = Integer.parseInt(s[0]);
		int base = Integer.parseInt(s[1]);
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for (int j = 0; j < i; j++) {
			String string1 = scanner.nextLine();
			String[] s1 = string1.split(" ");
			int i1 = Integer.parseInt(s1[0]);
			int i2 = Integer.parseInt(s1[1]);
			
			
			if(base<=i1-i2*5) {
				arrayList.add(j + 1);
			}
		}
		for (int i1 : arrayList){
			System.out.println(i1);
		}
	}
}
