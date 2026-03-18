import java.util.Scanner;

public class exam11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.printf("%d %s%s\n", i,i%3==0 ? "Fizz": "", i%5==0 ? "Buzz":"");
		}
	}
}
