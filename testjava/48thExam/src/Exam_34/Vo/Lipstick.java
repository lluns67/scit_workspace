package Exam_34.Vo;


public class Lipstick extends Product {
    private String type;
    private String color;

    public Lipstick() {
    }

    public Lipstick(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public Lipstick(String productNo, String name, int pricce, String type, String color) {
        super(productNo, name, pricce);
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //자신의 멤버변수를 문자열로 연결하여 반환하는 메소드
    //오버라이딩을 하지 않으면 Object로부터 상속받은 raw 형태의문자열인 hash코드가 반환됨
    @Override
    public String toString() {
        String type = (this.type.equals("1") ? "립밤" :
                this.type.equals("2") ? "립글로스" : "틴트" );
        String color = (this.color.equals("1") ? "빨강" :
                        this.type.equals("2") ? "분홍" : "오렌지");
        String tmp = super.toString() + String.format("타입 = %s, 색상=%s ",
                type,color);
        return tmp;
    }
}
