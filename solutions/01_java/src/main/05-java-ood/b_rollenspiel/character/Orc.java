package b_rollenspiel.character;


import b_rollenspiel.items.armor.restriction.HeavyArmorRestriction;

import java.util.Random;

public class Orc extends Character {
    public Orc(String name) {
        super(name);
        setArmorRestriction(new HeavyArmorRestriction());
        Random rdm = new Random();
        // this calculates a random Initiative value between 1 and 100
        setInitiative(rdm.nextInt(100) + 1);
    }

    @Override
    public double getAdditionalAttackPower() {
        double attackDamage = 0;
        if (getLivePoints() <= getMaxLivePoints() / 4) {
            if (getActiveWeapon() != null) {
                attackDamage += (getActiveWeapon().getFightPower() + getAttackPoints()) * 2;
            } else {
                attackDamage += getAttackPoints() * 2;
            }
        }
        return attackDamage;
    }
}
