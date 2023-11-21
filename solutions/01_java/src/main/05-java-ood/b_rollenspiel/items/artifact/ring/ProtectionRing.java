package b_rollenspiel.items.artifact.ring;

import b_rollenspiel.character.Character;

public class ProtectionRing extends MagicalRing {
    private final double protection;

    public ProtectionRing(String name) {
        super("With this ring you will experience more protection from enemy forces.", name);
        this.protection = 10.5f;
    }

    @Override
    public void applyEffect(Character character) {
        character.setProtection(character.getProtection() + protection);
    }
}
