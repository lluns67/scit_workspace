import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class exam8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<>();
		System.out.print("입력: ");
		
		
		while (true){
			String s = scanner.nextLine();
			if(s.equals("exit")){
				break;
			} else {
				s=s.trim();
				String[] strings = s.split(":");
				String key = strings[0];
				int value = Integer.parseInt(strings[1]);
				map.put(key, map.getOrDefault(key, 0) + value);
			}
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey() + " = " + entry.getValue() );
		}
	}
}
