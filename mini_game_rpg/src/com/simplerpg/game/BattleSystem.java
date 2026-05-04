package com.simplerpg.game;

import com.simplerpg.character.Enemy;
import com.simplerpg.character.GameChar;
import com.simplerpg.character.Player;
import com.simplerpg.interfaceGame.SkillUser;
import com.simplerpg.item.Item;
import java.util.Scanner;

public class BattleSystem {
    private Scanner scanner;

    public BattleSystem() {
        scanner = new Scanner(System.in);
    }

    public void startBattle(Player player, Enemy enemy) {
        GameChar playerChar = player.getCharacter();

        System.out.println("\n=== BATTLE START ===");
        System.out.println(playerChar.getName() + " VS " + enemy.getName());

        while (playerChar.isAlive() && enemy.isAlive()) {
            System.out.println("\n--- Status ---");
            playerChar.showStatus();
            enemy.showStatus();

            if (playerChar.getSpeed() >= enemy.getSpeed()) {
                playerTurn(player, enemy);
                if (enemy.isAlive()) {
                    enemyTurn(enemy, playerChar);
                }
            } else {
                enemyTurn(enemy, playerChar);
                if (playerChar.isAlive()) {
                    playerTurn(player, enemy);
                }
            }
        }

        if (playerChar.isAlive()) {
            System.out.println("\nKamu menang!");
        } else {
            System.out.println("\nKamu kalah!");
        }
    }

    private void playerTurn(Player player, Enemy enemy) {
        GameChar playerChar = player.getCharacter();

        System.out.println("\nGiliran kamu!");
        System.out.println("1. Attack");
        System.out.println("2. Skill");
        System.out.println("3. Item");
        System.out.print("Pilih aksi: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                playerChar.attack(enemy);
                break;

            case 2:
                if (playerChar instanceof SkillUser) {
                    ((SkillUser) playerChar).useSkill(enemy);
                } else {
                    System.out.println("Karakter ini tidak punya skill.");
                }
                break;

            case 3:
                useItem(player);
                break;

            default:
                System.out.println("Pilihan tidak valid, kamu kehilangan giliran.");
                break;
        }
    }

    private void enemyTurn(Enemy enemy, GameChar playerChar) {
        System.out.println("\nGiliran musuh!");
        enemy.attack(playerChar);
    }

    private void useItem(Player player) {
        if (player.getInventory().isEmpty()) {
            System.out.println("Inventory kosong!");
            return;
        }

        player.getInventory().showItems();
        System.out.print("Pilih item: ");
        int itemChoice = scanner.nextInt();

        Item selectedItem = player.getInventory().getItem(itemChoice - 1);

        if (selectedItem != null) {
            selectedItem.use(player.getCharacter());
            player.getInventory().removeItem(selectedItem);
        } else {
            System.out.println("Item tidak valid.");
        }
    }
}