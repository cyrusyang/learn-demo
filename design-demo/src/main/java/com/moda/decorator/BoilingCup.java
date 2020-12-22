package com.moda.decorator;

public class BoilingCup extends CupDecorator{

    public BoilingCup() {
    }

    public BoilingCup(CupAbility cupAbility) {
        super(cupAbility);
    }

    @Override
    public void fillWater() {
        super.fillWater();
        System.out.println("沸水中=========");
    }
}
