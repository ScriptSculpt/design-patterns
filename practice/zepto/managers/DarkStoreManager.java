package practice.zepto.managers;

import java.util.ArrayList;
import java.util.List;

import practice.zepto.segments.DarkStore;

public class DarkStoreManager {
    private static DarkStoreManager INSTANCE = null;
    List<DarkStore> darkStores = new ArrayList<>();

    private DarkStoreManager() {
        System.out.println("DarkStoreManager initialized...");
    }

    public static synchronized DarkStoreManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DarkStoreManager();
        }
        return INSTANCE;
    }

    public void addStore(DarkStore darkStore) {
        darkStores.add(darkStore);
    }

    public List<DarkStore> getDarkStoresNearby(int coordX, int coordY, int maxDistance) {
        List<DarkStore> darkStoresNearby = new ArrayList<>();
        for(DarkStore darkStore : darkStores) {
            if(darkStore.getDistanceFromUser(coordX, coordY) <= maxDistance) {
                darkStoresNearby.add(darkStore);
            }
        }

        darkStoresNearby.sort((a, b) -> Double.compare(a.getDistanceFromUser(coordX, coordY), b.getDistanceFromUser(coordX, coordY)));

        return darkStoresNearby;
    }
}
