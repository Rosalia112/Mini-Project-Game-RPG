package com.simplerpg.character;

public class Mage extends GameChar {

    public Mage(String name) {
        super(name, 100, 30, 15); // HP kecil, attack besar
    }

    public Mage(String name, int hp, int attack, int speed) {
        super(name, hp, attack, speed);
    }

    public void attack(GameChar target) {
        System.out.println(getName() + " casts Fireball!");
        target.takeDamage(attack);
    }
}