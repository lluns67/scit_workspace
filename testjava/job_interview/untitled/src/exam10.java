import java.util.Scanner;

public class exam10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[][] strings1 = { { "#", "#", "#" }, { " ", "#", " " }, { " ", "#", " " } };
		String[][] strings2 = { { " ", " ", "#" }, { "#", "#", "#" }, { " ", " ", "#" } };
		String[][] strings3 = { { " ", "#", " " }, { " ", "#", " " }, { "#", "#", "#" } };
		String[][] strings4 = { { "#", " ", " " }, { "#", "#", "#" }, { "#", " ", " " } };
		String[][][] strings = { strings1, strings2, strings3, strings4 };
		
		int i = 0;
		
		while (true) {
			// 현재 상태 출력
			for (String[] row : strings[i]) {
				for (String col : row) {
					System.out.print(col);
				}
				System.out.println();
			}
			
			// 사용자 입력
			System.out.print("입력: ");
			String s = scanner.nextLine();
			
			if (s.equals("exit")) {
				System.out.println("프로그램 종료");
				break;
			}
			
			// 다음 회전 상태로 이동
			i = (i + 1) % 4;
		}
		
		scanner.close();
	}
}