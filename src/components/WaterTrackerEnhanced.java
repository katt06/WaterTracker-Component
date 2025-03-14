package components;

//Enhanced interface (extends on the kernal functionality)
public interface WaterTracker extends WaterTrackerKernal {
    /*
     * Adds a new water source with specified paramters
     *
     * @param source {@code String} the name of the water source
     *
     * @param ounces {@code double} the amount of water in ounces
     *
     * @ensures waterSources[source] = ounces
     */
    void addWaterSource(String source, double ounces);

    /*
     * Removes an existing water source
     *
     * @param source {@code String} the name of the water source
     *
     * @ensures source is removed from waterSources
     */
    void removeWaterSouce(String source);

    /*
     * Sets a hydration goal
     *
     * @param goalName {@code String}
     *
     * @param goalAmount {@code double}
     *
     * @ensures this.goalName = goalName && this.goalAmount = goalAmount
     */
    void setGoal(String goalName, double goalAmount);

    /*
     * Tracks progress toward the specificed hydration goal
     *
     * @param goalName {@code String}
     *
     * @ensures progress towards the goal is displayed
     */
    void trackGoal(String goalName);
}
