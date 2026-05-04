package com.simplerpg.character;

import com.simplerpg.inventory.Inventory;
import com.simplerpg.item.Item;

public class Player {
    private GameChar character;
    private Inventory<Item> inventory;

    public Player(GameChar character) {
        this.character = character;
        this.inventory = new Inventory<>();
    }

    public GameChar getCharacter() {
        return character;
    }

    public void showStatus() {
        character.showStatus();
    }

    public void attack(GameChar target) {
        character.attack(target);
    }

    public Inventory<Item> getInventory() {
        return inventory;
    }
}