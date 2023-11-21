package b_rollenspiel;

public enum ItemActionEnum {
    EQUIP("Equip"),
    UNEQUIP("Unequip"),
    APPLY_EFFECT("Apply Effect"),
    DROP_ITEM("Drop Item"),
    BACK("Back");

    private final String label;

    ItemActionEnum(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
