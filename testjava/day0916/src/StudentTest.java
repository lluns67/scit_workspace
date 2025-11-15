public class StudentTest {
    public static void main(String[] args) {
        Student boy1 = new Student();

        boy1.no = 1;
        boy1.name = "홍길동";
        boy1.it= 89;
        boy1.japan = 99;
        boy1.common = 100;
        System.out.printf("학번 %d, %s, it :%d, jan: %d, common : %d",
                boy1.no, boy1.name,boy1.it, boy1.japan, boy1.common);

        for(int i = 1; i<10; i++)
        {
            System.out.println(i);
        }


        Student boy2 = new Student();
        boy2.no = 2;
        boy2.name = "홍길동";
        boy2.it= 75;
        boy2.japan = 85;
        boy2.common = 78;
        boy2.add(10,10);
    }
}
