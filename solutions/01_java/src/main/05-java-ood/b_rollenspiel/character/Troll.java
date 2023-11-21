package b_rollenspiel.character;

import b_rollenspiel.items.weapon.melee.Mace;

import java.util.Random;

public class Troll extends Character {
    public Troll(String name) {
        super(name);
        Random rdm = new Random();
        // this calculates a random Initiative value between 1 and 100
        setInitiative(rdm.nextInt(100) + 1);
        setAttackPoints(3.5);
        setStrength(80.5);
    }

    public double getAdditionalAttackPower() {
        double attackDamage = 0;
        if (getActiveWeapon() != null && getActiveWeapon() instanceof Mace) {
            attackDamage += getActiveWeapon().getFightPower() * 2;
        }
        return attackDamage;
    }
}
