package com.my.restaurant.entity;

import java.util.Objects;

public class Order {

    private Integer id;
    private Lunch lunch;
    private Beverage beverage;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public Lunch getLunch() {
        return lunch;
    }

    public Order setLunch(Lunch lunch) {
        this.lunch = lunch;
        return this;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public Order setBeverage(Beverage beverage) {
        this.beverage = beverage;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lunch);
        if (beverage != null) {
            sb
                    .append("\n")
                    .append(beverage);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(lunch, order.lunch) && Objects.equals(beverage, order.beverage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lunch, beverage);
    }
}
