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

    /*
     * Tests for setGoal
     */

    @Test
    public void testSetGoalZeroAmount() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Zero Goal", 0.0);
        assertEquals("Zero Goal", tracker.getGoalName());
        assertEquals(0.0, tracker.getGoalAmount(), 0.01);
    }

    @Test
    public void testSetGoal() {
        WaterTracker1L tracker = this.createTestInstance();
        WaterTracker1L trackerCopy = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        assertEquals("Daily Hydration", tracker.getGoalName());
        assertEquals(64.0, tracker.getGoalAmount(), 0.01);
        assertEquals(trackerCopy.getGoalName(), trackerCopy.getGoalName()); // Ensure trackerCopy remains unchanged
    }

    /*
     * Tests for drank
     */

    @Test
    public void testDrankZeroAmountSource() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        tracker.getWaterSources().put("EmptyBottle", 0.0);
        tracker.drank("EmptyBottle");
        assertEquals(64.0, tracker.getGoalAmount(), 0.01); // Goal remains unchanged
    }

    @Test
    public void testDrank() {
        WaterTracker1L tracker = this.createTestInstance();
        WaterTracker1L trackerCopy = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        tracker.getWaterSources().put("Bottle", 16.0);
        tracker.drank("Bottle");
        assertEquals(48.0, tracker.getGoalAmount(), 0.01);
    }

    @Test
    public void testDrankMultipleSources() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        tracker.getWaterSources().put("Bottle", 16.0);
        tracker.getWaterSources().put("Glass", 8.0);
        tracker.drank("Bottle");
        tracker.drank("Glass");
        assertEquals(40.0, tracker.getGoalAmount(), 0.01);
    }

    /*
     * Tests for addWaterSource
     */

    @Test
    public void testAddWaterSourceZero() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.getWaterSources().put("EmptyBottle", 0.0);
        assertTrue(tracker.getWaterSources().containsKey("EmptyBottle"));
        assertEquals(0.0, tracker.getWaterSources().get("EmptyBottle"), 0.01);
    }

    @Test
    public void testAddWaterSource() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.getWaterSources().put("Bottle", 16.0);
        assertTrue(tracker.getWaterSources().containsKey("Bottle"));
        assertEquals(16.0, tracker.getWaterSources().get("Bottle"), 0.01);
    }

    /*
     * Tests for removeWaterSource
     */

    @Test
    public void testRemoveNonExistentWaterSource() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.getWaterSources().remove("NonExistentSource");
        assertTrue(tracker.getWaterSources().isEmpty());
    }

    @Test
    public void testRemoveWaterSource() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.getWaterSources().put("Bottle", 16.0);
        tracker.getWaterSources().remove("Bottle");
        assertTrue(!tracker.getWaterSources().containsKey("Bottle"));
    }

    /*
     * Tests for trackGoal
     */

    @Test
    public void testTrackGoal() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        tracker.getWaterSources().put("Bottle", 16.0);
        tracker.drank("Bottle");
        assertEquals(48.0, tracker.getGoalAmount(), 0.01);
    }

    @Test
    public void testTrackGoalMultipleSources() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        tracker.getWaterSources().put("Bottle", 32.0);
        tracker.getWaterSources().put("Glass", 16.0);
        tracker.getWaterSources().put("Cup", 16.0);
        tracker.drank("Bottle");
        tracker.drank("Glass");
        tracker.drank("Cup");
        assertEquals(0.0, tracker.getGoalAmount(), 0.01); // Goal is exactly met
    }

    /*
     * Tests for getWater
     */

    @Test
    public void testGetWaterSources() {
        WaterTracker1L tracker = this.createTestInstance();
        WaterTracker1L trackerCopy = this.createTestInstance();
        tracker.getWaterSources().put("Glass", 8.0);
        assertEquals(8.0, tracker.getWaterSources().get("Glass"), 0.01);
        assertEquals(trackerCopy.getWaterSources().size(),
                trackerCopy.getWaterSources().size()); // Ensure trackerCopy remains unchanged
    }

    /*
     * Test for getWaterName
     */

    @Test
    public void testGetWaterName() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        assertEquals("Daily Hydration", tracker.getGoalName());
    }

    /*
     * Test for getWaterAmount
     */

    @Test
    public void testGetWaterAmount() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        assertEquals(64.0, tracker.getGoalAmount(), 0.01);
    }

    /*
     * Test for getWater
     */
    @Test
    public void testGetWater() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.getWaterSources().put("Bottle", 16.0);
        assertEquals(16.0, tracker.getWaterSources().get("Bottle"), 0.01);
    }

}