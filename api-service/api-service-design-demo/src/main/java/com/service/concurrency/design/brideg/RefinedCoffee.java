package com.service.concurrency.design.brideg;

import java.util.Random;

public abstract class RefinedCoffee extends Coffee {
    public RefinedCoffee(ICoffeeAdditives additives) {
        super(additives);
    }

    public void checkQuality() {
        Random ran = new Random();

        System.out.println(String.format("%s 添加%s", additives.getClass().getSimpleName(), ran.nextBoolean() ? "太多" : "正常"));
    }
}
