package com.my.restaurant.cuisine.impl;

import com.my.restaurant.cuisine.Cuisine;
import com.my.restaurant.entity.Dish;
import com.my.restaurant.entity.Lunch;

import java.util.List;

public class ItalianCuisine implements Cuisine {

    @Override
    public List<Lunch> getAvailableLunches() {
        return List.of(
                new Lunch().setId(1)
                        .setMainCourse((Dish) new Dish().setWeight(250).setId(1).setName("Pancetta and Pesto Pasta").setPrice(125))
                        .setDessert((Dish) new Dish().setWeight(50).setId(1).setName("Italian Butter Cookies").setPrice(50)),
        new Lunch().setId(2)
                        .setMainCourse((Dish) new Dish().setWeight(250).setId(1).setName("Italian Caprese Pasta Salad").setPrice(125))
                        .setDessert((Dish) new Dish().setWeight(50).setId(1).setName("Traditional Italian Breakfast Cookies").setPrice(57)),
        new Lunch().setId(3)
                        .setMainCourse((Dish) new Dish().setWeight(250).setId(1).setName("Creamy Mushroom Risotto").setPrice(125))
                        .setDessert((Dish) new Dish().setWeight(50).setId(1).setName("Lemon Ricotta Cake with Almonds").setPrice(41))
        );
    }
}
