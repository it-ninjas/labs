package b_rollenspiel.items.artifact;

import b_rollenspiel.character.Character;
import b_rollenspiel.items.Item;

public abstract class Artifact extends Item {
    private final String description;

    protected Artifact(String description, double weight, String name) {
        super(weight, name);
        this.description = description;
    }

    public abstract void applyEffect(Character character);

    public String getDescription() {
        return description;
    }
}
