package Exam_34.Vo;

public class Product {
    private String productNo;
    private String name;
    private int pricce;

    public Product() {
    }

    public Product(String productNo, String name, int pricce) {
        this.productNo = productNo;
        this.name = name;
        this.pricce = pricce;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricce() {
        return pricce;
    }

    public void setPricce(int pricce) {
        this.pricce = pricce;
    }

    @Override
    public String toString() {
        String tmp = String.format("상품 번호 = %s, 상품명=%s, 가격=%,d원, ",
                                    productNo,name,pricce);
        return tmp;
    }
}
