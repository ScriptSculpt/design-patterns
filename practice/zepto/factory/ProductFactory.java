package practice.zepto.factory;

import practice.zepto.models.Product;

// Just a dummy factory to return products which should be fetched from DB
public class ProductFactory {
    public static Product createProduct(int sku) {
        switch(sku) {
            case 1:
                return new Product(1, "Moisturizer", 300);
            case 2:
                return new Product(2, "Facewash", 200);
            case 3:
                return new Product(3, "Shampoo", 400);
            case 4:
                return new Product(4, "Conditioner", 450);
            case 5:
                return new Product(5, "Body Lotion", 250);
            default:
                return new Product(sku, "Unknown Product", 0);
        }
    }
}
