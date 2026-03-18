import java.util.Scanner;

public class exam13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(!(n==0)){
			int ans = 1;
			for (int i = 0; i < n; i++) {
				ans *= i+1;
			}
			System.out.println(ans);
		}
		else {
			System.out.println("1이상의 자연수 입력 부탁");
		}
	}
}
