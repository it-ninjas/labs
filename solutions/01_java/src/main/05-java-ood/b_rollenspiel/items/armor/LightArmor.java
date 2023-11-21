package b_rollenspiel.items.armor;

import java.util.Random;

public class LightArmor extends Armor {

    public LightArmor(String name) {
        super(Math.round((1 + (new Random().nextDouble()) * 20) * 2) / 2.0, name);
        setBlockProbability(0.10);
    }
}
