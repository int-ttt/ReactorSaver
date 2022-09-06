package net.intt.reactor;

import net.intt.reactor.reactor.ReactorThread;
import net.intt.reactor.reactor.TerminalThread;
import net.intt.reactor.util.JlineStream;
import net.intt.reactor.util.Util;
import net.intt.util.LogManager;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static BigInteger money;
    public static BigInteger expenditure;
    public static Reactor reactor;

    public static File dataFile;

    public static final LineReader reader = LineReaderBuilder.builder().build();
    
    public static final LogManager log = new LogManager("reactor system", new JlineStream(reader));

    public static void main(String[] args) throws IOException, ParseException {

        if (args[0].equals("test")) {
            dataFile = fileSetup(1);
        } else dataFile = fileSetup();

        JSONObject json = (JSONObject) Util.getInstance().JSONParser().parse(dataFile.getPath());

        reactor = new Reactor(
                (int) json.get("uranium"), (int) json.get("control"), (int) json.get("system"),
                (int) json.get("cooler"), (int) json.get("generator"), (int) json.get("core"));

        ReactorThread reactor = new ReactorThread();
        new Thread(reactor).start();
        new Thread(new TerminalThread(reactor)).start();
    }

    public static String OSCheck() {
        String FileFolder;

        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("WIN")) {
            FileFolder = System.getenv("APPDATA") + "\\" + "Launcher";
        }
        else if (os.contains("MAC")) {
            FileFolder = System.getProperty("user.home") + "/Library/Application Support"
                    + "Launcher";
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

    private static File fileSetup() throws IOException {
        return fileSetup(0);
    }

    private static File fileSetup(int i) throws IOException {
        File file;
        if (i!=1) file = new File(OSCheck() + "/ReactorSaver/data.json");
        else file = new File("data.json");
        JSONObject json = new JSONObject();
        if (file.createNewFile()) {
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
        } else {
            try {
                json = (JSONObject) Util.getInstance().JSONParser().parse(file.getPath());
            } catch (ParseException e) {
            }
        }
        return file;
    }
}
