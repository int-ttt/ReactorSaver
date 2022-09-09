package net.intt.reactor.reactor;

import net.intt.reactor.Main;
import net.intt.util.LogManager;

public class ReactorWarnThread implements Runnable {

    private final ReactorThread reactor;
    private final LogManager log = Main.log;

    public ReactorWarnThread(ReactorThread reactor) {
        this.reactor = reactor;
    }

    @Override
    public void run() {
        while (true) {
            if (reactor.getDegree() > 200) {
                log.warn("!warning! core degree is so high, core degree: "
                                + reactor.getDegree());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
