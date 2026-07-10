package practice.zepto.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import practice.zepto.factory.ProductFactory;
import practice.zepto.models.CartItem;
import practice.zepto.models.DeliveryPartner;
import practice.zepto.models.Order;
import practice.zepto.models.Product;
import practice.zepto.models.User;
import practice.zepto.segments.Cart;
import practice.zepto.segments.DarkStore;

public class OrderManager {
    private static OrderManager INSTANCE = null;
    List<Order> orders;

    private OrderManager() {
        System.out.println("OrderManager initialized...");
        orders = new ArrayList<>();
    }

    public static synchronized OrderManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new OrderManager();
        }
        return INSTANCE;
    }

    public void placeOrder(User user, Cart cart) {
        System.out.println("Placing order...");

        String userName = user.getName();
        System.out.println("Order placed by user: " + userName);

        int userXCoord = user.getCoordX();
        int userYCoord = user.getCoordY();
        System.out.println("User location: (" + userXCoord + ", " + userYCoord + ")");

        // List of cart Items
        List<CartItem> cartItems = cart.getCartItems();
        
        // List of Dark Stores nearby with closest distance sorted
        List<DarkStore> darkStoresNearby = DarkStoreManager.getInstance().getDarkStoresNearby(userXCoord, userYCoord, 5);


        if(darkStoresNearby.isEmpty()) {
            System.out.println("No dark stores nearby");
            return;
        }

        DarkStore firstStore = darkStoresNearby.get(0);
        boolean allItemsAvailableInFirstStore = true;

        for(CartItem item: cartItems) {
            int sku = item.getProduct().getSku();
            int quantity = item.getQuantity();

            if(firstStore.checkStock(sku) < quantity) {
                allItemsAvailableInFirstStore = false;
                break;
            }
        }

        Order order = new Order(user);
        List<String> deliveryPartners = new ArrayList<>();

        // Only one delivery partner is needed
        if(allItemsAvailableInFirstStore) {
            System.out.println("All items available in first store");

            for(CartItem item: cartItems) {
                Product product = item.getProduct();
                int sku = item.getProduct().getSku();
                int quantity = item.getQuantity();

                firstStore.removeStock(sku, quantity);

                // This cartItem only means the orderItem and only type is CartItem
                CartItem orderItem = new CartItem(product, quantity);
                order.addItemToOrder(orderItem);
            }

            order.addDeliveryPartner(new DeliveryPartner("Partner1"));
            System.out.println("Order assigned to delivery partner: Partner1");
        }

        else {
            System.out.println("Splitting order between multiple delivery partners");
            
            // Place the cartItems in a Map for easy access and removal
            Map<Integer, Integer> cartItemsMap = new HashMap<>();

            for(CartItem item: cartItems) {
                int sku = item.getProduct().getSku();
                int quantity = item.getQuantity();
                cartItemsMap.put(sku, quantity);
            }

            int partnerId = 1;

            for(DarkStore store: darkStoresNearby) {

                // If no items left while iterating, break
                if(cartItemsMap.isEmpty()) {
                    break;
                }

                List<Integer> toErase = new ArrayList<>();
                boolean storeContributed = false;

                for(Map.Entry<Integer, Integer> entry : cartItemsMap.entrySet()) {
                    int sku = entry.getKey();
                    int quantity = entry.getValue();
                    int availableQuantity = store.checkStock(sku);

                    if(availableQuantity <= 0) {
                        continue;
                    }

                    int takenQuantity = Math.min(quantity, availableQuantity);
                    if(takenQuantity > 0) {
                        storeContributed = true;
                    }
                    store.removeStock(sku, takenQuantity);

                    System.out.println(store.getName() + " supplies " + sku + " of quantity " + takenQuantity);
                    order.addItemToOrder(new CartItem(ProductFactory.createProduct(sku), quantity));

                    if(quantity > takenQuantity) {
                        cartItemsMap.put(sku, quantity - takenQuantity);
                    }
                    else {
                        toErase.add(sku);
                    }
                }

                for(Integer sku: toErase) {
                    cartItemsMap.remove(sku);
                }

                if(storeContributed) {
                    DeliveryPartner deliveryPartner = new DeliveryPartner("Partner" + partnerId);
                    order.addDeliveryPartner(deliveryPartner);
                    System.out.println("Order assigned to delivery partner: Partner" + partnerId);
                    partnerId++;
                }
            }

            if(!cartItemsMap.isEmpty()) {
                System.out.println("Could not fullfill order of ");
                for(Map.Entry<Integer, Integer> entry : cartItemsMap.entrySet()) {
                    int sku = entry.getKey();
                    int quantity = entry.getValue();
                    System.out.println("Sku " + sku + " of quantity " + quantity);
                }
            }

            double totalAmount = 0;
            for(CartItem item: order.getOrderItems()) {
                totalAmount += item.getTotalPrice();
            }

            order.setTotalAmount(totalAmount);
        }
        
    }

    public List<Order> getOrders() {
        return orders;
    }

}
