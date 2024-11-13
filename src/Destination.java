import java.util.ArrayList;

public class Destination {
    private String destinationName;
    private ArrayList<Activity> activities;
    public Destination(String destinationName) {
        this.destinationName = destinationName;
        this.activities = new ArrayList<Activity>();
    }
    public String getDestinationName() {
        return destinationName;
    }
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }
    public ArrayList<Activity> getActivities() {
        return activities;
    }
    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }
    public void addActivity(Activity activity) {
        activities.add(activity);
    }
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    @Override
    public String toString() {
        String thing = (ConsoleColors.GREEN + "Destination: " + destinationName + ConsoleColors.RESET);
        thing += (ConsoleColors.PURPLE + "\n\n---------- ACTIVITIES: ----------" + ConsoleColors.RESET);

        int numActivities = activities.size();
        for (int i = 0; i < numActivities; i++) {
            thing += (ConsoleColors.YELLOW + "\n\t---------- " + activities.get(i).getClass().getSimpleName() + " ----------" + ConsoleColors.RESET);
            Activity activity = activities.get(i);
            thing += "\n" + activity;
        }

        return thing;
    }
}
