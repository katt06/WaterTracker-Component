
import java.util.HashMap;
import java.util.Map;

public class WaterTracker {
    private Map<String, Double> waterSources; // Tracks different sources of water
    private double totalWaterConsumed; // Tracks total water intake
    private double goalAmount; // Hydration goal
    private String goalName; // Goal description

    // Constructor
    public WaterTracker() {
        this.waterSources = new HashMap<>();
        this.totalWaterConsumed = 0;
        this.goalAmount = 0;
        this.goalName = "n/a";
    }

    // Add a new water source
    public final void addWaterSource(String source, double ounces) {
        this.waterSources.put(source, ounces);
        System.out.println(source + " added with " + ounces + " oz");
    }

    // Remove a water source
    public final void removeWaterSource(String source) {
        if (this.waterSources.containsKey(source)) {
            this.waterSources.remove(source);
            System.out.println(source + " removed");
        } else {
            System.out.println("Invalid Source");
        }
    }

    // Log water consumption during an activity
    public final void drank(String source) {
        if (this.waterSources.containsKey(source)) {
            double ounces = this.waterSources.get(source);
            this.totalWaterConsumed += ounces;
            System.out.println("Drank " + ounces + " oz from " + source);
        } else {
            System.out.println("Invalid Source");
        }
    }

    // Get water dranken
    public final double getWater() {
        return this.totalWaterConsumed;
    }

    // Get name of current hydration goal
    public final String getGoalName() {
        return this.goalName;
    }

    // Get hydration goal amount in ounces
    public final double getGoalAmount() {
        return this.goalAmount;
    }

    // Gets map of water sources and their ounces
    public final Map<String, Double> getWaterSources() {
        return this.waterSources;
    }

    // Set a hydration goal
    public final void setGoal(String goalName, double goalAmount) {
        this.goalName = goalName;
        this.goalAmount = goalAmount;
        System.out.println("Goal: " + goalName + " - " + goalAmount + " oz");
    }

    // Track progress toward the goal
    public final void trackGoal(String goalName) {
        if (this.goalName.equals(goalName)) {
            double remaining = this.goalAmount - this.totalWaterConsumed;
            if (remaining > 0) {
                System.out.println("Progress for " + goalName + ": "
                        + this.totalWaterConsumed + "/" + this.goalAmount
                        + " oz");
                System.out.println(
                        "You need " + remaining + " more to reach your goal.");
            } else {
                System.out.println("Congrats! You've met your goal of "
                        + this.goalAmount + " oz");
            }
        } else {
            System.out.println("Invalid Goal Name");
        }
    }

    // Main Method
    public static void main(String[] args) {
        WaterTracker tracker = new WaterTracker();

        // Adding water sources
        tracker.addWaterSource("Plastic Water Bottle", 16.9);
        tracker.addWaterSource("Glass", 8);

        // Setting hydration goal
        tracker.setGoal("Daily Hydration", 64);

        // Logging water consumption
        tracker.drank("Plastic Water Bottle");
        tracker.drank("Glass");

        // Getting total water consumed
        System.out
                .println("Total water consumed: " + tracker.getWater() + " oz");

        // Tracking progress
        tracker.trackGoal("Daily Hydration");

        // Removing a water source
        tracker.removeWaterSource("Glass");
    }
}