package com.my.restaurant.cuisine;

import com.my.restaurant.entity.Lunch;

import java.util.List;

public interface Cuisine {

    /**
     * List of lunches depends on chosen implementation
     *
     * @return available lunches in specified cuisine
     */
    List<Lunch> getAvailableLunches();
}
