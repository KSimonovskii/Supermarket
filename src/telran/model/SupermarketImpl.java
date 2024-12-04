package telran.model;

import telran.dao.Supermarket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class SupermarketImpl implements Supermarket {

    private ArrayList<Product> products;

    public SupermarketImpl() {
        this.products = new ArrayList<>();
    }

    @Override
    public boolean addProduct(Product product) {
        if (product == null
                ||findByBarCode(product.getBarCode()) != null){
            return false;
        }
        return products.add(product);
    }

    @Override
    public Product removeProduct(long barCode) {
        Product res = findByBarCode(barCode);
        if (res != null) {
            products.remove(res);
        }
        return res;
    }

    @Override
    public Product findByBarCode(long barCode) {

        ArrayList<Product> res = searchByPredicate(product -> product.getBarCode() == barCode);

        for (Product product: res) {
            return product;
        }

        return null;
    }

    @Override
    public ArrayList<Product> findByCategory(String category) {
        return searchByPredicate(product -> product.getCategory().equals(category));
    }

    @Override
    public ArrayList<Product> findByBrand(String brand) {
        return searchByPredicate(product -> product.getBrand().equals(brand));
    }

    @Override
    public ArrayList<Product> findProductsWithExpireDate() {
        return searchByPredicate(product -> product.getExpDate().isBefore(LocalDate.now()));
    }

    public ArrayList<Product> searchByPredicate(Predicate<Product> predicate){

        ArrayList<Product> res = new ArrayList<>();

        for (Product product: products) {
            if (predicate.test(product)){
                res.add(product);
            }
        }

        return res;
    }

    @Override
    public int skuQuantity() {
        return products.size();
    }

    @Override
    public Iterator<Product> iterator() {
       return products.iterator();
    }

}
