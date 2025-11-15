import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateAPITest_01 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        System.out.println(ld.getDayOfWeek());
        System.out.println(ld.getDayOfYear());

        Calendar calendar = new GregorianCalendar();
        Calendar cal = Calendar.getInstance();

        System.out.println(calendar);
        System.out.println(cal);



    }
}
