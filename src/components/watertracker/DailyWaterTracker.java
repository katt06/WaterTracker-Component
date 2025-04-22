package components.watertracker;

public class DailyWaterTracker {
    public static void main(String[] args) {
        // Create a new WaterTracker instance
        WaterTracker1L tracker = new WaterTracker1L();

        // Set a daily hydration goal
        tracker.setGoal("Daily Hydration", 64.0);

        // Add water sources
        tracker.getWaterSources().put("Bottle", 16.0);
        tracker.getWaterSources().put("Glass", 8.0);

        // Log water consumption
        tracker.drank("Bottle");
        tracker.drank("Glass");

        // Display remaining hydration goal
        System.out
                .println("Remaining goal: " + tracker.getGoalAmount() + " oz");

        // Display all water sources
        System.out.println("Water sources: " + tracker.getWaterSources());
    }
}
