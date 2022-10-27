package com.my.restaurant.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Command {

    HELP("/help"),
    ORDER("/make_order"),
    ALL_ORDERS("/all_orders"),
    NOT_EXISTED_COMMAND("not exists");

    private String command;

    Command(String command) {
        this.command = command;
    }

    public static Command getCommand(String cmd) {
        Optional<Command> command = Arrays.stream(Command.values())
                .filter(c -> c.getCommandValue().equals(cmd))
                .findFirst();

       return command.orElse(NOT_EXISTED_COMMAND);
    }

    public String getCommandValue() {
        return command;
    }
}
