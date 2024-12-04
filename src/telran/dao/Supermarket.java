package telran.dao;

import telran.model.Product;

import java.util.ArrayList;

public interface Supermarket extends Iterable<Product> {

    boolean addProduct(Product product);
    Product removeProduct(long barCode);
    Product findByBarCode(long barCode);
    ArrayList<Product> findByCategory(String category);
    ArrayList<Product> findByBrand(String brand);
    ArrayList<Product> findProductsWithExpireDate();
    int skuQuantity();

}
