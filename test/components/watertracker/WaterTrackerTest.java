package components.watertracker;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testSetGoal() {
        WaterTracker1L tracker = this.createTestInstance();
        tracker.setGoal("Daily Hydration", 64.0);
        assertEquals("Daily Hydration", tracker.getGoalName());
        assertEquals(64.0, tracker.getGoalAmount(), 0.01);
    }
}
