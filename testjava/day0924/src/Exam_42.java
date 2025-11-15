import java.time.LocalDate;
import java.util.Scanner;



public class Exam_42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        String str = sc.nextLine();

        if(!isValid(str)) {System.out.println("잘못된 주민번호입니다."); return;}
        if(!isNumeric(str)) {System.out.println("잘못된 주민번호입니다."); return;}
        if(!codeCheck(str)) {System.out.println("잘못된 주민번호입니다."); return;}
        if(!option(str)) {System.out.println("잘못된 주민번호입니다."); return;}
        print(str);

    }
    private static boolean codeCheck(String id){
        StringBuffer buf = new StringBuffer(id);
        buf.delete(6,7);
        int sum = 0;
        int tmp ;
        for (int i = 0; i < buf.length()-1; i++) {
            sum += (Integer.parseInt(String.valueOf(buf.charAt(i)))) * ((i % 8) + 2);}

        tmp = (11-(sum%11))%10;
        int lastnumber = Integer.parseInt(String.valueOf(buf.charAt(buf.length()-1)));

        if(lastnumber == tmp){
            return true;
        }else return false;
    }
    private static String birthyear(String id){
        if (id.charAt(7) == '1' || id.charAt(7) == '2'){
            return "19";
        } else if (id.charAt(7) == '3' || id.charAt(7) == '4'){
            return "20";
        } else return null;
    }
    private static String genderCheck(String id){
        if (id.charAt(7) == '1' || id.charAt(7) == '3'){
            return "남자";
        } else if (id.charAt(7) == '2' || id.charAt(7) == '4') {
            return "여자";
        } else return null;
    }
    private static boolean isValid(String id){
        if(id.matches(".{6}-[1-4].{6}")) return true;
        else return false;
    }
    public static boolean isNumeric(String id){
        String[] tmp = id.split("-");

           if(tmp[0].matches("[0-9]{6}") && tmp[1].matches("[0-9]{7}")){
               return true;
           } else return false;
    }

    public static void print(String id){
        String[] list = id.split("");
        System.out.printf("출력 : 당신은 %s%s%s년 %s%s월 %s%s일생 %s입니다.",
                birthyear(id),list[0],list[1],list[2],list[3],list[4],
                list[5], genderCheck(id));
    }

    //추가 기능
    public static boolean option(String id){
        String year = birthyear(id) + (String.valueOf( id.charAt(0))) + (String.valueOf( id.charAt(1)));
        String month = (String.valueOf( id.charAt(2))) + (String.valueOf( id.charAt(3)));
        String day = (String.valueOf( id.charAt(4))) + (String.valueOf( id.charAt(5)));

        if(month.equals("02") && day.equals("29")){   // 윤년 확인
            String leap = year+"-01-01";
            LocalDate date = LocalDate.parse(leap);
            if(!date.isLeapYear()) return false;
        }


        String sum = year+"-"+month+"-"+day;
        LocalDate birthday = LocalDate.parse(sum);
        LocalDate today = LocalDate.now();            // 태어난 날이 오늘보다 뒷날인지 확인
        if(birthday.isAfter(today)){
            return false;
        }

        return true;
    }

}
