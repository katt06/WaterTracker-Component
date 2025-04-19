package components.watertracker;

/**
 * Customized JUnit test fixture for {@code WaterTracker1L}.
 */
public class WaterTracker1LTest extends WaterTrackerTest {

    @Override
    protected final WaterTracker<String, Double> constructorTest() {
        return new WaterTracker1L<String, Double>();
    }

    @Override
    protected final WaterTracker<String, Double> constructorRef() {
        return new WaterTracker<String, Double>();
    }

}
