package b_rollenspiel;

public enum PlayerActionEnum {
    ATTACK("Attack"),
    USE_ITEM("Use Item"),
    PICKUP_ITEM("Pickup Item"),
    CHECK_STATS("Check your Stats");

    private final String label;

    PlayerActionEnum(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
