package net.intt.reactor.util;

import net.intt.util.Printer;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

import java.io.OutputStream;

public class JlineStream extends OutputStream implements Printer {

    private final LineReader reader;

    public JlineStream(LineReader reader) {
        this.reader = reader;
    }

    @Override
    public void print(Object x) {
        if (reader.isReading()) {
            reader.callWidget(LineReader.CLEAR);
            reader.getTerminal().writer().print(x);
            reader.callWidget(LineReader.REDRAW_LINE);
            reader.callWidget(LineReader.REDISPLAY);
        } else reader.getTerminal().writer().print(x);
        reader.getTerminal().writer().flush();
    }

    @Override
    public void println(Object x) {
        if (reader.isReading()) {
            reader.callWidget(LineReader.CLEAR);
            reader.getTerminal().writer().println(x);
            reader.callWidget(LineReader.REDRAW_LINE);
            reader.callWidget(LineReader.REDISPLAY);
        } else reader.getTerminal().writer().println(x);
        reader.getTerminal().flush();
    }

    public void println() {
        if (reader.isReading()) {
            reader.callWidget(LineReader.CLEAR);
            reader.getTerminal().writer().println();
            reader.callWidget(LineReader.REDRAW_LINE);
            reader.callWidget(LineReader.REDISPLAY);
        } else reader.getTerminal().writer().println();
    }

    @Override
    public void write(int b) {
        if (reader.isReading()) {
            reader.callWidget(LineReader.CLEAR);
            reader.getTerminal().writer().write(b);
            reader.callWidget(LineReader.REDRAW_LINE);
            reader.callWidget(LineReader.REDISPLAY);
        } else reader.getTerminal().writer().write(b);
    }
}
