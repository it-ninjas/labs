package b_rollenspiel.character;

import b_rollenspiel.items.armor.restriction.LightArmorRestriction;
import b_rollenspiel.items.weapon.RangedWeapon;

import java.util.Random;


public class Elf extends Character {
    private final double magicPower;

    public Elf(String name, double magicPower) {
        super(name);
        this.magicPower = magicPower;
        setArmorRestriction(new LightArmorRestriction());
        setAttackPoints(getAttackPoints() + magicPower / 2);
        Random rdm = new Random();
        // this calculates a random Initiative value between 1 and 100
        setInitiative(rdm.nextInt(100) + 1);
    }

    @Override
    public double getAdditionalAttackPower() {
        double attackDamage = 0;
        if (getActiveWeapon() != null && getActiveWeapon() instanceof RangedWeapon) {
            attackDamage += getActiveWeapon().getFightPower() * 0.5;
        }
        attackDamage += magicPower / 2;
        return attackDamage;
    }
}
