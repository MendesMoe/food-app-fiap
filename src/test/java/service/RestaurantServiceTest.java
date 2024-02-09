package service;

import model.Restaurant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.RestaurantRepository;
import service.impl.RestaurantServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    private RestaurantService restaurantService;

    AutoCloseable openMocks;

    @BeforeEach
        // Before chaque test le setup doit etre habilité et after each le tear down doit etre executé aussi
    void setup(){
        openMocks = MockitoAnnotations.openMocks(this);
        restaurantService = new RestaurantServiceImpl(restaurantRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void shouldAllowToCreateARestaurant(){
        //Arrange
        var restaurant = createARestaurant();
        when(restaurantRepository.save(ArgumentMatchers.any(Restaurant.class))).thenReturn(restaurant);

        // problem with => .thenAnswer( i -> i.getArgument(0));

        //Act
        var restaurantSaved = restaurantService.createRestaurant(restaurant);

        //Assert
        assertThat(restaurantSaved).isInstanceOf(Restaurant.class).isNotNull();

    }

    @Test
    void shouldAllowSearchARestaurant(){}

    @Test
    void shouldAllowUpdateRestaurant(){}

    @Test
    void shouldAllowDeleteRestaurant(){}

    private Restaurant createARestaurant(){
        return Restaurant.builder()
                .id("123")
                .city("Belem")
                .foodType("Tapioca")
                .name("Tata")
                .open(true)
                .stars(5)
                .build();
    }
}
