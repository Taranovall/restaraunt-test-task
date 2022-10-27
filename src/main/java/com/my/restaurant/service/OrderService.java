package com.my.restaurant.service;

import com.my.restaurant.cuisine.Cuisine;
import com.my.restaurant.entity.Order;

public interface OrderService {

    String addLunchToOrder(Order order, Integer productID);

    String addBeverageToOrder(Order order, Integer beverageID);

    String makeOrder(Order order);

    void setCuisine(Cuisine cuisine);

    String getAllOrders();

    String getAvailableLunches();

    String getAvailableBeverages();
}
