package com.my.restaurant.service.impl;

import com.my.restaurant.cuisine.Cuisine;
import com.my.restaurant.cuisine.impl.ItalianCuisine;
import com.my.restaurant.cuisine.impl.PolishCuisine;
import com.my.restaurant.entity.Beverage;
import com.my.restaurant.entity.Lunch;
import com.my.restaurant.entity.Order;
import com.my.restaurant.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    OrderServiceImpl orderService;
    private Cuisine cuisine;

    @Test
    void shouldAddLunchToOrder() {
        Order order = new Order();
        cuisine = new ItalianCuisine();
        orderService.setCuisine(cuisine);
        orderService.addLunchToOrder(order, 1);

        Lunch expectedLunch = cuisine.getAvailableLunches().get(0);
        Lunch actualLunch = order.getLunch();
        orderService.makeOrder(order);

        assertNotNull(actualLunch);
        assertEquals(expectedLunch, actualLunch);
    }

    @Test
    void shouldAddBeverageToOrder() {
        when(orderRepository.getAvailableBeverages()).thenReturn(getBeverageList());

        Order order = new Order();
        orderService.addBeverageToOrder(order, 2);

        Beverage actualBeverage = order.getBeverage();
        Beverage expectedBeverage = getBeverageList().get(1);

        assertNotNull(actualBeverage);
        assertEquals(expectedBeverage, actualBeverage);
        verify(orderRepository, times(1)).getAvailableBeverages();
    }

    @Test
    void shouldTryToAddNonExistentLunch() {
        Order order = new Order();
        cuisine = new PolishCuisine();
        orderService.setCuisine(cuisine);

        String expectedMessage = "Lunch with id 17 doesn't exist";
        String actualMessage = orderService.addLunchToOrder(order, 17);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldTryToAddNonExistentBeverage() {
        Order order = new Order();

        cuisine = new ItalianCuisine();
        orderService.setCuisine(cuisine);

        when(orderRepository.getAvailableBeverages()).thenReturn(getBeverageList());


        String expectedMessage = "Beverage with id 22 doesn't exist";
        String actualMessage = orderService.addBeverageToOrder(order, 22);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldMakeAnOrderAndThenGetAllOrders() {
        Order order = new Order();
        cuisine = new ItalianCuisine();
        orderService.setCuisine(cuisine);

        when(orderRepository.getAvailableBeverages()).thenReturn(getBeverageList());

        orderService.addLunchToOrder(order, 1);
        orderService.addBeverageToOrder(order, 2);
        orderService.makeOrder(order);
        orderService.getAllOrders();

        verify(orderRepository,times(1)).getAllOrders();
        assertNotNull(order.getLunch());
        assertNotNull(order.getBeverage());
    }

    private List<Beverage> getBeverageList() {
        return List.of(
                (Beverage) new Beverage().setCapacity(0.5).setName("Coca-Cola").setPrice(22).setId(1),
                (Beverage) new Beverage().setCapacity(0.33).setName("Coca-Cola").setPrice(15).setId(2)
        );
    }
}