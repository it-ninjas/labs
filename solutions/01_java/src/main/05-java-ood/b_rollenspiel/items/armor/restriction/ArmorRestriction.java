package b_rollenspiel.items.armor.restriction;

import b_rollenspiel.items.armor.Armor;

public interface ArmorRestriction {
    boolean canWearArmor(Armor armor);
}
