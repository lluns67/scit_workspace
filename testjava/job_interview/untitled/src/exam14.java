import java.util.ArrayList;
import java.util.Scanner;

public class exam14 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력: ");
		int n = scanner.nextInt();
		
		int i = 0;
		int tmp = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(1);
		while (true){
			tmp = arrayList.get(i) + arrayList.get(i+1);
			if(tmp > n){
				break;
			}
			arrayList.add(tmp);
			i++;
			
		}
		System.out.println(arrayList.toString().replaceAll("[\\[\\]]", ""));
		
	}
}