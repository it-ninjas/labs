package b_rollenspiel.character;

import b_rollenspiel.items.armor.restriction.LightArmorRestriction;
import b_rollenspiel.items.weapon.RangedWeapon;

import java.util.Random;


public class Goblin extends Character {
    public Goblin(String name) {
        super(name);
        setArmorRestriction(new LightArmorRestriction());
        Random rdm = new Random();
        // this calculates a random Initiative value between 1 and 100
        setInitiative(rdm.nextInt(100) + 1);
        setAttackPoints(2.5);
    }

    @Override
    public double getAdditionalAttackPower() {
        double attackDamage = 0;
        if (getActiveWeapon() != null && getActiveWeapon() instanceof RangedWeapon) {
            attackDamage += getActiveWeapon().getFightPower() * 0.5;
        }
        return attackDamage;
    }
}
