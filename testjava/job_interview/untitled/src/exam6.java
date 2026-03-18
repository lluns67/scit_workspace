import java.util.Scanner;

public class exam6 {
	public static void main(String[] args) {
//		규칙) A => 4
//		E => 3
//		G => 6
//		I => 1
//		O => 0
//		S => 5
//		Z => 2
		
		System.out.print("입력: ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String a = s.replaceAll("A", "4");
		a = a.replaceAll("E", "3");
		a = a.replaceAll("G","6");
		a = a.replaceAll("I", "1");
		a = a.replaceAll("O","0");
		a = a.replaceAll("S", "5");
		a = a.replaceAll("Z", "2");
		
		System.out.printf("출력: %s", a);
	}
}
