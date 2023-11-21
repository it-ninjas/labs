package b_rollenspiel.items.weapon;

public class MeleeWeapon extends Weapon {
    private final double defencePower;

    public MeleeWeapon(double weight, double attackPower, double defencePower, String name) {
        super(weight, attackPower, name);
        this.defencePower = defencePower;
    }

    public double getDefencePower() {
        return defencePower;
    }

    @Override
    public double getFightPower() {
        return getAttackPower() + defencePower / 2;
    }
}
