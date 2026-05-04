package com.simplerpg.character;
import com.simplerpg.interfaceGame.SkillUser;

public class Warrior extends GameChar implements SkillUser {
    public Warrior(String name) {
        super(name, 150, 20, 10); // HP besar, attack sedang, speed rendah
    }

    @Override
    public void attack(GameChar target) {
        System.out.println(getName() + " uses Heavy Slash!");
        target.takeDamage(attack);
    }

    @Override
    public void useSkill(GameChar target) {
        System.out.println(getName() + " uses POWER STRIKE!");
        target.takeDamage(attack + 10); // skill lebih sakit
    }
}