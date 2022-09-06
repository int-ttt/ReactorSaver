package net.intt.reactor.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public final class Util {
    private static Util ourInstance = null;

    public synchronized static Util getInstance() {

        if (ourInstance == null) {
            ourInstance = new Util();
        }

        return ourInstance;
    }

    private Util() {}

    private JSONParser jsonParser = new JSONParser();

    public JSONParser JSONParser() {
        return jsonParser;
    }

    public int uraniumPrice() {
        return 200;
    }
}
