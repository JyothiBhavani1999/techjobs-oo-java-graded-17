package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public  void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());


        assertTrue(job.getEmployer() instanceof  Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof  PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);


    }

    @Test
    public void testJobsForEquality(){
    Job job3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    Job job4 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

    assertFalse(job3.equals(job4));
    }




}
