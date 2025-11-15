package Exam_34.Service;

import Exam_34.Vo.Product;

public interface CosmeticService {
    public boolean insert(Product product);
    public Product update(String product);
    public boolean delete(String name);
    public Product seletOne(String name);
    public Product[] seletAll();
    public int getCount();

}
