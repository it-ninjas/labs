package b_rollenspiel.items.artifact.ring;

import b_rollenspiel.character.Character;

public class StrengthRing extends MagicalRing {
    private final double additionalStrength;

    public StrengthRing(String name) {
        super("This super duper cool ring gives you additional strength so you can carry even more unnecessary stuff.", name);
        this.additionalStrength = 20.5;
    }

    @Override
    public void applyEffect(Character character) {
        character.setStrength(character.getStrength() + additionalStrength);
    }
}
