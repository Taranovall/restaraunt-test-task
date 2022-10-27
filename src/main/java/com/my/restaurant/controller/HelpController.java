package com.my.restaurant.controller;

import com.my.restaurant.entity.Command;

public class HelpController {

    public void printAvailableCommands() {
        StringBuilder infoToBePrinted = new StringBuilder();
        infoToBePrinted
                .append(String.format("%s - prints all commands%n", Command.HELP.getCommandValue()))
                .append(String.format("%s - make order%n", Command.ORDER.getCommandValue()))
                .append(String.format("%s - prints all orders%n", Command.ALL_ORDERS.getCommandValue()));
        System.out.println(infoToBePrinted);
    }
}
