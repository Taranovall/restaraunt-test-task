package com.my.restaurant.entity;

import java.util.Objects;

public class Lunch {

    private Integer id;
    private Dish mainCourse;
    private Dish dessert;

    public Lunch() {
    }

    public Integer getId() {
        return id;
    }

    public Lunch setId(Integer id) {
        this.id = id;
        return this;
    }

    public Dish getMainCourse() {
        return mainCourse;
    }

    public Lunch setMainCourse(Dish mainCourse) {
        this.mainCourse = mainCourse;
        return this;
    }

    public Dish getDessert() {
        return dessert;
    }

    public Lunch setDessert(Dish dessert) {
        this.dessert = dessert;
        return this;
    }

    @Override
    public String toString() {
        return String.format("ID: %d. %s %s", id, mainCourse, dessert);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lunch)) {
            return false;
        }
        Lunch lunch = (Lunch) o;
        return Objects.equals(id, lunch.id) && Objects.equals(mainCourse, lunch.mainCourse) && Objects.equals(dessert, lunch.dessert);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mainCourse, dessert);
    }
}
