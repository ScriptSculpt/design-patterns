package practice.zepto.managers;

import java.util.List;

import practice.zepto.models.Product;
import practice.zepto.strategy.inventory.DBInventoryStore;
import practice.zepto.strategy.inventory.InventoryStore;

public class InventoryManager {
    private InventoryStore inventoryStore;

    public InventoryManager(InventoryStore inventoryStore) {
        System.out.println("InventoryManager initialized...");
        this.inventoryStore = inventoryStore;
    }

    public void addStock(Product product, int quantity) {
        inventoryStore.addStock(product, quantity);
    }

    public void removeStock(int sku, int quantity) {
        inventoryStore.removeStock(sku, quantity);
    }

    public int checkStock(int sku) {
        return inventoryStore.checkStock(sku);
    }

    public List<Product> getAvailableProducts() {
        return inventoryStore.getAvailableProducts();
    }

}
