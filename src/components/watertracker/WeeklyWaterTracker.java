package components.watertracker;

public class WeeklyWaterTracker {
    public static void main(String[] args) {
        // Create a new WaterTracker instance
        WaterTracker1L tracker = new WaterTracker1L();

        // Set a weekly hydration goal
        double weeklyGoal = 7 * 64.0; // 7 days, 64 oz per day
        double totalConsumed = 0.0;

        // Simulate tracking for 7 days
        for (int day = 1; day <= 7; day++) {
            System.out.println("Day " + day);

            // Set daily hydration goal
            tracker.setGoal("Daily Hydration", 64.0);

            // Add water sources
            tracker.getWaterSources().put("Bottle", 16.0);
            tracker.getWaterSources().put("Glass", 8.0);

            // Log water consumption
            tracker.drank("Bottle");
            tracker.drank("Glass");

            // Track total consumed
            totalConsumed += (64.0 - tracker.getGoalAmount());

            // Reset tracker for the next day
            tracker.clear();
        }

        // Display weekly hydration summary
        System.out.println("Weekly goal: " + weeklyGoal + " oz");
        System.out.println("Total consumed: " + totalConsumed + " oz");
        System.out.println(
                "Remaining goal: " + (weeklyGoal - totalConsumed) + " oz");
    }
}
