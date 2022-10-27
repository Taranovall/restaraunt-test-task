package com.my.restaurant.context;

import com.my.restaurant.controller.HelpController;
import com.my.restaurant.controller.OrderController;
import com.my.restaurant.cuisine.CuisineStrategy;
import com.my.restaurant.entity.Command;
import com.my.restaurant.repository.impl.OrderRepositoryImpl;
import com.my.restaurant.service.OrderService;
import com.my.restaurant.service.impl.OrderServiceImpl;
import com.my.restaurant.util.CuisineCommandExecutor;

import java.util.Map;

/**
 * Restaurant context is a class which perform function of dependency injection
 */
public class RestaurantContext {

    private final CuisineStrategy cuisineStrategy;
    private final OrderController orderController;
    private final HelpController helpController;
    private final Map<Command, CuisineCommandExecutor> commands;

    public RestaurantContext() {
        this.cuisineStrategy = new CuisineStrategy();

        OrderService orderService = new OrderServiceImpl(new OrderRepositoryImpl());

        this.orderController = new OrderController(orderService, cuisineStrategy);
        this.helpController = new HelpController();

        this.commands = createCommandsMap();
    }

    public CuisineStrategy getCuisineStrategy() {
        return cuisineStrategy;
    }

    /**
     * This is a map from which is taken necessary command
     * @return map where key is a command and value is a functional interface which executes command
     */
    private Map<Command, CuisineCommandExecutor> createCommandsMap() {
        return Map.ofEntries(
                Map.entry(Command.ORDER, orderController::makeOrder),
                Map.entry(Command.ALL_ORDERS, orderController::printAllOrders),
                Map.entry(Command.HELP, helpController::printAvailableCommands)
        );
    }

    public Map<Command, CuisineCommandExecutor> getCommands() {
        return commands;
    }
}
