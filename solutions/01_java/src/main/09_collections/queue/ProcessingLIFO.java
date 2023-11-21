package queue;

import java.util.Stack;

public class ProcessingLIFO implements ProcessingInterface {
    private Stack<Job> jobStack = new Stack<>();
    private int jobCounter = 0;

    @Override
    public boolean addJob(Job job) {
        if (job != null) {
            Job jobWithId = new Job(++jobCounter, job.getMessage());
            jobStack.push(jobWithId);
            return true;
        }
        return false;
    }

    @Override
    public Job getNextJob() {
        if (!jobStack.isEmpty()) {
            return jobStack.pop();
        }
        return null;
    }

    @Override
    public void getJobBack(Job job) {
        if (job != null) {
            jobStack.push(job);
        }
    }

    @Override
    public int getJobs() {
        return jobStack.size();
    }

    @Override
    public boolean hasJobs() {
        return !jobStack.isEmpty();
    }
}
