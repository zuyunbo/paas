package com.service.concurrency.design.brideg;

// 抽象化
public abstract class Coffee {

    protected ICoffeeAdditives additives;

    public Coffee(ICoffeeAdditives additives) {
        this.additives = additives;
    }

    public abstract void orderCoffee(int count);
}
