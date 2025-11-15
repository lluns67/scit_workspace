package Exam_34.Vo;

public class Foundation extends Product{
    private String texture;

    public Foundation() {
    }

    public Foundation(String texture) {
        this.texture = texture;
    }

    public Foundation(String productNo, String name, int pricce, String texture) {
        super(productNo, name, pricce);
        this.texture = texture;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
    @Override
    public String toString() {
        String texture = this.texture.equals("1") ? "크림" : "스틱";
        return super.toString() + String.format("제형 = %s ",
                texture);
    }
}
