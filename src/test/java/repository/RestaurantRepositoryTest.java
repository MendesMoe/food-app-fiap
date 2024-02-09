package repository;

import model.Restaurant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class RestaurantRepositoryTest {

    @Mock //Deja dans les dependances
    private RestaurantRepository restaurantRepository;

    AutoCloseable openMocks;

    @BeforeEach // Before chaque test le setup doit etre habilité et after each le tear down doit etre executé aussi
    void setup(){
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void shouldAllowToCreateARestaurant(){
        //Arrange
        var restaurant = createARestaurant();
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);  //Deixa um pouco mais genérico

        // Act
        var restaurantSave = restaurantRepository.save(restaurant);

        // Assert
        assertThat(restaurantSave)
                .isNotNull()
                .isEqualTo(restaurant);
        //boa pratica
        verify(restaurantRepository, times(1)).save(any(Restaurant.class));
    }

    @Test
    void shouldAllowSearchARestaurant(){
        //Arrange
        String id = "123";
        var restaurant = createARestaurant();
        restaurant.setId(id);

        when(restaurantRepository.findById(anyString()))
                .thenReturn(Optional.of(restaurant));
        // Act
        var restaurantFind = restaurantRepository.findById("123");

        // Assert
        assertThat(restaurantFind)
                .isPresent()
                .containsSame(restaurant);
    }

    @Test
    void shouldAllowUpdateRestaurant(){
        fail("teste nao implementado");
    }

    @Test
    void shouldAllowDeleteRestaurant(){
        fail("teste nao implementado");
    }

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
