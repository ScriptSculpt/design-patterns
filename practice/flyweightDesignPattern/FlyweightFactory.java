package practice.flyweightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Flyweight> flyweightsMap = new HashMap<>();

    public Flyweight getFlyweight(int length, int width, int height, String shape) {
        String key = length + "-" + width + "-" + height + "-" + shape;
        if (!flyweightsMap.containsKey(key)) {
            flyweightsMap.put(key, new Flyweight(length, width, height, shape));
        }
        return flyweightsMap.get(key);
    }
    
}
