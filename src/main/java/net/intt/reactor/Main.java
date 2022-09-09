package net.intt.reactor;

import net.intt.reactor.reactor.ReactorThread;
import net.intt.reactor.reactor.ReactorWarnThread;
import net.intt.reactor.reactor.TerminalThread;
import net.intt.reactor.thread.SaveThread;
import net.intt.reactor.util.JlineStream;
import net.intt.reactor.util.Util;
import net.intt.util.LogManager;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static long money;
    public static long expenditure;
    public static Reactor reactor;

    public static File dataFile = fileSetup();

    public static final LineReader reader = LineReaderBuilder.builder().terminal(terminal()).build();


    private static Terminal terminal() {
        try {
            return TerminalBuilder.builder().jansi(true).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final LogManager log = new LogManager("reactor system", new JlineStream(reader));

    public static void main(String[] args) throws IOException, ParseException {

        JSONObject json = (JSONObject) ((JSONObject) Util.getInstance().JSONParser().parse(new FileReader(dataFile))).get("reactor");

        reactor = new Reactor(
                (int) ((long) json.get("uranium")), (int) ((long) json.get("control")), (int) ((long) json.get("system")),
                (int) ((long) json.get("cooler")), (int) ((long) json.get("generator")), (int) ((long) json.get("core")));
        ReactorThread reactorThread = new ReactorThread(reactor);

        SaveThread.setTime(10);

        new Thread(reactorThread).start();
        new Thread(new ReactorWarnThread(reactorThread)).start();
        new Thread(new SaveThread()).start();
        new Thread(new TerminalThread(reactorThread)).start();
    }

    public static String OSCheck() {
        String FileFolder;

        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("WIN")) {
            FileFolder = System.getenv("APPDATA") + "\\" + "Launcher";
        }
        else if (os.contains("MAC")) {
            FileFolder = System.getProperty("user.home") + "/Library/Application Support";
        }
        else if (os.contains("NUX")) {
            FileFolder = System.getProperty("user.dir") + ".Launcher";
        }
        else {
            System.exit(-1);
            FileFolder = "";
        }
        return FileFolder;
    }

    private static File fileSetup(){
        File file;
        try {
            file = fileSetup(0);
        } catch (IOException e) {
            file = null;
        }
        return file;
    }

    private static File fileSetup(int i) throws IOException {
        File file = new File(OSCheck() + "/ReactorSaver/data.json");
        if (i==1) file = new File("data.json");
        JSONObject json = new JSONObject();
        if (file.createNewFile()) {
            System.out.println(1);
            json.put("reactorAppend","");
            json.put("money","20000");
            JSONObject reactorObject = new JSONObject();
            reactorObject.put("cooler",1);
            reactorObject.put("control",1);
            reactorObject.put("uranium",1);
            reactorObject.put("system",1);
            reactorObject.put("generator",1);
            reactorObject.put("core", 1);
            json.put("reactor", reactorObject);
            FileWriter writer = new FileWriter(file);
            writer.write(json.toJSONString());
            writer.flush();
            writer.close();
        }
        return file;
    }
}
