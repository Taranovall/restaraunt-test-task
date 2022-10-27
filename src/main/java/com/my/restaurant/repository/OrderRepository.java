package com.my.restaurant.repository;

import com.my.restaurant.entity.Beverage;
import com.my.restaurant.entity.Order;

import java.util.List;

public interface OrderRepository {

    void makeOrder(Order order);

    List<Order> getAllOrders();

    List<Beverage> getAvailableBeverages();
}
