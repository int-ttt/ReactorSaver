package net.intt.reactor.thread;

import net.intt.reactor.Main;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

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
            reactorObject.put("cooler", Main.reactor.getCoolerLevel());
            reactorObject.put("control", Main.reactor.getControlRodLevel());
            reactorObject.put("uranium", Main.reactor.getUraniumLevel());
            reactorObject.put("system", Main.reactor.getSystemLevel());
            reactorObject.put("generator", Main.reactor.getGeneratorLevel());
            json.put("reactor", reactorObject);
            try {
                FileWriter writer = new FileWriter(Main.dataFile);
                writer.write(json.toJSONString());
                writer.flush();
            } catch (IOException e) {
            }

        }
    }
}
