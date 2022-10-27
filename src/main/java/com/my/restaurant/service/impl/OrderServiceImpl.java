package com.my.restaurant.service.impl;

import com.my.restaurant.cuisine.Cuisine;
import com.my.restaurant.entity.Beverage;
import com.my.restaurant.entity.Lunch;
import com.my.restaurant.entity.Order;
import com.my.restaurant.repository.OrderRepository;
import com.my.restaurant.service.OrderService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private Cuisine cuisine;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String addLunchToOrder(Order order, Integer productId) {
        List<Lunch> availableLunches = cuisine.getAvailableLunches();

        Optional<Lunch> lunch = availableLunches.stream().filter(l -> Objects.equals(l.getId(), productId)).findFirst();

        if (lunch.isPresent()) {
            order.setLunch(lunch.get());
            return String.format("Lunch with id %d successfully added to order!", productId);
        }

        return String.format("Lunch with id %d doesn't exist", productId);
    }

    @Override
    public String addBeverageToOrder(Order order, Integer beverageID) {
        List<Beverage> availableBeverages = orderRepository.getAvailableBeverages();

        Optional<Beverage> beverage = availableBeverages.stream().filter(b -> Objects.equals(b.getId(), beverageID)).findFirst();

        if (beverage.isPresent()) {
            order.setBeverage(beverage.get());
            return String.format("Beverage with id %d successfully added to order!", beverageID);
        }

        return String.format("Beverage with id %d doesn't exist", beverageID);
    }


    @Override
    public String makeOrder(Order order) {
        orderRepository.makeOrder(order);
        int totalPrice = calculateTotalPrice(order);
        return String.format("Your order:%n%s%nTotal price: %d UAH%n", order, totalPrice);
    }

    @Override
    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public String getAllOrders() {
        return listToString(orderRepository.getAllOrders());
    }

    @Override
    public String getAvailableLunches() {
        return listToString(cuisine.getAvailableLunches());
    }

    @Override
    public String getAvailableBeverages() {
        return listToString(orderRepository.getAvailableBeverages());
    }

    private String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(l -> sb.append(l).append("\n"));
        return sb.toString();
    }

    private int calculateTotalPrice(Order order) {
        int orderTotalPrice = order.getLunch().getDessert().getPrice() + order.getLunch().getMainCourse().getPrice();
        if (order.getBeverage() != null) {
            orderTotalPrice += order.getBeverage().getPrice();
        }
        return  orderTotalPrice;
    }
}
