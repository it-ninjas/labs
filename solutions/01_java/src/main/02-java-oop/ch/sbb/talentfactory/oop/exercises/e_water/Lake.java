package ch.sbb.talentfactory.oop.exercises.e_water;

public class Lake {
    private WaterAmount incoming;
    private WaterAmount outgoing;
    private boolean damOpen;

    public Lake(WaterAmount incoming, WaterAmount outgoing, boolean damOpen) {
        this.incoming = incoming;
        this.outgoing = outgoing;
        this.damOpen = damOpen;
    }

    public WaterAmount getIncoming() {
        return incoming;
    }

    public void setIncoming(WaterAmount incoming) {
        this.incoming = incoming;
    }

    public WaterAmount getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(WaterAmount outgoing) {
        this.outgoing = outgoing;
    }

    public boolean isDamOpen() {
        return damOpen;
    }

    public void setDamOpen(boolean damOpen) {
        this.damOpen = damOpen;
    }

    public void checkWaterLevels() {
        if (incoming.convertToL() > outgoing.convertToL()) {
            outgoing.setQuantity(outgoing.getQuantity() + 10000);
            damOpen = true;
        } else {
            damOpen = false;
        }
    }

}
