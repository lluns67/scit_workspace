import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      String id = "210228-3123445";

        String year = "20" + (String.valueOf( id.charAt(0))) + (String.valueOf( id.charAt(1)));
        String month = (String.valueOf( id.charAt(2))) + (String.valueOf( id.charAt(3)));
        String day = (String.valueOf( id.charAt(4))) + (String.valueOf( id.charAt(5)));
        String sum = year+"-"+month+"-"+day;

        System.out.println(sum);
        LocalDate date2 = LocalDate.parse(sum);
        System.out.println(date2);
        LocalDate data3 = LocalDate.parse("2001-02-28");
//        System.out.println(date2.isLeapYear());
    }
}
