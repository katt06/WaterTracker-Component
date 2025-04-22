package components.watertracker;

//Enhanced interface (extends on the kernal functionality)
public interface WaterTrackerEnhanced extends WaterTrackerKernal {
    /**
     * Adds a new water source with specified paramters
     *
     * @param source {@code String} the name of the water source
     *
     * @param ounces {@code double} the amount of water in ounces
     *
     * @ensures waterSources[source] = ounces
     */
    void addWaterSource(String source, double ounces);

    /**
     * Removes an existing water source
     *
     * @param source {@code String} the name of the water source
     *
     * @ensures source is removed from waterSources
     */
    void removeWaterSource(String source);

    /**
     * Tracks progress toward the specificed hydration goal
     *
     * @param goalName {@code String}
     *
     * @ensures progress towards the goal is displayed
     */
    void trackGoal(String goalName);
}
