package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Processing implements ProcessingInterface {
    private Queue<Job> jobQueue = new LinkedList<>();
    private AtomicInteger jobCounter = new AtomicInteger(0);

    @Override
    public boolean addJob(Job job) {
        if (job != null) {
            Job jobWithId = new Job(jobCounter.incrementAndGet(), job.getMessage());
            jobQueue.offer(jobWithId);
            return true;
        }
        return false;
    }

    @Override
    public Job getNextJob() {
        return jobQueue.poll();
    }

    @Override
    public void getJobBack(Job job) {
        if (job != null) {
            jobQueue.offer(job);
        }
    }

    @Override
    public int getJobs() {
        return jobQueue.size();
    }

    @Override
    public boolean hasJobs() {
        return !jobQueue.isEmpty();
    }
}
