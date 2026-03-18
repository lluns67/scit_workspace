import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class exam5 {
	public static void main(String[] args) {
		System.out.print("입력: ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.nextLine();
		String find = scanner.nextLine();
		
		
		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			arrayList.add(scanner.nextLine());
		}
		
		boolean found = false;
		for (String string: arrayList){
			if (string.contains(find)){
				System.out.println(string);
				found = true;
			}
		}
		if (!found){
			System.out.println("None");
		}
	}
}
