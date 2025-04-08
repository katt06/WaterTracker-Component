package components.watertracker;

import java.util.Objects;

/**
 * Abstract class that implements secondary methods for the WaterTracker. This
 * class provides enhanced functionality built upon the kernel interface.
 */
public abstract class WaterTrackerSecondary implements WaterTracker {

    // Constructor for secondary class
    public WaterTrackerSecondary() {
    }

    /*
     * Adds a new water source with specified paramters
     *
     * @param source {@code String} the name of the water source
     *
     * @param ounces {@code double} the amount of water in ounces
     *
     * @ensures waterSources[source] = ounces
     */
    @Override
    public final void addWaterSource(String source, double ounces) {
        // Call the kernel method to add the water source
        this.getWaterSources().put(source, ounces);
        System.out.println(source + " added with " + ounces + " oz");
    }

    /*
     * Removes an existing water source
     *
     * @param source {@code String} the name of the water source
     *
     * @ensures source is removed from waterSources
     */
    @Override
    public final void removeWaterSource(String source) {
        // Using the kernel method to check if it exists and remove the water source
        if (this.getWaterSources().containsKey(source)) {
            this.getWaterSources().remove(source);
            System.out.println(source + " removed");
        } else {
            System.out.println("Invalid Source");
        }
    }

    /*
     * Tracks progress toward the specificed hydration goal
     *
     * @param goalName {@code String}
     *
     * @ensures progress towards the goal is displayed
     */
    @Override
    public final void trackGoal(String goalName) {
        if (this.getGoalName().equals(goalName)) {
            double remaining = this.getGoalAmount() - this.getWater();
            if (remaining > 0) {
                System.out.println("Progress for " + goalName + ": "
                        + this.getWater() + "/" + this.getGoalAmount() + " oz");
                System.out.println(
                        "You need " + remaining + " more to reach your goal.");
            } else {
                System.out.println("Congrats! You've met your goal of "
                        + this.getGoalAmount() + " oz");
            }
        } else {
            System.out.println("Invalid Goal Name");
        }
    }

    /*
     * Returns a string representation of the WaterTracker object. The string
     * includes the goal name, goal amount, total water consumed, and the water
     * sources
     *
     * @return a string representation of the WaterTracker object
     */
    @Override
    public final String toString() {
        return "WaterTracker{" + "goalName = '" + this.getGoalName() + '\''
                + ", goalAmount = " + this.getGoalAmount()
                + ", totalWaterConsumed = " + this.getWater()
                + ", waterSources = " + this.getWaterSources() + '}';
    }

    /*
     * Compares WaterTrackerSecondary object to another object Two
     * WaterTrackerSecondary objects are considered equal if they have the same
     * goal name, goal amount, total water consumed, and water sources.
     *
     * @param obj the object to compare with WaterTrackerSecondary
     *
     * @return {@code true} if the specified object is equal to
     * WaterTrackerSecondary, {@code false} otherwise
     */
    @Override
    public final boolean equals(Object obj) {
        boolean isEqual = false;
        if (this == obj) {
            isEqual = true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            WaterTrackerSecondary that = (WaterTrackerSecondary) obj;
            isEqual = Double.compare(that.getGoalAmount(),
                    this.getGoalAmount()) == 0
                    && Double.compare(that.getWater(), this.getWater()) == 0
                    && this.getGoalName().equals(that.getGoalName())
                    && this.getWaterSources().equals(that.getWaterSources());
        }
        return isEqual;
    }

    /*
     * Computes the hash code for this WaterTrackerSecondary object. The hash
     * code is based on the goal name, goal amount, total water consumed, and
     * water sources.
     *
     * @return the hash code value for WaterTrackerSecondary
     */
    @Override
    public final int hashCode() {
        int hash = Objects.hash(this.getGoalName(), this.getGoalAmount(),
                this.getWater(), this.getWaterSources());
        return hash;
    }

}
