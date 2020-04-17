package com.service.concurrency.design.brideg;

public class MainTest {


    public static void main(String[] args) {
        RefinedCoffee largeWithMilk = new LargeCoffee(new Milk());

    }
}
