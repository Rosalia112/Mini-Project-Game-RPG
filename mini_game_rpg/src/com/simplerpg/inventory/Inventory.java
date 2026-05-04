package com.simplerpg.inventory;

import java.util.ArrayList;

public class Inventory<T> {
    private ArrayList<T> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println(item + " berhasil ditambahkan ke inventory.");
    }

    public void removeItem(T item) {
        if (items.remove(item)) {
            System.out.println(item + " berhasil digunakan/dihapus dari inventory.");
        } else {
            System.out.println(item + " tidak ditemukan di inventory.");
        }
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory kosong.");
            return;
        }

        System.out.println("Isi Inventory:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }

        return null;
    }

    public int getSize() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}