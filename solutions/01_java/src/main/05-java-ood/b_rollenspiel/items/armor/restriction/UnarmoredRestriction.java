package b_rollenspiel.items.armor.restriction;

import b_rollenspiel.items.armor.Armor;

public class UnarmoredRestriction implements ArmorRestriction {
    @Override
    public boolean canWearArmor(Armor armor) {
        return false;
    }
}
