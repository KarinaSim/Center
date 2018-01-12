package netcracker.project.petshop.other;

import netcracker.project.petshop.service.DataStoringJob;
import org.springframework.beans.factory.annotation.Autowired;

public class SavingFileThread implements Runnable {
    private static final String NAME = "SavingFileThread";
    private Thread thread;
    @Autowired
    private DataStoringJob dataStoringJob;

    public SavingFileThread() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                dataStoringJob.save();
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            System.out.println(NAME + " is interrupted");
        }
    }

    public Thread getThread() {
        return thread;
    }
}
