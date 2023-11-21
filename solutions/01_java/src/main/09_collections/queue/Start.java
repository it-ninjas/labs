package queue;

import java.util.concurrent.atomic.AtomicInteger;

public class Start {
    public static final int INPUTWORKER_NUMBER_OF_JOBS = 5;
    public static final int INPUTWORKER_MAX_RELAX_TIME_MS = 2000;
    public static final int OUTPUTWORKER_START_AFTER_MS = 3000;
    public static final int OUTPUTWORKER_MAX_PROCESS_TIME_MS = 1000;
    public static final int OUTPUTWORKER_MAX_RELAX_TIME_MS = 1000;
    public static final int OUTPUTWORKER_STOP_AFTER_EMPTY_CYCLES = 5;

    private static final AtomicInteger jobId = new AtomicInteger(1);

    private final ProcessingInterface processing = new Processing();
    // Aufgabe 1.2 below
    //    private final ProcessingInterface processing = new ProcessingLIFO();


    public Start() {
        InputWorker inputWorker1 = new InputWorker("InputWorker-1", processing);
        InputWorker inputWorker2 = new InputWorker("InputWorker-2", processing);
        new Thread(inputWorker1).start();
        new Thread(inputWorker2).start();

        try {
            Thread.sleep(OUTPUTWORKER_START_AFTER_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        OutputWorker outputWorker1 = new OutputWorker("OutputWorker-1", processing);
        new Thread(outputWorker1).start();
    }

    public static void main(String[] args) {
        new Start();
    }

    /**
     * Get the next Job ID.
     */
    public static int getNextJobId() {
        return jobId.getAndIncrement();
    }
}