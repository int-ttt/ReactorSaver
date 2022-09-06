package net.intt.reactor;

public class Reactor {
    private int uraniumLevel;
    private int controlRodLevel;
    private int systemLevel;
    private int coolerLevel;
    private int generatorLevel;
    private int reactorCoreLevel;

    public Reactor(int uraniumLevel, int controlRodLevel, int systemLevel, int coolerLevel, int generatorLevel, int reactorCoreLevel) {
        this.uraniumLevel = uraniumLevel;
        this.controlRodLevel = controlRodLevel;
        this.systemLevel = systemLevel;
        this.coolerLevel = coolerLevel;
        this.generatorLevel = generatorLevel;
        this.reactorCoreLevel = reactorCoreLevel;
    }

    public void addControlRodLevel() {
        this.controlRodLevel++;
    }

    public void setSystemLevel() {
        this.systemLevel++;
    }
    public void addCoolerLevel() {
        this.coolerLevel++;
    }

    public void addGeneratorLevel() {
        this.generatorLevel++;
    }

    public void addUraniumLevel() {
        this.uraniumLevel++;
    }

    public void addReactorCoreLevel() {
        this.reactorCoreLevel++;
    }

    public int getControlRodLevel() {
        return controlRodLevel;
    }

    public int getSystemLevel() {
        return systemLevel;
    }

    public int getCoolerLevel() {
        return coolerLevel;
    }

    public int getGeneratorLevel() {
        return generatorLevel;
    }

    public int getUraniumLevel() {
        return uraniumLevel;
    }

    public int getReactorCoreLevel() {
        return reactorCoreLevel;
    }
}
