package queue;

public class Job {
    private final int id;
    private String message;
    private JobState jobState;

    public Job(int id, String message) {
        this.id = id;
        this.message = message;
        this.jobState = JobState.NEW;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JobState getJobState() {
        return jobState;
    }

    public void setJobState(JobState jobState) {
        this.jobState = jobState;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", jobState=" + jobState +
                '}';
    }
}
