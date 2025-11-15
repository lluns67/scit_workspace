package Exam_34.ui;

import Exam_34.Service.CosmeticService;
import Exam_34.Service.CosmeticServiceImpl;
import Exam_34.Vo.Foundation;
import Exam_34.Vo.Lipstick;
import Exam_34.Vo.Product;

import java.util.Scanner;

public class CosmeticUI {
    Scanner keyin = new Scanner(System.in);
    CosmeticService service = new CosmeticServiceImpl();
    public CosmeticUI(){
        String choice;
        while (true){
            mainMenu();
            choice = keyin.next();
            keyin.nextLine();
        }

    }
    public void mainMenu() {
        while (true) {
            System.out.println("===[ 화장품 관리 ]===");
            System.out.println(" 1. 상품 등록");
            System.out.println(" 2. 상품 수정");
            System.out.println(" 3. 상품 삭제");
            System.out.println(" 4. 상품 조회");
            System.out.println(" 5. 전체 상품 조회");
            System.out.println(" 0. 종 료");
            System.out.println("=============== ");
            System.out.print("  > 선택: ");

            switch (keyin.nextLine()){
                case "1": makeProduct(); break;
                case "2": updateProduct(); break;
                case "3": deleteProduct(); break;
                case "4": searchProduct(); break;
                case "5": productPrint(); break;
                case "0":
                System.out.print("## 프로그램을 종료합니다.");
                keyin.close();
                return;

                default:
                    System.out.println("## 메뉴를 잘못선택했습니다.");
            }
        }
    }
    public String subMenu(){
        String type;

        System.out.print("1. 립스틱 / 2. 파운데이션 : ");
        type = keyin.nextLine();

        if(!(type.equals("1") || type.equals("2"))){
            System.out.println("##다시 선택해 주세요");
        return null;
        }
        return type;
    }
    //상품 생성 후 등록
    public void makeProduct(){
        System.out.println("<<상품등록>>");

        Product product = null;
        String productNo;
        String type;
        type = subMenu();
        //공통 데이터 입력
        System.out.print("> 상품번호:"); productNo = keyin.nextLine(); //primary key(nn,unique)
        //상품 번호가 존재하는지 확인하는 작업이 필요함
        Product p = service.seletOne(productNo);
        if(p != null){
            System.out.println("## 이미 등록된 상품입니다.");
            return;
        }


        p = inputProduct();
        p.setProductNo(productNo);
        // 각 상품의 고유한 데잍터를 추가로 입력받는다.
        switch (type){
            case "1": p = makeLipstick(p); break;
            case "2": p = makeFoundation(p); break;
            default:
                System.out.println("다시 입력해 주세요");
                return;
        }
        boolean result = service.insert(p);
        if(result) System.out.println("## 상품이 등록되었습니다. \n");
        else System.out.println("등록 실패");

    }
    public Product inputProduct(){
        String name;
        int price;

        System.out.print("> 상품명: "); name = keyin.nextLine();
        System.out.print("> 상품가격: "); price = keyin.nextInt(); keyin.nextLine();
        return new Product(null,name,price);
    }
    public Lipstick makeLipstick(Product product){
        String type;
        String color;

        System.out.print(">  립스틱 타입: (1. 립밤 / 2. 립글로스 / 3. 틴트) ");
        type = keyin.nextLine();
        System.out.print("립스틱 색상: (1. 빨강 / 2. 분홍 / 3. 오렌지) : ");
        color =keyin.nextLine();

        return new Lipstick(product.getProductNo(), product.getName(),
                                           product.getPricce(), type,color);

    }
    public Foundation makeFoundation(Product product){
        String texture;


        System.out.print("파운데이션 제형: (1. 크림 / 2. 스틱) ");
        texture = keyin.nextLine();


        return new Foundation(product.getProductNo(), product.getName(),
                product.getPricce(), texture);



    }
    public void searchProduct(){
        System.out.println("<<상품 조회>>");
        System.out.print("> 상품번호: ");
        String productNo = keyin.nextLine();
        Product p = service.seletOne(productNo);
        if(p == null) System.out.println("##상품이 존재하지 않습니다.");
        else System.out.println(p);



    }
    public void updateProduct(){
        System.out.println("<<상품 정보 수정>>");
        System.out.print("> 수정할 상품의 번호 : ");
        String productNo = keyin.nextLine();
        Product p = service.update(productNo);
        if(p != null) {
            System.out.println(p);
            String name;
            int price;

            System.out.print("> 상품명: ");
            name = keyin.nextLine();
            System.out.print("> 상품가격: ");
            price = keyin.nextInt();
            keyin.nextLine();
            p.setName(name);
            p.setPricce(price);

            if (p instanceof Lipstick) {
                String type;
                String color;

                System.out.print(">  립스틱 타입: (1. 립밤 / 2. 립글로스 / 3. 틴트) ");
                type = keyin.nextLine();
                System.out.print("립스틱 색상: (1. 빨강 / 2. 분홍 / 3. 오렌지) : ");
                color = keyin.nextLine();
                ((Lipstick) p).setType(type);
                ((Lipstick) p).setColor(color);
                System.out.println(p);
            } else {
                String texture;
                System.out.print("파운데이션 제형: (1. 크림 / 2. 스틱) ");
                texture = keyin.nextLine();
                ((Foundation) p).setTexture(texture);
                System.out.println(p);
            }
        } else {
            System.out.println("## 상품이 존재하지 않습니다.");
        }




    }
    public void deleteProduct(){
        String yn;
        System.out.println("<<상품 삭제>>");
        System.out.print("> 상품번호: ");
        String productNo = keyin.nextLine();
        Product p = service.seletOne(productNo);
        if(p == null){ System.out.println("##상품이 존재하지 않습니다.");}
        else {
            System.out.println(p);
            System.out.print("상품을 삭제하시겠습니까? (y/n)");
            yn = keyin.nextLine();
            if(yn.equals("y")){
                p = null;
            } else{
                System.out.println("취소되었습니다.");
            }
        }



    }
    public void productPrint(){
        int count = service.getCount();
        Product [] list = service.seletAll();
        if(count == 0) {System.out.println("등록된 제품이 하나도 없습니다."); return;}
        //제품을 출력한다.
        for(int i = 0; i < count; i++) System.out.println(list[i]);
    }
}
