package net.intt.reactor.reactor;

import net.intt.reactor.Main;
import net.intt.util.LogManager;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

import java.lang.reflect.Field;

public class TerminalThread implements Runnable {

    private final LineReader reader = Main.reader;
    private final LogManager log = Main.log;
    private final ReactorThread thread;

    public TerminalThread(ReactorThread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        String arg;
        String[] args;
        while (true) {
            arg = reader.readLine(
                    "<\u001B[31mReactorDegree: "
                            + thread.getDegree() +
                            "°C \u001B[0m|\u001B[32m uranium usage: "
                            + thread.getReactor().getUraniumLevel()
                            + "kg/h\u001B[0m> reactor$ ");
            args = arg.split("\\s");

            switch (args[0]) {
                case "quit", "leave" -> System.exit( 0);
                case "statistics" -> {
                    log.info("Uranium usage: "
                                    + thread.getReactor().getUraniumLevel()
                                    + "kg/h");
                    log.info("ControlRod class: "
                                    + thread.getReactor().getControlRodLevel());
                    log.info("s");
                }
            }
        }
    }
}
