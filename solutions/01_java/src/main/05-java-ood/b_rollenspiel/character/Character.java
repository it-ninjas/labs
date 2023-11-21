package b_rollenspiel.character;

import b_rollenspiel.items.Item;
import b_rollenspiel.items.armor.Armor;
import b_rollenspiel.items.armor.HeavyArmor;
import b_rollenspiel.items.armor.restriction.ArmorRestriction;
import b_rollenspiel.items.armor.restriction.UnarmoredRestriction;
import b_rollenspiel.items.artifact.ring.MagicalRing;
import b_rollenspiel.items.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final double maxLivePoints;
    private final List<Item> inventory;
    private final String name;
    private double livePoints;
    private double attackPoints;
    private double strength;
    private Weapon activeWeapon;
    private Armor activeArmor;
    private double protection;
    private ArmorRestriction armorRestriction;
    private int initiative;

    protected Character(String name) {
        this.maxLivePoints = livePoints;
        this.inventory = new ArrayList<>();
        this.name = name;
        this.livePoints = 50;
        this.attackPoints = 1;
        this.strength = 100;
        this.activeWeapon = null;
        this.activeArmor = null;
        this.protection = 0;
        this.armorRestriction = new UnarmoredRestriction();
        this.initiative = 0;
    }

    // Methods
    public boolean hasEnoughInventorySpace(Item item) {
        return getInventoryWeight() + item.getWeight() <= strength;
    }

    private double getInventoryWeight() {
        double inventorySize = 0;
        for (Item item : inventory) {
            inventorySize += item.getWeight();
        }
        return inventorySize;
    }

    public void addItem(Item item) {
        if (hasEnoughInventorySpace(item)) {
            inventory.add(item);
            if (item instanceof MagicalRing) {
                ((MagicalRing) item).applyEffect(this);
            }
        } else {
            System.out.println("You are to weak to carry that!");
        }
    }

    public void dropItem(Item item) {
        if (item instanceof Weapon && activeWeapon == item) unequipWeapon();
        if (item instanceof Armor && activeArmor == item) unequipArmor();
        inventory.remove(item);
    }

    public void toggleActiveItem(Item item) {
        if (item instanceof Armor) {
            if (item == activeArmor) {
                unequipArmor();
            } else {
                equipArmor((Armor) item);
            }
        } else if (item instanceof Weapon) {
            if (item == activeWeapon) {
                unequipWeapon();
            } else {
                equipWeapon((Weapon) item);
            }
        }
    }

    public void equipWeapon(Weapon weapon) {
        if (inventory.contains(weapon)) {
            setActiveWeapon(weapon);
        } else if (hasEnoughInventorySpace(weapon)) {
            addItem(weapon);
            setActiveWeapon(weapon);
        } else {
            System.out.println("you do not have enough space in your inventory for this item.");
        }
    }

    public void equipArmor(Armor armor) {
        if (canWearArmor(armor)) {
            if (inventory.contains(armor)) {
                setActiveArmor(armor);
            } else if (hasEnoughInventorySpace(armor)) {
                addItem(armor);
                setActiveArmor(armor);
            } else {
                System.out.println("you do not have enough space in your inventory for this item.");
            }
        } else {
            System.out.println("you to small my friend");
        }
    }

    public void unequipWeapon() {
        setActiveWeapon(null);
    }

    public void unequipArmor() {
        setActiveWeapon(null);
    }

    public boolean canWearArmor(Armor armor) {
        return armorRestriction.canWearArmor(armor);
    }

    public double getFightPoint() {
        double attackDamage = 0;
        if (getActiveWeapon() != null) {
            attackDamage += getActiveWeapon().getFightPower();
        }
        attackDamage += getAttackPoints();
        attackDamage += getAdditionalAttackPower();
        return attackDamage;
    }

    public String getStats() {
        String stats = "Current Weapon: " +
                (getActiveWeapon() != null ? getActiveWeapon().getName() : "No Weapon selected") +
                "\n" +
                "Current Armor: " +
                (getActiveArmor() != null ? getActiveArmor().getName() : "No Armor selected") +
                "\n" +
                "Health: " +
                getLivePoints() +
                "/" +
                getMaxLivePoints() +
                "\n" +
                "Attackdamage: " +
                getFightPoint() +
                "\n" +
                "Protection: " +
                getProtection() +
                "\n" +
                "Inventory Space: " +
                getInventoryWeight() +
                "/" +
                getStrength();
        return stats;
    }

    public int getInitiative() {
        if (activeArmor instanceof HeavyArmor) {
            return (int) (initiative - Math.floor(activeArmor.getWeight() / 2));
        }
        return initiative;
    }

    // generated Getters and Setters
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public double getAdditionalAttackPower() {
        return 0;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setArmorRestriction(ArmorRestriction armorRestriction) {
        this.armorRestriction = armorRestriction;
    }

    public Armor getActiveArmor() {
        return activeArmor;
    }

    public void setActiveArmor(Armor activeArmor) {
        this.activeArmor = activeArmor;
    }

    public Weapon getActiveWeapon() {
        return activeWeapon;
    }

    public void setActiveWeapon(Weapon activeWeapon) {
        this.activeWeapon = activeWeapon;
    }

    public double getProtection() {
        return protection;
    }

    public void setProtection(double protection) {
        this.protection = protection;
    }

    public double getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public String getName() {
        return name;
    }

    public double getLivePoints() {
        return livePoints;
    }

    public void setLivePoints(double livePoints) {
        this.livePoints = livePoints;
    }

    public double getMaxLivePoints() {
        return maxLivePoints;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

}
