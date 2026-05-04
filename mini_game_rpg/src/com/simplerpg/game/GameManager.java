package com.simplerpg.game;

import com.simplerpg.character.Archer;
import com.simplerpg.character.Enemy;
import com.simplerpg.character.GameChar;
import com.simplerpg.character.Mage;
import com.simplerpg.character.Player;
import com.simplerpg.character.Warrior;
import com.simplerpg.item.Potion;
import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private Scanner scanner;
    private ArrayList<GameChar> characterList;

    public GameManager() {
        scanner = new Scanner(System.in);
        characterList = new ArrayList<>();
    }

    public void startGame() {
        System.out.println("=== SIMPLE RPG GAME ===");

        setupCharacters();

        GameChar chosenCharacter = chooseCharacter();
        Player player = new Player(chosenCharacter);

        player.getInventory().addItem(new Potion("Small Potion", 30));
        player.getInventory().addItem(new Potion("Big Potion", 50));

        Enemy enemy = new Enemy("Goblin", 100, 15, 8);

        BattleSystem battleSystem = new BattleSystem();
        battleSystem.startBattle(player, enemy);
    }

    private void setupCharacters() {
        characterList.add(new Warrior("Arthur"));
        characterList.add(new Mage("Merlin"));
        characterList.add(new Archer("Robin"));
        characterList.add(new Mage("Rosa", 180, 90, 20));
    }

    private GameChar chooseCharacter() {
        System.out.println("\nPilih karakter:");

        for (int i = 0; i < characterList.size(); i++) {
            System.out.print((i + 1) + ". ");
            characterList.get(i).showStatus();
        }

        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > characterList.size()) {
            System.out.println("Pilihan tidak valid, otomatis memilih Warrior.");
            return characterList.get(0);
        }

        return characterList.get(choice - 1);
    }
}