package com.my.restaurant.entity;

import java.util.Objects;

public class Beverage extends Product {

    private double capacity;
    private boolean lemon;
    private boolean iceCubes;

    public double getCapacity() {
        return capacity;
    }

    public Beverage setCapacity(double capacity) {
        this.capacity = capacity;
        return this;
    }

    public boolean isLemon() {
        return lemon;
    }

    public Beverage setLemon(boolean lemon) {
        this.lemon = lemon;
        return this;
    }

    public boolean isIceCubes() {
        return iceCubes;
    }

    public Beverage setIceCubes(boolean iceCubes) {
        this.iceCubes = iceCubes;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Beverage ID: %d. %s. Capacity %.3fL. Lemon %b. Ice cubes %b", super.getId(), super.toString(), capacity, lemon, iceCubes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Beverage)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Beverage beverage = (Beverage) o;
        return Double.compare(beverage.capacity, capacity) == 0 && lemon == beverage.lemon && iceCubes == beverage.iceCubes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, lemon, iceCubes);
    }
}
