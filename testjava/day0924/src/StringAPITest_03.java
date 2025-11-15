import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class StringAPITest_03 {
    public static void main(String[] args) {
        String str = "abcd  efg hijk lmn";
        char ch =str.charAt(7);
        System.out.println(ch);

        int i = str.codePointAt(0);
        System.out.println(i);

        System.out.println("aKoreaaad2".compareTo("aKorea"));
        System.out.println("APPLe".compareToIgnoreCase("applekjkl"));

        String song = "Replaces the first substring of this string that matches the given regular expression with the given replacement";
        System.out.println(song.contains("match"));
        System.out.println(song.contains(new StringBuffer("meet")));
        /*
        indexOf
        lastIndexOf
        split()
        isBlank()
        isEmpty()
        length()
        matches()
         */
        System.out.println();
        System.out.println(song.lastIndexOf(ch)); //???

        System.out.println(Arrays.toString(song.split("s")));
        System.out.println(song.lastIndexOf("n")); //마지막 글자
        System.out.println(song.isBlank()); //글자유무
        String a = "";
        System.out.println(a.isEmpty()); //없을때
        System.out.println(song.length());
        System.out.println(song.matches(""));

        LocalDateTime n = LocalDateTime.now();
        DateTimeFormatter.ofPattern("yyyy-MM-dd)").format(n);
        System.out.println(n +"\n");
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(n));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(n));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(n));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss(E)").format(n));
        // 문자열을 날짜와 시간으로 파싱
        LocalDate newDate = LocalDate.parse("2025-08-19");
        LocalTime newTime = LocalTime.parse("12:31:30");
        LocalDateTime newDateTime = LocalDateTime.parse("2025-08-19T12:31:30");
        System.out.println(newDate);
        System.out.println(newTime);
        System.out.println(newDateTime);

            }
}
