package queue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class InputWorker implements Runnable {
    private final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final String name;
    private final ProcessingInterface processingInterface;

    public InputWorker(String name, ProcessingInterface processingInterface) {
        this.name = name;
        this.processingInterface = processingInterface;
    }

    @Override
    public void run() {
        System.out.printf("   [%s] stared successfully%n", name);
        Random random = new Random();
        for (int i = 0; i < Start.INPUTWORKER_NUMBER_OF_JOBS; i++) {
            try {
                Thread.sleep(random.nextInt(Start.INPUTWORKER_MAX_RELAX_TIME_MS));
                String message = String.format("[%s]: (%s) It is a very hard job!",
                        name, dateFormat.format(new Date()));
                Job job = new Job(Start.getNextJobId(), message);
                processingInterface.addJob(job);
                System.out.printf("-> [%s]  add job:     %s%n", name, job);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
