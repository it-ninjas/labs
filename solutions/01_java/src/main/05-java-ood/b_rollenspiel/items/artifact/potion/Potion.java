package b_rollenspiel.items.artifact.potion;

import b_rollenspiel.items.artifact.Artifact;

public abstract class Potion extends Artifact {
    protected Potion(String description, String name) {
        super(description, 5, name);
    }
}
