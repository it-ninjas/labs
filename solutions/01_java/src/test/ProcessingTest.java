import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.Job;
import queue.JobState;
import queue.Processing;
import queue.ProcessingInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessingTest {
    private ProcessingInterface processing;

    @BeforeEach
    public void setUp() {
        processing = new Processing();
    }

    @Test
    public void testAddJob() {
        Job job1 = new Job(1, "Job 1");
        Job job2 = new Job(2, "Job 2");

        assertTrue(processing.addJob(job1));
        assertTrue(processing.addJob(job2));
    }

    @Test
    public void testGetNextJob() {
        Job job1 = new Job(1, "Job 1");
        Job job2 = new Job(2, "Job 2");

        processing.addJob(job1);
        processing.addJob(job2);

        assertEquals(job1.getMessage(), processing.getNextJob().getMessage());
        assertEquals(job2.getMessage(), processing.getNextJob().getMessage());
    }

    @Test
    public void testGetJobBack() {
        Job job1 = new Job(1, "Job 1");
        Job job2 = new Job(2, "Job 2");

        processing.addJob(job1);
        processing.addJob(job2);

        Job processedJob = processing.getNextJob();
        processing.getJobBack(processedJob);
        processing.getNextJob();

        assertEquals(job1.getMessage(), processing.getNextJob().getMessage());
    }

    @Test
    public void testGetJobs() {
        Job job1 = new Job(1, "Job 1");
        Job job2 = new Job(2, "Job 2");

        processing.addJob(job1);
        processing.addJob(job2);

        assertEquals(2, processing.getJobs());
    }

    @Test
    public void testHasJobs() {
        assertFalse(processing.hasJobs());

        Job job = new Job(1, "Job 1");
        processing.addJob(job);

        assertTrue(processing.hasJobs());
    }

    @Test
    public void testJobProcessingOrder() {
        Job job1 = new Job(1, "Job 1");
        Job job2 = new Job(2, "Job 2");
        Job job3 = new Job(3, "Job 3");

        processing.addJob(job1);
        processing.addJob(job2);
        processing.addJob(job3);

        assertEquals(job1.getMessage(), processing.getNextJob().getMessage());
        assertEquals(job2.getMessage(), processing.getNextJob().getMessage());

        processing.getJobBack(job1);

        assertEquals(job3.getMessage(), processing.getNextJob().getMessage());
        assertEquals(job1.getMessage(), processing.getNextJob().getMessage());
    }

    @Test
    public void testGetJobBackWhenQueueIsEmpty() {
        Job job = new Job(1, "Job 1");

        assertTrue(processing.addJob(job));
        processing.getNextJob();
        processing.getJobBack(job);

        processing.getJobBack(job);

        assertEquals(JobState.NEW, job.getJobState());
    }


    @Test
    public void testPerformanceWithLargeNumberOfJobs() {
        int numJobs = 10000;

        for (int i = 1; i <= numJobs; i++) {
            Job job = new Job(i, "Job " + i);
            processing.addJob(job);
        }

        for (int i = 1; i <= numJobs; i++) {
            Job job = processing.getNextJob();
            assertNotNull(job);
            assertEquals("Job " + i, job.getMessage());
        }
    }

    @Test
    public void testAddingJobsWhenQueueIsFull() {
        int maxQueueSize = Integer.MAX_VALUE; // Kein festes Limit

        for (int i = 1; i <= maxQueueSize; i++) {
            Job job = new Job(i, "Job " + i);
            processing.addJob(job);
        }

        Job additionalJob = new Job(maxQueueSize + 1, "Additional Job");
        assertTrue(processing.addJob(additionalJob));
    }


    @Test
    public void testGetNextJobFromEmptyQueue() {
        assertNull(processing.getNextJob());
    }

}
