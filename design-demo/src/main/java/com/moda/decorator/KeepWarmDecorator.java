package com.moda.decorator;

public class KeepWarmDecorator implements CupAbility{
    private Cup cup;

    public KeepWarmDecorator(Cup cup) {
        this.cup = cup;
    }

    @Override
    public void fillWater() {
        cup.fillWater();
        System.out.println("开始保温======");
    }
}
