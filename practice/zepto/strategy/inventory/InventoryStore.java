package practice.zepto.strategy.inventory;

import java.util.List;
import practice.zepto.models.Product;


public interface InventoryStore {
    void addStock(Product product, int quantity);
    void removeStock(int sku, int quantity);
    int checkStock(int sku);
    List<Product> getAvailableProducts();
}
