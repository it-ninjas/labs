package b_rollenspiel.character;

import b_rollenspiel.items.armor.restriction.HeavyArmorRestriction;

import java.util.Random;

public class Dwarf extends Character {
    public Dwarf(String name) {
        super(name);
        setArmorRestriction(new HeavyArmorRestriction());
        Random rdm = new Random();
        // this calculates a random Initiative value between 1 and 100
        setInitiative(rdm.nextInt(100) + 1);
    }
}
