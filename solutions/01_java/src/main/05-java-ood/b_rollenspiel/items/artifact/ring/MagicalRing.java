package b_rollenspiel.items.artifact.ring;

import b_rollenspiel.items.artifact.Artifact;

public abstract class MagicalRing extends Artifact {
    protected MagicalRing(String description, String name) {
        super(description, 3, name);
    }
}
