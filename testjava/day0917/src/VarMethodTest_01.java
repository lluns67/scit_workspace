public class VarMethodTest_01 {
    public static void main(String[] args) {
        countCheck(); //같은 클래스 안에countCheck() 메소드가 static으로 존재
        countCheck("korea", "japan");
        countCheck("apple", "banana", "pear","melon");
    }


    private static void countCheck(String... data) {
        System.out.println("파라미터 개수 " + data.length);
    }

//    public static void printf(String data, Object) {
//
//    }
}
