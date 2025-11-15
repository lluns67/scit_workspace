package myabstract.car;

public abstract class Vehicle {
    private String modelname;
    private int price;

    public Vehicle(int price, String modelname) {
        this.price = price;
        this.modelname = modelname;
    }

    public Vehicle() {
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public abstract int tax();
}