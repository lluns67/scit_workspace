
import java.util.Scanner;

public class exam2 {
	public static void main(String[] args) {
		System.out.print("입력 : ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		String[] strings = string.split(" ");
		
		for (int i = 0; i < strings.length; i++) {
			strings[i] = String.valueOf(strings[i].charAt(0));
		}
		
		System.out.print("출력 : ");
		System.out.println(String.join(",", strings));
	}
}
