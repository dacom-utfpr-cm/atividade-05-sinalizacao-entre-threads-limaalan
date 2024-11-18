package atividade01;

import java.util.Random;

public class ProducerThread implements Runnable {

    private ResourceMonitor resourceMonitor;
    private static int maxSleepTime ;

    public ProducerThread(ResourceMonitor resourceMonitor, int maxSleepTime) {
        this.resourceMonitor = resourceMonitor;
        this.maxSleepTime = maxSleepTime;
    }

    public void run() {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too",
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too",
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            resourceMonitor.put(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(maxSleepTime));
            } catch (InterruptedException e) {}
        } //for
        resourceMonitor.put("DONE");
    }
}
