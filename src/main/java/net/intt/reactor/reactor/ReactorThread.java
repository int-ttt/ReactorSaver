package net.intt.reactor.reactor;

import net.intt.reactor.Main;
import net.intt.reactor.Reactor;

import java.math.BigInteger;

public class ReactorThread implements Runnable {

    private int degree;
    private final Reactor reactor;

    private int uranium;
    private int controlRod;
    private int system;
    private int generator;
    private int cooler;

    public ReactorThread(Reactor reactor) {
        this.reactor = reactor;
    }

    @Override
    public void run() {
        while (true) {
            uranium = reactor.getUraniumLevel() * 5 + 15;
            cooler = reactor.getCoolerLevel() * 30 + 270;
            controlRod = reactor.getControlRodLevel();
            generator = reactor.getGeneratorLevel() * 2 + 18;
            degree = Math.max(cooler / 60 - uranium / controlRod, -20);
            Main.money = (generator / 2) / controlRod;
            Main.expenditure = reactor.getUraniumLevel() * 100L;
        }
    }

    public int getControlRod() {
        return controlRod;
    }

    public int getCooler() {
        return cooler;
    }

    public int getGenerator() {
        return generator;
    }

    public int getDegree() {
        return degree;
    }

    public int getSystem() {
        return system;
    }

    public int getUranium() {
        return uranium;
    }

    public Reactor getReactor() {
        return reactor;
    }
}
