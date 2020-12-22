package com.moda.decorator;

public abstract class CupDecorator implements CupAbility{
    private CupAbility cupAbility;

    public CupDecorator() {
    }

    public CupDecorator(CupAbility cupAbility) {
        this.cupAbility = cupAbility;
    }

    @Override
    public void fillWater() {
        cupAbility.fillWater();
    }
}
