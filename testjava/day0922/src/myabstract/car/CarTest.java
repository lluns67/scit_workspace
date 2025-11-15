package myabstract.car;

public class CarTest {
    public static void main(String[] args) {
        Car car = null;
        car = new Car();
        car.setModelname("그랜저");
        car.setPrice(40000000);
        car.setDisplacement(3500);

        output(car);

        car.setModelname("K5");
        car.setPrice(30000000);
        car.setDisplacement(2000);
        output(car);
        car.setModelname("모닝");
        car.setPrice(15000000);
        car.setDisplacement(1000);
        output(car);
    }
    public static void output(Car car){
        System.out.printf("모델명 : %10s\t 가격: %,d\t 배기량 : %,d \t세금 : %,d\n",
                car.getModelname(), car.getPrice(), car.getDisplacement(), car.tax());

    }
}
