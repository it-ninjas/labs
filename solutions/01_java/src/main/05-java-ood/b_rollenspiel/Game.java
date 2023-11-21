package b_rollenspiel;

import b_rollenspiel.character.Character;
import b_rollenspiel.character.Elf;
import b_rollenspiel.character.Goblin;
import b_rollenspiel.character.Human;
import b_rollenspiel.character.Orc;
import b_rollenspiel.items.Item;
import b_rollenspiel.items.armor.Armor;
import b_rollenspiel.items.armor.HeavyArmor;
import b_rollenspiel.items.armor.LightArmor;
import b_rollenspiel.items.artifact.Artifact;
import b_rollenspiel.items.artifact.potion.HealthPotion;
import b_rollenspiel.items.artifact.potion.StrengthPotion;
import b_rollenspiel.items.artifact.ring.ProtectionRing;
import b_rollenspiel.items.artifact.ring.StrengthRing;
import b_rollenspiel.items.weapon.MeleeWeapon;
import b_rollenspiel.items.weapon.Weapon;
import b_rollenspiel.items.weapon.melee.Longsword;
import b_rollenspiel.items.weapon.melee.Mace;
import b_rollenspiel.items.weapon.ranged.Bow;
import b_rollenspiel.items.weapon.ranged.Slingshot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final List<Character> players = new ArrayList<>();
    private static final Map<String, List<Item>> groundItemsMap = new HashMap<>();
    private static Character winner;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean wantToPlay = true;
        while (wantToPlay) {
            initializeGame();
            for (int i = 0; i < 20; i++) {
                calculateTurnOrder();
                for (int j = 0; j < players.size(); j++) {
                    Character activePlayer = players.get(j);
                    Character enemy = j == 0 ? players.get(j + 1) : players.get(j - 1);
                    if (i == 0) groundItemsMap.put(activePlayer.getName(), new ArrayList<>());
                    getRandomEvent(activePlayer);
                    listOptions(activePlayer, enemy);
                }

                if (gotWinner()) {
                    break;
                }
            }
            wantToPlay = !endGame();
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    private static void initializeGame() {
        // create players
        Orc orc = new Orc("Hans Ueli");
        Goblin goblin = new Goblin("Ruedi");

        // add to players
        players.add(orc);
        players.add(goblin);
    }

    private static boolean endGame() {
        if (!gotWinner()) {
            winner = getDrawWinner();
        }
        System.out.format("AND THE WINNER IIIIIIIIISSSS ......... %s!!!!", winner.getName().toUpperCase());
        System.out.println();

        while (true) {
            System.out.print("Do you want to play again? (y/N)");
            String answer = scanner.next();
            System.out.println();
            if (answer.equalsIgnoreCase("n") || answer.isEmpty()) {
                break;
            } else if (answer.equalsIgnoreCase("y")) {
                return true;
            } else {
                System.out.println("The input was not valid. Please try again!");
            }
        }
        return false;
    }

    private static Character getDrawWinner() {
        return players.get(0).getLivePoints() >= players.get(1).getMaxLivePoints() ? players.get(0) : players.get(1);
    }

    private static boolean gotWinner() {
        List<Character> alivePlayers = new ArrayList<>();

        for (Character player : players) {
            if (player.getLivePoints() > 0) {
                alivePlayers.add(player);
            }
        }

        if (alivePlayers.size() == 1) {
            winner = alivePlayers.get(0);
            return true;
        }
        return false;
    }

    private static void getRandomEvent(Character activePlayer) {
        Random rdm = new Random();
        double probability = 0.5; // 50% chance for an event to happen
        String playerKey = activePlayer.getName();
        List<Item> groundItemsActivePlayer = groundItemsMap.get(playerKey) != null ? groundItemsMap.get(playerKey) : new ArrayList<>();
        if (rdm.nextDouble() < probability) {
            Item newGroundItem = null;
            switch (rdm.nextInt(5) + 1) {
                case 1 -> {
                    if (rdm.nextInt(100) > 65) {
                        newGroundItem = new HeavyArmor("Heavy Armor");
                    } else {
                        newGroundItem = new LightArmor("Light Armor");
                    }
                    System.out.format("You see a shiny blob of metal in the distance... It seems to be a %s!", newGroundItem.getName());
                }
                case 2 -> {
                    if (rdm.nextInt(100) > 75) {
                        newGroundItem = new StrengthPotion("Potion of Strength");
                    } else {
                        newGroundItem = new HealthPotion("Potion of Healing");
                    }
                    System.out.format("An ugly Witch appears next to you. She offers you a strange looking liquid called %s. Can you trust her?", newGroundItem.getName());
                }
                case 3 -> {
                    if (rdm.nextInt(100) > 70) {
                        newGroundItem = new ProtectionRing("Ring of Protection");
                    } else {
                        newGroundItem = new StrengthRing("Ring of Strength");
                    }
                    System.out.format("While taking a break from your VERY serious fight, a little kid shows you their %s. Do you steal it, so you can win you fight?", newGroundItem.getName());
                }
                case 4 -> {
                    if (rdm.nextInt(100) > 70) {
                        newGroundItem = new Bow(15, 2.8, "Bow of the Forest");
                    } else {
                        newGroundItem = new Slingshot(5, 2.5, "Sling of Prince Bartholomeus");
                    }
                    System.out.format("Down on you knees you find something covered with dirt. Its the %s! Do you take it?", newGroundItem.getName());
                }
                case 5 -> {
                    if (rdm.nextInt(100) > 70) {
                        newGroundItem = new Mace(30, "The Mace of fat Jabba");
                    } else {
                        newGroundItem = new Longsword(20, 3.5, 4.5, "Long Bobs very long Long Sword");
                    }
                    System.out.format("Buried in a corpse of a previous battle you see %s. You should take it into a glorious battle!", newGroundItem.getName());
                }
            }
            groundItemsActivePlayer.add(newGroundItem);
            groundItemsMap.put(playerKey, groundItemsActivePlayer);
            System.out.println();
        }
    }

    private static void calculateTurnOrder() {
        players.sort(Comparator.comparingInt(Character::getInitiative).reversed());
    }

    private static void listOptions(Character player, Character enemy) {
        PlayerActionEnum[] actions = PlayerActionEnum.values();
        boolean active = true;
        while (active) {
            // Print the list of actions with numerical choices
            for (int i = 0; i < actions.length; i++) {
                System.out.println((i + 1) + ". " + actions[i].toString());
            }

            System.out.println("Attacking will end your turn, other actions won't.");
            System.out.print("Choose an action (1-" + actions.length + "): ");

            try {
                // Read user input
                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= actions.length) {
                    switch (actions[choice]) {
                        case ATTACK -> {
                            attackEnemy(player, enemy);
                            active = false;
                        }
                        case USE_ITEM -> {
                            listInventory(player);
                        }
                        case PICKUP_ITEM -> {
                            if (groundItemsMap.get(player.getName()).isEmpty()) {
                                System.out.println("You have not found any Items!");
                                break;
                            }
                            listGroundItems(player);
                        }
                        case CHECK_STATS -> {
                            System.out.println(player.getStats());
                        }
                    }
                } else {
                    System.out.println("Invalid choice. Please choose a valid action.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static void listGroundItems(Character player) {
        List<Item> playerGroundItems = groundItemsMap.get(player.getName());
        boolean active = true;
        while (active) {
            for (int i = 0; i < playerGroundItems.size(); i++) {
                System.out.println(i + 1 + ". " + playerGroundItems.get(i).getName());
            }
            System.out.println(playerGroundItems.size() + 1 + ". Back");

            System.out.format("Choose the item you want to pickup (1-%d): ", playerGroundItems.size() + 1);
            try {
                int choice = scanner.nextInt();

                // return if player choose Back
                if (choice == playerGroundItems.size() + 1) return;

                if (choice >= 1 && choice <= playerGroundItems.size() + 1) {

                    Item itemToPickup = playerGroundItems.get(choice - 1);
                    if (player.hasEnoughInventorySpace(itemToPickup)) {
                        player.addItem(itemToPickup);
                        playerGroundItems.remove(itemToPickup);
                        groundItemsMap.replace(player.getName(), playerGroundItems);
                        System.out.println("You picked up " + itemToPickup.getName());
                    } else {
                        System.out.println("You are to weak to carry that!");
                    }
                    active = false;
                } else {
                    System.out.println("Invalid choice. Please choose a valid action.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }

        }
    }

    private static void listInventory(Character player) {
        List<Item> playerInventory = player.getInventory();
        if (!playerInventory.isEmpty()) {
            while (true) {
                for (int i = 0; i < playerInventory.size(); i++) {
                    System.out.println((i + 1) + ". " + playerInventory.get(i).getName());
                }
                System.out.println(playerInventory.size() + 1 + ". Back");
                System.out.print("Choose the item that you want to interact with (1-" + (playerInventory.size() + 1) + "): ");

                try {
                    // Read user input
                    int choice = scanner.nextInt();

                    if (choice >= 1 && choice <= playerInventory.size() + 1) {
                        if (choice == playerInventory.size() + 1) {
                            break;
                        }
                        listItemInteractions(player, playerInventory.get(choice - 1));
                        break;
                    } else {
                        System.out.println("Invalid choice. Please choose a valid action.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                }
            }
        } else {
            System.out.println("Your Inventory is empty! Please choose your next action.");
        }
    }

    private static void listItemInteractions(Character player, Item item) {
        List<ItemActionEnum> actions = new ArrayList<>();
        if (item instanceof Armor || item instanceof Weapon) {
            if (item == player.getActiveArmor() || item == player.getActiveWeapon()) {
                actions.add(ItemActionEnum.UNEQUIP);
            } else {
                actions.add(ItemActionEnum.EQUIP);
            }
        } else if (item instanceof Artifact) {
            actions.add(ItemActionEnum.APPLY_EFFECT);
        }
        actions.add(ItemActionEnum.DROP_ITEM);
        actions.add(ItemActionEnum.BACK);
        boolean active = true;
        while (active) {
            for (int i = 0; i < actions.size(); i++) {
                System.out.println((i + 1) + ". " + actions.get(i).toString());
            }
            System.out.print("Choose your interaction (1-" + (actions.size() + 1) + "): ");
            try {
                // Read user input
                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= actions.size() + 1) {
                    if (choice == actions.size() + 1) {
                        return;
                    }
                    switch (actions.get(choice - 1)) {
                        case EQUIP, UNEQUIP -> {
                            player.toggleActiveItem(item);
                        }
                        case DROP_ITEM -> {
                            player.dropItem(item);
                        }
                        case APPLY_EFFECT -> {
                            assert item instanceof Artifact;
                            ((Artifact) item).applyEffect(player);
                        }
                    }
                    active = false;
                } else {
                    System.out.println("Invalid choice. Please choose a valid action.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    public static void attackEnemy(Character player, Character enemy) {
        Random rdm = new Random();
        double damage = Math.round((player.getFightPoint() * (0.9 + rdm.nextDouble() * 0.2)) / 0.05) * 0.05;
        applyDamage(enemy, damage);
    }

    private static void applyDamage(Character player, double damage) {
        Random rdm = new Random();
        double additionalProtection = 0;
        Weapon activeWeapon = player.getActiveWeapon();
        if (activeWeapon instanceof MeleeWeapon) {
            additionalProtection = ((MeleeWeapon) activeWeapon).getDefencePower();
        }
        double fullDamage = damage - (player.getProtection() + additionalProtection);
        if (player instanceof Orc) {
            if (player.getLivePoints() <= player.getMaxLivePoints() / 4) {
                fullDamage = fullDamage / 2;
            }
        }
        double randomDouble = rdm.nextDouble();
        // applies damage if the player has no armor or the random double value is smaller than the blockProbability of the armor
        if (player.getActiveArmor() == null || player.getActiveArmor().getBlockProbability() < randomDouble) {
            player.setLivePoints(player.getLivePoints() - fullDamage);
            System.out.println("You have dealt " + fullDamage + " to " + player.getName() + "!");
        } else {
            System.out.println(player.getName() + " has blocked the attack!");
        }
    }
}
