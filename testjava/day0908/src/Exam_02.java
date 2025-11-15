// 1년은 365.2422일이다.

public class Exam_02 {
    public static void main(String[] args) {
        double oneYear = 365.2422;
        int day, hour, minute;
        double second, temp;

        day = (int) oneYear;
        temp = oneYear -day;

        System.out.println(oneYear + "일은" +day + "일" +
                (hour = (int)(temp = temp*24)) + "시간"
                + (minute = (int)(temp =((temp-hour)*60)))+ "분"
                + (second = (temp-minute)*60));
        System.out.printf("%f일은 %d일은 %d시간 %d 분 %.2f초입니다.",oneYear,day,hour, minute, second );
    }
}