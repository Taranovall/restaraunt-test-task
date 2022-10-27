package com.my.restaurant.controller;

import com.my.restaurant.cuisine.Cuisine;
import com.my.restaurant.cuisine.CuisineStrategy;
import com.my.restaurant.entity.Beverage;
import com.my.restaurant.entity.Order;
import com.my.restaurant.service.OrderService;

import java.util.Scanner;

public class OrderController {

    private final OrderService orderService;
    private final CuisineStrategy cuisineStrategy;

    public OrderController(OrderService orderService, CuisineStrategy cuisineStrategy) {
        this.orderService = orderService;
        this.cuisineStrategy = cuisineStrategy;
    }

    public void makeOrder() {
        orderService.setCuisine(chooseCuisine());
        Order order = new Order();
        System.out.printf("Which lunch would you like to add to your order?%n%s%nInput id.%n", orderService.getAvailableLunches());
        int id = new Scanner(System.in).nextInt();
        orderService.addLunchToOrder(order, id);

        System.out.println("Would you like to buy beverages? (0/1)");
        int answer = new Scanner(System.in).nextInt();

        if (answer == 1) {
            addBeverage(order);
        }

        System.out.println(orderService.makeOrder(order));
    }

    private void addBeverage(Order order) {
        System.out.printf("Which beverage would you like to add to your order?%n%s%nInput id.%n", orderService.getAvailableBeverages());
        int beverageID = new Scanner(System.in).nextInt();
        orderService.addBeverageToOrder(order, beverageID);
        Beverage beverage = order.getBeverage();
        addLemon(beverage);
        addIceCubes(beverage);
    }

    public void printAllOrders() {
        System.out.println(orderService.getAllOrders());
    }

    private Cuisine chooseCuisine() {
        while (true) {
            if (cuisineStrategy.chooseCuisine()) {
                return cuisineStrategy.getCuisine();
            }
        }
    }

    /**
     * Adds ice cubes to beverage if client want
     * @param beverage object of beverage
     */
    private void addIceCubes(Beverage beverage) {
        System.out.println("Do you want ice cubes to be added in beverage? (0/1)");
        int answer = new Scanner(System.in).nextInt();

        if (answer == 1) {
            beverage.setIceCubes(true);
        }
    }

    /**
     * Adds lemon to beverage if client want
     * @param beverage object of beverage
     */
    private void addLemon(Beverage beverage) {
        System.out.println("Do you want some lemon to be added in beverage? (0/1)");
        int answer = new Scanner(System.in).nextInt();

        if (answer == 1) {
            beverage.setLemon(true);
        }
    }
}
