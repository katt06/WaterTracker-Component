package components.watertracker;

import java.util.HashMap;
import java.util.Map;

/**
 * @code WaterTracker1L} is a kernel implementation of the WaterTracker
 *       component.
 *
 *       It uses a {@code Map} to represent water sources and tracks the
 *       hydration goal using a {@code String} and a {@code double}.
 *
 *
 * @convention <pre>
 * waterSources is non-null, all keys (source names) are non-null, non-empty strings
 * All values in waterSources (amounts) are non-negative
 * goalName is a non-null, non-empty string
 * goalAmount is non-negative
 * </pre>
 *
 * @correspondence <pre>
 * waterSources = the mapping of water source names to their respective amounts
 * goalName = the name of the hydration goal
 * goalAmount = the target amount of water to consume
 * </pre>
 *
 */
public class WaterTracker1L extends WaterTrackerSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Map to store water sources and their respective amounts.
     */
    private Map<String, Double> waterSources;

    /**
     * Name of the hydration goal.
     */
    private String goalName;

    /**
     * Target amount of water to consume for the hydration goal.
     */
    private double goalAmount;

    /**
     * Creates a new, empty representation for the water tracker.
     *
     * @ensures <pre>
     * waterSources = {} and
     * goalName = "Default Goal" and
     * goalAmount = 0.0
     * </pre>
     */
    private void createNewRep() {
        this.waterSources = new HashMap<>();
        this.goalName = "Default Goal";
        this.goalAmount = 0.0;
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     *
     * Initializes the representation with default values.
     */
    public WaterTracker1L() {
        this.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    /**
     * Logs water consumption from a specified source.
     *
     * @param source
     *            the name of the water source as a {@code String}
     *
     * @throws AssertionError
     *             if {@code source} is null, empty, or not in the water sources
     *             map
     *
     * @ensures <pre> if source is in DOMAIN(waterSources) then
     * totalWaterConsumed = #totalWaterConsumed + waterSources[source] </pre>
     */
    @Override
    public final void drank(String source) {
        assert source != null && !source
                .isEmpty() : "Violation of: source is not null or empty";
        assert this.waterSources.containsKey(
                source) : "Violation of: source is in DOMAIN(waterSources)";

        // Add the amount of water from source to the total consumed
        double ounces = this.waterSources.get(source);
        this.goalAmount -= ounces; // Reduce the goal amount by the consumed amount
        System.out.println("Drank " + ounces + " oz from " + source);
    }

    /**
     * Gets the map of water sources.
     *
     * @return the {@code Map} of water sources and their respective amounts
     */
    @Override
    public Map<String, Double> getWaterSources() {
        return Map.copyOf(this.waterSources);
    }

    /**
     * Gets the name of the hydration goal.
     *
     * @return the name of the hydration goal as a {@code String}
     */
    @Override
    public String getGoalName() {
        return this.goalName;
    }

    /**
     * Gets the target hydration goal amount.
     *
     * @return the hydration goal amount as a {@code double}
     */
    @Override
    public double getGoalAmount() {
        return this.goalAmount;
    }

    /**
     * Sets the hydration goal.
     *
     * @param goalName
     *            the name of the hydration goal as a {@code String}
     *
     * @param goalAmount
     *            the target hydration goal amount as a {@code double}
     *
     * @throws AssertionError
     *             if {@code goalName} is null or empty or if {@code
     * goalAmount} is negative
     */
    @Override
    public void setGoal(String goalName, double goalAmount) {
        if (goalName == null || goalName.isEmpty() || goalAmount < 0) {
            throw new AssertionError("Invalid goal name or amount.");
        }
        this.goalName = goalName;
        this.goalAmount = goalAmount;
    }

    /**
     * Standard methods -------------------------------------------------------
     */

    /*
     * Clears the water tracker by resetting the representation.
     *
     * @ensures <pre> waterSources = {} and goalName = "Default Goal" and
     * goalAmount = 0.0 </pre>
     */
    @Override
    public final void clear() {
        this.createNewRep();
    }

    /**
     * Creates a new instance of {@code WaterTracker1L}.
     *
     * @return a new instance of {@code WaterTracker1L}
     */
    @Override
    public final WaterTracker1L newInstance() {
        return new WaterTracker1L();
    }

    /**
     * Transfers the state from the given {@code WaterTracker1L} to this
     * instance.
     *
     * @param source
     *            the source {@code WaterTracker1L} to transfer from
     *
     * @requires source is not null and source is of the same dynamic type as
     *           this
     *
     * @ensures <pre> this = #source and source = {} </pre>
     */
    @Override
    public final void transferFrom(WaterTracker source) {
        assert source != null : "Violation of: source is not null";
        assert source instanceof WaterTracker1L : "Violation of: source is of dynamic type WaterTracker1L";

        WaterTracker1L localSource = (WaterTracker1L) source;

        // Transfer the state
        this.waterSources = localSource.waterSources;
        this.goalName = localSource.goalName;
        this.goalAmount = localSource.goalAmount;

        // Reset the source
        localSource.createNewRep();
    }

}
