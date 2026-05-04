package com.simplerpg.character;

public class Enemy extends GameChar {

    public Enemy(String name, int hp, int attack, int speed) {
        super(name, hp, attack, speed);
    }

    @Override
    public void attack(GameChar target) {
        System.out.println(getName() + " menyerang " + target.getName() + "!");
        target.takeDamage(getAttack());
    }
}