public class ExceptionTest_02 {
    public static void main(String[] args) {
            int total = 0;
            String[] str = {"15a", "123", "0", "12", "2",  "5"};


            for(int i = 0; i < str.length; ++i){
        try{
                total += Integer.parseInt(str[i]);

        } catch (NumberFormatException e){
            System.out.println(i + "에러 발생함");

        }
        }
        System.out.println("최종 합계: " + total);
    }
}