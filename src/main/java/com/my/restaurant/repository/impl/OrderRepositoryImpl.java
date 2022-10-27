package com.my.restaurant.repository.impl;

import com.my.restaurant.entity.Beverage;
import com.my.restaurant.entity.Order;
import com.my.restaurant.repository.OrderRepository;

import java.util.LinkedList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    List<Order> allOrders;

    public OrderRepositoryImpl() {
        this.allOrders = new LinkedList<>();
    }

    @Override
    public void makeOrder(Order order) {
        allOrders.add(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public List<Beverage> getAvailableBeverages() {
        return List.of(
                (Beverage) new Beverage().setCapacity(0.5).setName("Coca-Cola").setPrice(22).setId(1),
                (Beverage) new Beverage().setCapacity(0.33).setName("Coca-Cola").setPrice(15).setId(2),
                (Beverage) new Beverage().setCapacity(1).setName("Pepsi").setPrice(29).setId(3),
                (Beverage) new Beverage().setCapacity(0.5).setName("Beer").setPrice(29).setId(4)
        );
    }
}
