package fitness;
//어느 피트니스 클럽에서 회원의 거낭상태를 관리하기 위해 생성한 vo
public class Fitness {
    //아이디, 이름 성별, 키, 몸무게, 표준체중, bmi, bmi 결과
    private String id;
    private String name;
    private Boolean gender; // true 남성, false 여성
    private double height;
    private double weight;
    private double stdweight;
    private double bmi;
    private String bmiResult;

    public Fitness() {
    }

    public Fitness(String id, String name, Boolean gender, double height, double weight) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;

        calcStdweight();
        calcBMI();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        calcStdweight();
        calcBMI();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    //계산하지 않는 일반메소드
    //남표준체중 = 키*키*22 여표준체중 = 키*키*21
    private void  calcStdweight(){
        double temp =height/100;
        stdweight = gender ? temp*temp* 22 : temp*temp*21;
    }
    // BMI 구하ㅣ = 몸구게(kg) / 키(m)의 제공
    private void calcBMI(){
        double temp = height / 100;
        bmi = weight / (temp*temp);
        calcBMIResult();
    }

    private void calcBMIResult(){
        if(bmi < 18.5) bmiResult = "저체중";
        else if(bmi < 23) bmiResult = "정상 체중";
        else if(bmi < 25) bmiResult = "과체중";
        else if(bmi < 30) bmiResult = "경도비만";
        else if(bmi < 35) bmiResult = "중도비만";
        else  bmiResult = "고도비만";
    }
    @Override
    public String toString(){
        String tmp = String.format("%s, %s, %s, %6.2fcm, %6.2fkg / 표준체중 %6.2fkg, BMI: %.1f, 결과: %s",
                id, name, (gender ? "남성" : "여성"),
                height, weight, stdweight, bmi, bmiResult);
        return tmp;
    }
}