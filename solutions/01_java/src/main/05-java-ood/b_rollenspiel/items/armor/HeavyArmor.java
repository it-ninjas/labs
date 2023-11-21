package b_rollenspiel.items.armor;

import java.util.Random;

public class HeavyArmor extends Armor {
    public HeavyArmor(String name) {
        super(Math.round((2 + (new Random().nextDouble()) * 30) * 2) / 2.0, name);
        setBlockProbability(0.20);
    }
}
