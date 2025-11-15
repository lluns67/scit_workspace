package Exam_34.Service;

import Exam_34.Vo.Product;

public class CosmeticServiceImpl implements CosmeticService{
    Product[]  list= new Product[50];
    int count = 0;

    @Override
    public boolean insert(Product product) {
        if (count >= list.length) return false;
        else list[count++] = product; return true;
    }

    @Override
    public Product update(String productno) {
        Product p=seletOne(productno);
        if(p == null) return null;
        else return p;
    }

    @Override
    public boolean delete(String name) {

        return name.equals("y");

    }

    @Override
    public Product seletOne(String productno) {
        for (int i = 0; i < count; i++) {
            if(list[i].getProductNo().equals(productno)) return list[i];
        }
        return null;
    }

    @Override
    public Product[] seletAll() {
        return list;
    }

    @Override
    public int getCount() {
        return count;
    }

}
