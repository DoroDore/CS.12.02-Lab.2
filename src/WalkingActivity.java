public class WalkingActivity extends Activity{
    private final double walkingDistance;
    public WalkingActivity(String activityName, String activityDescription, double activityPrice, int activityCapacity, double walkingDistance) {
        super(activityName, activityDescription, activityPrice, activityCapacity);
        this.walkingDistance = walkingDistance;
    }
    public double getWalkingDistance() {
        return walkingDistance;
    }
    @Override
    public String toString() {
        return super.toString() + "\n\tWalking Distance: " + walkingDistance;
    }
}
