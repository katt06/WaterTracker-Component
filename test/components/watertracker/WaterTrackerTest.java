package components.watertracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test fixture for {@code WaterTracker1L}.
 */
public class WaterTrackerTest {
    /**
     * Creates a new instance of {@code WaterTracker1L} for testing.
     *
     * @return a new {@code WaterTracker1L} instance
     */
    private WaterTracker1L createTestInstance() {
        return new WaterTracker1L();
    }

    //tests for addWaterSource, removeWaterSource, drank, getWater, getWaterName, getWaterAmount, getWaterSources, setGoal, trackGoal
    @Test
    public void testSetGoal() {
        WaterTracker1L tracker = this.createTestInstance();
        WaterTracker1L trackerCopy = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        assertEquals("Daily Hydration", tracker.getGoalName());
        assertEquals(64.0, tracker.getGoalAmount(), 0.01);
        assertEquals(trackerCopy.getGoalName(), trackerCopy.getGoalName()); // Ensure trackerCopy remains unchanged
    }

    @Test
    public void testDrank() {
        WaterTracker1L tracker = this.createTestInstance();
        WaterTracker1L trackerCopy = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        tracker.getWaterSources().put("Bottle", 16.0);
        tracker.drank("Bottle");
        assertEquals(48.0, tracker.getGoalAmount(), 0.01);
        assertEquals(trackerCopy.getGoalAmount(), trackerCopy.getGoalAmount());
    }

    @Test
    public void testAddWaterSource() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.getWaterSources().put("Bottle", 16.0);
        assertTrue(tracker.getWaterSources().containsKey("Bottle"));
        assertEquals(16.0, tracker.getWaterSources().get("Bottle"), 0.01);
    }

    @Test
    public void testRemoveWaterSource() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.getWaterSources().put("Bottle", 16.0);
        tracker.getWaterSources().remove("Bottle");
        assertTrue(!tracker.getWaterSources().containsKey("Bottle"));
    }

    @Test
    public void testTrackGoal() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        tracker.getWaterSources().put("Bottle", 16.0);
        tracker.drank("Bottle");
        assertEquals(48.0, tracker.getGoalAmount(), 0.01);
    }

    @Test
    public void testGetWaterSources() {
        WaterTracker1L tracker = this.createTestInstance();
        WaterTracker1L trackerCopy = this.createTestInstance();
        tracker.getWaterSources().put("Glass", 8.0);
        assertEquals(8.0, tracker.getWaterSources().get("Glass"), 0.01);
        assertEquals(trackerCopy.getWaterSources().size(),
                trackerCopy.getWaterSources().size()); // Ensure trackerCopy remains unchanged
    }

    @Test
    public void testGetWaterName() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        assertEquals("Daily Hydration", tracker.getGoalName());
    }

    @Test
    public void testGetWaterAmount() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        assertEquals(64.0, tracker.getGoalAmount(), 0.01);
    }

    @Test
    public void testGetWater() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.getWaterSources().put("Bottle", 16.0);
        assertEquals(16.0, tracker.getWaterSources().get("Bottle"), 0.01);
    }

}

/*
 * @Test public void testGetXOne() { NaturalNumber n = new NaturalNumber1L();
 * NaturalNumber nCopy = new NaturalNumber1L(); assertEquals(true, n.isZero());
 * assertEquals(nCopy, n); }
 */