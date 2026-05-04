package com.simplerpg.item;

import com.simplerpg.character.GameChar;

public class Potion extends Item {
    private int healAmount;

    public Potion(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    @Override
    public void use(GameChar target) {
        System.out.println(target.getName() + " uses " + name + " and heals " + healAmount + " HP!");
    
        target.heal(healAmount);
    }
}