package com.simplerpg.character;

import com.simplerpg.interfaceGame.Attackable;

public abstract class GameChar implements Attackable{
    private String name;
    protected int hp;
    protected int attack;
    protected int speed;

    public GameChar(String name, int hp, int attack, int speed) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void showStatus() {
        System.out.println(name + " | HP: " + hp + " | ATK: " + attack + " | SPD: " + speed);
    
    }

    public void heal(int amount) {
        hp += amount;
    }
    
}