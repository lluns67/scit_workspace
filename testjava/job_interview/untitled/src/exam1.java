import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class exam1 {
	public static void main(String[] args) {
		System.out.print("입력 : ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		Map<Character, Integer> countMap = new LinkedHashMap<>();
		
		for (char c : string.toCharArray()) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		
		
		System.out.print("출력 : ");
		// 모든 문자와 등장 횟수 출력
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			System.out.print(entry.getKey() + entry.getValue().toString());
		}
		
	}
}
