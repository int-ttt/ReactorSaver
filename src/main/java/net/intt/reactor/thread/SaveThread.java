package net.intt.reactor.thread;

import net.intt.reactor.Main;
import org.json.simple.JSONObject;

public class SaveThread implements Runnable {

    private static int i;

    public static void setTime(int i) {
        SaveThread.i = i * 60000;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {

            }
            JSONObject json = new JSONObject();
            json.put("money", Main.money);
            JSONObject reactorObject = new JSONObject();
            reactorObject.put("cooler", );
            reactorObject.put("control",1);
            reactorObject.put("uranium",1);
            reactorObject.put("system",1);
            reactorObject.put("generator",1);
            json.put("reactor", reactorObject);
        }
    }
}
