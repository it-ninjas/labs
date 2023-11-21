package b_rollenspiel.items.weapon;

import b_rollenspiel.items.Item;

public class Weapon extends Item {
    private final double attackPower;

    protected Weapon(double weight, double attackPower, String name) {
        super(weight, name);
        this.attackPower = attackPower;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public double getFightPower() {
        return attackPower;
    }
}
