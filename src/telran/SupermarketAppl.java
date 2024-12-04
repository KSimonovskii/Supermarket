package telran;

import telran.model.Product;
import telran.model.SupermarketImpl;

import java.time.LocalDate;

public class SupermarketAppl {
    public static void main(String[] args) {
        SupermarketImpl supermarket = new SupermarketImpl();

        supermarket.addProduct(new Product(1234567890123L, "Milk", "Dairy", "Brand A", 1.99, LocalDate.of(2024, 5, 15)));
        supermarket.addProduct(new Product(9876543210123L, "Bread", "Bakery", "Brand B", 2.50, LocalDate.of(2024, 4, 12)));
        supermarket.addProduct(new Product(4567891234567L, "Shampoo", "Personal Care", "Brand C", 5.99, LocalDate.of(2025, 1, 30)));
        supermarket.addProduct(new Product(3216549870123L, "Pasta", "Grocery", "Brand D", 1.50, LocalDate.of(2024, 12, 30)));
        supermarket.addProduct(new Product(7890123456789L, "Cereal", "Breakfast", "Brand E", 3.75, LocalDate.of(2024, 7, 20)));

        System.out.println("=== Product's in supermarket ===");
        for (Product product: supermarket) {
            System.out.println(product);
        }

        System.out.println("==== Product's with expired date ===");
        for (Product product: supermarket.findProductsWithExpireDate()){
            System.out.println(product);
        }
    }
}
