package com.simplerpg.character;

public class Archer extends GameChar {

    public Archer(String name) {
        super(name, 120, 25, 20); // speed tinggi
    }

     public Archer(String name, int hp, int attack, int speed) {
        super(name, hp, attack, speed);
    }

    public void attack(GameChar target) {
        System.out.println(getName() + " shoots Arrow!");
        target.takeDamage(attack);
    }
}