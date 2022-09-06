package net.intt.reactor.reactor;

import net.intt.reactor.Main;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

public class TerminalThread implements Runnable {

    private LineReader reader = Main.reader;

    @Override
    public void run() {
        while (true) {
            reader.readLine();
        }
    }
}
