package b_rollenspiel.items.artifact.potion;

import b_rollenspiel.character.Character;

public class StrengthPotion extends Potion {

    private final double additionalAttackPoints;

    public StrengthPotion(String name) {
        super("This drink makes you feel stronger from just looking at it. Maybe it has a stronger effect if you drink it?", name);
        this.additionalAttackPoints = 5.5f;
    }

    @Override
    public void applyEffect(Character character) {
        character.setAttackPoints(character.getAttackPoints() + additionalAttackPoints);
        character.dropItem(this);
    }
}
