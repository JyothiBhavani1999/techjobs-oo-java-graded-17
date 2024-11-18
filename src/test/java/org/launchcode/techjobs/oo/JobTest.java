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

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        String jobToStringMethodFormat = job.toString();  // holds a string value returned from toString method
        String blankLine = System.lineSeparator(); // new



        assertEquals(blankLine.charAt(0),jobToStringMethodFormat.charAt(0));
        assertEquals(blankLine.charAt(blankLine.length() -1),jobToStringMethodFormat.charAt(jobToStringMethodFormat.length() -1));

        //assertTrue(jobToStringMethodFormat.startsWith(blankLine));
        //assertTrue(jobToStringMethodFormat.endsWith(blankLine));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job5 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String blankLine = System.lineSeparator();

        String expected = blankLine +
                "ID: " + job5.getId() + blankLine +
                "Name: Product tester" + blankLine +
                "Employer: ACME" + blankLine +
                "Location: Desert" + blankLine +
                "Position Type: Quality control" + blankLine +
                "Core Competency: Persistence" + blankLine;

        assertEquals(expected, job5.toString());

    }

    @Test
    public void testToStringHandlesEmptyField(){

        Job job5 = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));

        assertEquals("OOPS! This job does not seem to exist.", job5.toString());
    }




    }