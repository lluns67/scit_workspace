import java.util.Scanner;

public class exam12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(factorial(n));
	}
	static int factorial(int i){
		if(i == 1){
			return i;
		} else {
			return i * factorial(i-1);
		}
	}
}
