package es.homeservices.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import es.homeservices.models.Job;
import es.homeservices.models.enumeration.Tag;
import es.homeservices.repositories.JobRepository;

@RunWith(MockitoJUnitRunner.class)
public class JobServiceTest {
    private static final Tag[] TAGS = Tag.values();
    private static final Collection<Job> JOBS = Arrays.asList(new Job(), new Job(), new Job());

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobServiceImpl jobService;

    @Before
    public void setup() {
        when(jobRepository.findAll()).thenReturn((List<Job>) JOBS);
    }

    @Test
    public void testListJobs() {
        Collection<Job> jobs = jobService.listJobs();

        assertNotNull(jobs);
        assertEquals(JOBS.size(), jobs.size());
    }

    @Test
    public void testListTags() {
        Tag[] tags = jobService.listTags();

        assertNotNull(tags);
        assertArrayEquals(TAGS, tags);
    }

    @Test
    public void testListJobs_NoJobsFound() {
        doReturn(null).when(jobRepository).findAll();

        Collection<Job> jobs = jobService.listJobs();

        assertNull(jobs);
    }
}
