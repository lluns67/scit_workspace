package Exam_33.vo;

public class Client {

    private String csn;
    private String name;
    private double weight;
    private double height;

    public Client(String csn, String name, double weight, double height) {
        this.csn = csn;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public String getCsn() {
        return csn;
    }

    @Override
    public String toString() {
        return "이름 : " + name+ " 회원번호 " +
        csn + " 키 " + height+" 몸무게 " + weight;
    }
}
