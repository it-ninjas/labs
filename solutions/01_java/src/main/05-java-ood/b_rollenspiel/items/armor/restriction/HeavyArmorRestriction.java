package b_rollenspiel.items.armor.restriction;

import b_rollenspiel.items.armor.Armor;
import b_rollenspiel.items.armor.HeavyArmor;
import b_rollenspiel.items.armor.LightArmor;

public class HeavyArmorRestriction implements ArmorRestriction {
    @Override
    public boolean canWearArmor(Armor armor) {
        return armor instanceof HeavyArmor || armor instanceof LightArmor;
    }
}
