package netcracker.project.petshop.other;

import netcracker.project.petshop.service.CleaningJob;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Random;


public class CleaningThread implements Runnable {
    private static final String NAME = "CleaningThread";
    private Thread thread;
    @Autowired
    private CleaningJob cleaningJob;

    public CleaningThread() {
        thread = new Thread(this, NAME);
        thread.start();
    }

    public void run() {
        int percentOfCleaning = 20 + new Random().nextInt(31 - 20);
        try {
            while (true) {
                cleaningJob.clean();
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
