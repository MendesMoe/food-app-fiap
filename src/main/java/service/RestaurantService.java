package service;

import model.Restaurant;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantService {

    public Restaurant createRestaurant(Restaurant restaurant);
    public Restaurant searchRestaurant(String id);
    public Restaurant updateRestaurant(Restaurant restaurant);
    public Restaurant deleteRestaurant(Restaurant restaurant);
}
