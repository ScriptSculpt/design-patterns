package practice.zepto.segments;

import java.util.List;

import practice.zepto.managers.InventoryManager;
import practice.zepto.models.Product;
import practice.zepto.strategy.inventory.DBInventoryStore;
import practice.zepto.strategy.restock.RestockStrategy;

public class DarkStore {
    private String name;
    private int coordX;
    private int coordY;

    private InventoryManager inventoryManager;
    private RestockStrategy restockStrategy;
   
    public DarkStore(String name, int coordX, int coordY, RestockStrategy restockStrategy) {
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
        this.inventoryManager = new InventoryManager(new DBInventoryStore());
        this.restockStrategy = restockStrategy;
    }

    public String getName() {
        return name;
    }

    public List<Product> getAvailableProducts() {
        return inventoryManager.getAvailableProducts();
    }

    public void addStock(Product product, int quantity) {
        inventoryManager.addStock(product, quantity);
    }

    public void removeStock(int sku, int quantity) {
        inventoryManager.removeStock(sku, quantity);
    }

    public int checkStock(int sku) {
        return inventoryManager.checkStock(sku);
    }

    public double getDistanceFromUser(int coordX, int coordY) {
        return Math.sqrt(Math.pow(coordX - this.coordX, 2) + Math.pow(coordY - this.coordY, 2));
    }

    public void restock() {
        restockStrategy.restock();
    }
}
