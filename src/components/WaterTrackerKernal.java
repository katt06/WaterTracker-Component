package components;

import java.util.Map;

import components.standard.Standard;

//Kernal Interface (minimum functionality to track water consumption)
public interface WaterTrackerKernal extends Standard<WaterTracker> {
    /*
     * Logs water consumption from inputed source
     *
     * @param source {@code String} name of the water source
     *
     * @ensures totalWaterConsumed = #totalWaterConsumed + waterSources[source]
     */
    void drank(String source);

    /*
     * Gets the total amount of water consumed
     *
     * @return the total water consumed in ounces
     */
    double getWater();

    /*
     * Gets the current hydration goal name
     *
     * @return the name of the current hydration goal
     */
    String getGoalName();

    /*
     * Gets the hydration goal amount in ounces
     *
     * @return the hydration goal amount
     */
    double getGoalAmount();

    /*
     * Gets the map of water sources and their ounce values
     *
     * @return a {@code Map<String, Double>} of water sources
     */
    Map<String, Double> getWaterSources();

}
