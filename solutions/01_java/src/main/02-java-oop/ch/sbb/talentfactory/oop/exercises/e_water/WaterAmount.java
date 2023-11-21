package ch.sbb.talentfactory.oop.exercises.e_water;

public class WaterAmount {
    private double quantity;
    private String unit;

    public WaterAmount(double quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double convertToL() {
        double amount = quantity;
        switch (unit.toLowerCase()) {
            case "dl":
                amount = amount / 10;
                break;
            case "cl":
                amount = amount / 100;
                break;
            case "ml":
                amount = amount / 1000;
                break;
            case "hl":
                amount = amount * 100;
                break;
            case "l":
            case "m^3":
                break;
            default:
                System.out.println("Incorrect unit provided!");
                break;
        }
        return amount;
    }
}
