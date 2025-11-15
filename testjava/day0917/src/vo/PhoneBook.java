package vo;

public class PhoneBook {
    private String name; //이름, 전화번호, 관계, 메모, address
    private String phone;
    private String relation;
    private String address;
    private String memo;

    public PhoneBook(){}
    public PhoneBook(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public PhoneBook(String name, String phone, String relation, String address, String memo) {
        this.name = name;
        this.phone = phone;
        this.relation = relation;
        this.address = address;
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public void output(){
        System.out.printf("이름: %s, 전화번호: %s, 관계: %s, 주소: %s, 메모: %s\n",
                name, phone, relation, address, memo);
    }
}
