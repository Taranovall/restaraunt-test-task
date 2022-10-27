package com.my.restaurant.entity;

import java.util.Objects;

public class Dish extends Product{

    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public Dish setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s. Weight: %dg",super.toString(), weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dish)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Dish dish = (Dish) o;
        return Objects.equals(weight, dish.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
}
