package ch.sbb.talentfactory.oop.exercises.e_water;

public class Main {
    public static void main(String[] args) {
        Lake bodensee = new Lake(new WaterAmount(10000, "L"), new WaterAmount(2000, "Hl"), false);
        // The Dam should be closed
        bodensee.checkWaterLevels();
        System.out.println("The dam is currently " + (bodensee.isDamOpen() ? "open." : "closed."));

        // change data so the dam needs to be opened
        WaterAmount newBodenseeIncoming = bodensee.getIncoming();
        newBodenseeIncoming.setUnit("hl");
        bodensee.setIncoming(newBodenseeIncoming);

        // the dam should be open
        bodensee.checkWaterLevels();
        System.out.println("The dam is currently " + (bodensee.isDamOpen() ? "open." : "closed."));
    }
}
