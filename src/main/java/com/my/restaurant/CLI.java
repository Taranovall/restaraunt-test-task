package com.my.restaurant;

import com.my.restaurant.handler.CommandsHandler;

public class CLI {

    public static void main(String[] args) {
        CommandsHandler handler = new CommandsHandler();
        while (true) {
            handler.handle();
        }
    }
}
