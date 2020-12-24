package com.moda.decorator;

public class test {
    public static void main(String[] args) {
        KeepWarmDecorator keepWarmDecorator = new KeepWarmDecorator(new Cup());
        keepWarmDecorator.fillWater();

        BoilingCup boilingCup = new BoilingCup(keepWarmDecorator);
        boilingCup.fillWater();
    }
}
