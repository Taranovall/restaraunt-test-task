package com.my.restaurant.cuisine.impl;

import com.my.restaurant.cuisine.Cuisine;
import com.my.restaurant.entity.Dish;
import com.my.restaurant.entity.Lunch;

import java.util.List;

public class MexicanCuisine implements Cuisine {

    @Override
    public List<Lunch> getAvailableLunches() {
        return List.of(
                new Lunch().setId(1)
                        .setMainCourse((Dish) new Dish().setWeight(250).setId(1).setName("Tacos").setPrice(52))
                        .setDessert((Dish) new Dish().setWeight(50).setId(1).setName("Caramel Flan").setPrice(50)),
                new Lunch().setId(2)
                        .setMainCourse((Dish) new Dish().setWeight(250).setId(1).setName("Burritos").setPrice(59))
                        .setDessert((Dish) new Dish().setWeight(50).setId(1).setName("Dulce de Leche").setPrice(57)),
                new Lunch().setId(3)
                        .setMainCourse((Dish) new Dish().setWeight(250).setId(1).setName("Chicken or Wild Turkey Stew").setPrice(125))
                        .setDessert((Dish) new Dish().setWeight(50).setId(1).setName("Churros").setPrice(49))
        );
    }
}
