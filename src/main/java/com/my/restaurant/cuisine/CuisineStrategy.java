package com.my.restaurant.cuisine;

import com.my.restaurant.cuisine.impl.ItalianCuisine;
import com.my.restaurant.cuisine.impl.MexicanCuisine;
import com.my.restaurant.cuisine.impl.PolishCuisine;

import java.util.Map;
import java.util.Scanner;

public class CuisineStrategy {

    private final Map<String, Cuisine> cuisines = Map.of(
            "Polish", new PolishCuisine(),
            "Italian", new ItalianCuisine(),
            "Mexican", new MexicanCuisine()
    );

    private Cuisine cuisine;

    public CuisineStrategy() {
    }

    /**
     * There's three different cuisines available in restaurant application.
     * This function let user to chose from which one he/she wants to make order.
     * @return true if user inputted available cuisine, otherwise return false
     */
    public boolean chooseCuisine() {
        printAvailableOptions();
        String answer = new Scanner(System.in).nextLine();
        Cuisine c = cuisines.get(answer);
        if (c != null) {
            this.cuisine = c;
            System.out.printf("%s cuisine has been chosen!%n", answer);
            return true;
        }
        System.out.printf("%s cuisine isn't available yet!%n", answer);
        return false;
    }

    /**
     * Prints available cuisines to console
     */
    private void printAvailableOptions() {
        String availableCuisines = getAvailableCuisines();
        String msg = String.format("We have %d cuisines available to choose from:\n%sWhich one would you prefer?", cuisines.size(), availableCuisines);
        System.out.println(msg);
    }

    /**
     *
     * @return string with available cuisines
     */
    private String getAvailableCuisines() {
        StringBuilder sb = new StringBuilder();
        cuisines.keySet().forEach(c -> sb.append(c)
                .append("\n"));
        return sb.toString();
    }

    public Cuisine getCuisine() {
        return cuisine;
    }
}
