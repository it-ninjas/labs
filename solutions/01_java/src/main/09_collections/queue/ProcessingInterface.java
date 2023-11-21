package queue;

public interface ProcessingInterface {

    /**
     * Add a job to the system.
     *
     * @return true if the job is added.
     */
    boolean addJob(Job job);

    /**
     * Get the next job for processing.
     */
    Job getNextJob();

    /**
     * Put the unprocessed job back to the system.
     */
    void getJobBack(Job job);

    /**
     * Get the number of jobs in the system.
     */
    int getJobs();

    /**
     * Has jobs in the system for processing?
     */
    boolean hasJobs();
}
