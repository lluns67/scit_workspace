public class StringBufferAPITest_01 {
    public static void main(String[] args) {
        String song = "나리 나리 개나리 입에 따다 물고요!!";
        StringBuffer buffer = new StringBuffer(song);

        System.out.println("song의 길이: "+song.length());
        System.out.println("buff의 길이: "+buffer.length());
        System.out.println("buff의 용량: "+buffer.capacity());

        buffer.append(" 병아리때 뿅뿅뿅").append(" 봄나들이");
        System.out.println(buffer);

        //새로운 객체를 계속 만드는 작업이므로 성능이 나빠짐
        String song2 = song.concat("벙아리때뿅뿅").concat("봄나들이").concat("갑니다");
        System.out.println(song2);

        buffer.insert(3,"장비");
        System.out.println(buffer);
        buffer.delete(buffer.indexOf("개나리"),buffer.indexOf("개나리")+3);
        System.out.println(buffer);
        buffer.replace(buffer.indexOf("병아리"),buffer.indexOf("병아리")+"병아리".length(),"강아지");
        System.out.println(buffer);
    }
}
