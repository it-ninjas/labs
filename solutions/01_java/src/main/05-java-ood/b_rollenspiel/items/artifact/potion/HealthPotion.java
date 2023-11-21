package b_rollenspiel.items.artifact.potion;

import b_rollenspiel.character.Character;

public class HealthPotion extends Potion {
    private final double regeneration;

    public HealthPotion(String name) {
        super("The smell of this fluid reminds you of your grandma's cooking and love. Will it regenerate your will to continue the battle?", name);
        this.regeneration = 10.5;
    }

    public double getRegeneration() {
        return regeneration;
    }

    @Override
    public void applyEffect(Character character) {
        double currentLivePoints = character.getLivePoints();
        // This returns the smaller of the two, so currentLP can never overgrow maxLP
        character.setLivePoints(Math.min(currentLivePoints + regeneration, character.getMaxLivePoints()));
        character.dropItem(this);
    }
}
