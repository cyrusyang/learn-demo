package com.moda.decorator;

public class KeepWarmDecorator extends CupDecorator{

    public KeepWarmDecorator(CupAbility cupAbility) {
        super(cupAbility);
    }
    @Override
    public void fillWater() {
        super.fillWater();
        System.out.println("开始保温======");
    }
}
