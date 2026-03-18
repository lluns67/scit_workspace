import java.util.Scanner;

public class exam3 {
	public static void main(String[] args) {
		System.out.print("입력: ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		System.out.print("출력: ");
		
		char[] chars = string.toCharArray();
		
		// 뒤에서부터 하나씩 '#'으로 변환
		for (int i = chars.length - 1; i >= 0; i--) {
			chars[i] = '#';
			System.out.println(new String(chars));
		}
		
	}
}
