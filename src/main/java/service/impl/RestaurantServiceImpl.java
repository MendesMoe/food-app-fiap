package service.impl;

import lombok.RequiredArgsConstructor;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RestaurantRepository;
import service.RestaurantService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        var randomString = UUID.randomUUID().toString().replace("-", "");
        restaurant.setId(randomString);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant searchRestaurant(String id) {
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant deleteRestaurant(Restaurant restaurant) {
        return null;
    }
}
