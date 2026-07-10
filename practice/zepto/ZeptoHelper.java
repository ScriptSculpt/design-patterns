package practice.zepto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import practice.zepto.enums.RestockStrategyType;
import practice.zepto.managers.DarkStoreManager;
import practice.zepto.managers.RestockStrategyManager;
import practice.zepto.models.Product;
import practice.zepto.models.User;
import practice.zepto.segments.DarkStore;
import practice.zepto.strategy.restock.RestockStrategy;

public class ZeptoHelper {
    public static void initialize() {
        DarkStoreManager storeManager = DarkStoreManager.getInstance();

        DarkStore store1 = new DarkStore("Store 1", 0, 0, RestockStrategyManager.getInstance().createRestockType(RestockStrategyType.THRESHOLD));
        store1.addStock(new Product(1, "Product 1", 10), 1);
        store1.addStock(new Product(2, "Product 2", 20), 2);
        store1.addStock(new Product(3, "Product 3", 10), 5);
        store1.addStock(new Product(2, "Product 4", 40), 3);
        store1.addStock(new Product(5, "Product 5", 100), 2);



        DarkStore store2 = new DarkStore("Store 2", 1, 1, RestockStrategyManager.getInstance().createRestockType(RestockStrategyType.WEEKLY));
        store2.addStock(new Product(1, "Product 1", 10), 2);
        store2.addStock(new Product(2, "Product 2", 20), 4);
        store2.addStock(new Product(3, "Product 3", 10), 1);
        store2.addStock(new Product(4, "Product 4", 40), 6);
        store2.addStock(new Product(5, "Product 5", 100), 2);


        storeManager.addStore(store1);
        storeManager.addStore(store2);
    }

    public static void showItems(User user) {
        System.out.println("Available Items for user: " + user.getName());

        DarkStoreManager storeManager = DarkStoreManager.getInstance();
        List<DarkStore> darkStoresNearby = storeManager.getDarkStoresNearby(user.getCoordX(), user.getCoordY(), 5);

        Map<Integer, Double> skuToPrice = new HashMap<>();
        Map<Integer, String> skuToName = new HashMap<>();

        for(DarkStore darkStore : darkStoresNearby) {
            for(Product product : darkStore.getAvailableProducts()) {
                int sku = product.getSku();
                double price = product.getPrice();
                String name = product.getName();

                skuToPrice.put(sku, price);
                skuToName.put(sku, name);
            }
        }

        for(Integer sku : skuToPrice.keySet()) {
            System.out.println("SKU: " + sku + ", Name: " + skuToName.get(sku) + ", Price: " + skuToPrice.get(sku));
        }
    }
}
