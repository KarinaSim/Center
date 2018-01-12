package netcracker.project.petshop.other;

import netcracker.project.petshop.service.PollutionJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class PollutionThread implements Runnable {
    private static final String NAME = "PollutionThread";
    private Thread thread;
    @Autowired
    private PollutionJob pollutionJob;

    public PollutionThread() {
        thread = new Thread(this, NAME);
        thread.start();
    }

    public void run() {
        int percentOfPollution = 20 + new Random().nextInt(31 - 20);
        try {
            while (true) {
                pollutionJob.pollute();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(NAME + " is interrupted");
        }
    }

    public Thread getThread() {
        return thread;
    }
}
