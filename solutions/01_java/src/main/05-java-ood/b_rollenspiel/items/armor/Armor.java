package b_rollenspiel.items.armor;

import b_rollenspiel.items.Item;

public abstract class Armor extends Item {
    private double blockProbability;

    protected Armor(double weight, String name) {
        super(weight, name);
    }

    public double getBlockProbability() {
        return blockProbability;
    }

    protected void setBlockProbability(double blockProbability) {
        this.blockProbability = blockProbability;
    }
}
