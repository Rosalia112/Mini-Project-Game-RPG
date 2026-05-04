package com.simplerpg.item;

import com.simplerpg.character.GameChar;

public abstract class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // method yang harus di-override oleh turunan
    public abstract void use(GameChar target);

    @Override
    public String toString() {
        return name;
    }
}