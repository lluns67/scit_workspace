import java.time.*;

public class LocalDate_Test {
    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now(Clock.systemDefaultZone());
        LocalDateTime time3 = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        LocalDateTime time4 = LocalDateTime.of(2019,1,15,0,0,0);
        LocalDateTime time5 = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        LocalDateTime independent = LocalDateTime.parse("1945-08-15T15:36:00.000");
        System.out.println("광복절  잉왕 방송: " + independent);

        LocalDateTime xmas = LocalDateTime.of(2024,12,25,0,0,0);
        System.out.println("2024년 Christmas: " + xmas);

        LocalDateTime vote = Year.of(2025).atMonth(6).atDay(3).atTime(9,00);
        System.out.println("대통령 선거일: " + vote);

        LocalDateTime time7 = LocalDate.now().atTime(10,30);
        LocalDateTime time6 = Year.of(2024).atMonth(1).atDay(15).atTime(10,30);

        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println(time4);
        System.out.println(time5);
        System.out.println(time6);
        System.out.println(time7);

    }
}
