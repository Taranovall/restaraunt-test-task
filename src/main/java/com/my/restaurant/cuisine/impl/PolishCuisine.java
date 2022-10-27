package com.my.restaurant.cuisine.impl;

import com.my.restaurant.cuisine.Cuisine;
import com.my.restaurant.entity.Dish;
import com.my.restaurant.entity.Lunch;

import java.util.List;

public class PolishCuisine implements Cuisine {

    @Override
    public List<Lunch> getAvailableLunches() {
        return List.of(
                new Lunch().setId(1)
                        .setMainCourse((Dish) new Dish().setWeight(500).setId(1).setName("Kapuśniak").setPrice(74))
                        .setDessert((Dish) new Dish().setWeight(50).setId(1).setName("Kołaczki: Polish Cream Cheese Cookies").setPrice(50)),

               new Lunch().setId(2)
                        .setMainCourse((Dish) new Dish().setWeight(500).setId(1).setName("Barszcz biały").setPrice(64))
                        .setDessert((Dish) new Dish().setWeight(50).setId(1).setName("Polish Coffee Cake").setPrice(45))

                );
    }
}
