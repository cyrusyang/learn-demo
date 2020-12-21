package com.moda.decorator;

import lombok.Data;

@Data
public class Cup implements CupAbility{

    @Override
    public void fillWater() {
        System.out.println("装水========");
    }
}
