import java.util.ArrayList;
import java.util.Scanner;

public class exam15 {
	public static void main(String[] args) {
		System.out.print("입력: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if ( n <=2){
			System.out.printf("피보나치 수열의 %d번째 항 = 1", n);
		} else {
			ArrayList<Integer> arrayList = new ArrayList<>();
			arrayList.add(1);
			arrayList.add(1);
			int tmp =0;
			for (int i = 2; i < n; i++) {
				tmp = arrayList.get(i-2) + arrayList.get(i-1);
				arrayList.add(tmp);
			}
			System.out.printf("피보나치 수열의 %d번째 항 = %d", n, arrayList.get(n-1));
		}
	}
}
