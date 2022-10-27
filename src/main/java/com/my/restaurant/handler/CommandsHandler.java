package com.my.restaurant.handler;

import com.my.restaurant.context.RestaurantContext;
import com.my.restaurant.entity.Command;
import com.my.restaurant.util.CuisineCommandExecutor;

import java.util.Optional;
import java.util.Scanner;

public class CommandsHandler {

    private final RestaurantContext context;

    public CommandsHandler() {
        this.context = new RestaurantContext();
    }

    public void handle() {
        System.out.println("Input command");
        String inputtedCommand = new Scanner(System.in).nextLine();

        Optional<CuisineCommandExecutor> commandExecutor = Optional.ofNullable(context.getCommands().get(Command.getCommand(inputtedCommand)));

        commandExecutor.ifPresentOrElse(CuisineCommandExecutor::executeCommand,
                () -> {
                    String message = String.format("Command '%s' doesn't exist.%nput '%s' to get list of commands.",
                            inputtedCommand, Command.HELP.getCommandValue());
                    System.out.println(message);
                });
    }
}
