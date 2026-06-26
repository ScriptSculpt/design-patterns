package practice.zomato.service;

import java.util.List;

import practice.zomato.entity.Restaurant;

public class RestaurantService {
    List<Restaurant> restaurants;

    public RestaurantService(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void searchRestaurants(String location) {
        System.out.println("Searching for restaurants in " + location);
        for(Restaurant restaurant: restaurants) {
            if(restaurant.getLocation().equals(location)) { // Assuming a threshold of 10 units
                System.out.println("Found restaurant: " + restaurant.getName() + " at location: " + restaurant.getLocation());
            }
        }
    }
}
