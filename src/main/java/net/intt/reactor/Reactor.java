package net.intt.reactor;

public class Reactor {
    private int uraniumLevel;
    private int controlRodLevel;
    private int systemLevel;
    private int coolerLevel;
    private int generatorLevel;

    public Reactor(int uraniumLevel, int controlRodLevel, int systemLevel, int coolerLevel, int generatorLevel) {
        this.uraniumLevel = uraniumLevel;
        this.controlRodLevel = controlRodLevel;
        this.systemLevel = systemLevel;
        this.coolerLevel = coolerLevel;
        this.generatorLevel = generatorLevel;
    }

    public int getControlRodLevel() {
        return controlRodLevel * 2 + 5;
    }

    public int getSystemLevel() {
        return systemLevel + 1;
    }

    public int getCoolerLevel() {
        return coolerLevel + 1;
    }

    public int getGeneratorLevel() {
        return generatorLevel + 1;
    }

    public int getUraniumLevel() {
        return uraniumLevel + 1;
    }
}
