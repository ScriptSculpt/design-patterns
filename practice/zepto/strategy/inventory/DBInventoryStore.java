package practice.zepto.strategy.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import practice.zepto.models.Product;

public class DBInventoryStore implements InventoryStore {
    Map<Integer, Integer> stocks = new HashMap<>(); // sku -> quantity
    Map<Integer, Product> products = new HashMap<>(); // sku -> product

    
    @Override
    public void addStock(Product product, int quantity) {
        System.out.println("Adding stock...");
        int sku = product.getSku();

        if (!products.containsKey(sku)) {
            products.put(sku, product);
        }

        int existingQuantity = stocks.getOrDefault(sku, 0);
        stocks.put(sku, existingQuantity + quantity);
    }

    @Override
    public void removeStock(int sku, int quantity) {
        System.out.println("Removing stock...");
        if (!stocks.containsKey(sku)) return;

        int existingQuantity = stocks.getOrDefault(sku, 0);
        int remainingQuantity = existingQuantity - quantity;

        if (remainingQuantity > 0) {
            stocks.put(sku, remainingQuantity);
        } else {
            stocks.remove(sku);
            products.remove(sku);
        }
    }

    @Override
    public int checkStock(int sku) {
        System.out.println("Checking stock...");
        return stocks.getOrDefault(sku, 0);
    }

    @Override
    public List<Product> getAvailableProducts() {
        System.out.println("Getting available products...");
        List<Product> availableProducts = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : this.stocks.entrySet()) {
            int sku = entry.getKey();
            int quantity = entry.getValue();

            if (quantity > 0 && this.products.containsKey(sku)) {
                availableProducts.add(this.products.get(sku));
            }
        }

        return availableProducts;
    }
    
}
