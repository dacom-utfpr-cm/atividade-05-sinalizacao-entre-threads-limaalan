package atividade01;
import java.util.Random;

public class ConsumerThread implements Runnable {
    private final ResourceMonitor resourceMonitor;
    private static int maxSleepTime ;

 
    public ConsumerThread(ResourceMonitor resourceMonitor, int maxSleepTime) {
        this.resourceMonitor = resourceMonitor;
        this.maxSleepTime = maxSleepTime;
        
    }
 
    @Override
    public void run() {
        Random random = new Random();
        String message = "";
        while (!message.equals("DONE")){
            message = resourceMonitor.take();
            System.out.format("%s: MESSAGE RECEIVED: %s\n", Thread.currentThread().getName(), message);
            try {
                Thread.sleep(maxSleepTime);
            } catch (InterruptedException e) {}

        }
    }
}
