import java.util.HashSet;

public class Activity {
    private String activityName, activityDescription;
    private double activityPrice;
    private int activityCapacity;
    private HashSet<Passenger> participants;
    public Activity(String activityName, String activityDescription, double activityPrice, int activityCapcity) {
        this.activityName = activityName;
        this.activityDescription = activityDescription;
        this.activityPrice = activityPrice;
        this.activityCapacity = activityCapcity;
        this.participants = new HashSet<Passenger>();
    }
    public void addMember(Passenger passenger) {
        if (participants.contains(passenger)) {
            System.out.println("Passenger is already in the activity");
            return;
        }
        if (activityCapacity != 0) {
            if (passenger.getBalance() >= calcActivityPrice(passenger)) {
                passenger.alterBalance(-calcActivityPrice(passenger));
                participants.add(passenger);
                passenger.addActivity(this);
                activityCapacity--;
                System.out.println(passenger.getName() + " added to the activity");
            }
            else {
                System.out.println("Insufficient funds");
            }
        }
        else {
            System.out.println("Activity is full");
        }
    }
    public void removeMember(Passenger passenger) {
        if (participants.contains(passenger)) {
            participants.remove(passenger);
            activityCapacity++;
        }
        else {
            System.out.println("Passenger is not in the activity");
        }
    }
    public double calcActivityPrice(Passenger passenger) {
        if (passenger.getStatus().equals("Premium")) {
            return 0;
        }
        else if (passenger.getStatus().equals("Senior")){
            return activityPrice*0.9;
        }
        else {
            return activityPrice;
        }
    }
    @Override
    public String toString() {
        return "\tActivity Name: " + activityName +
                "\n\tActivity Description: " + activityDescription +
                "\n\tActivity Price: " + activityPrice +
                "\n\tActivity Capacity: " + activityCapacity;
    }
    public String getActivityName() {
        return activityName;
    }
    public String getActivityDescription() {
        return activityDescription;
    }
    public double getActivityPrice() {
        return activityPrice;
    }
    public int getActivityCapacity() {
        return activityCapacity;
    }
    public HashSet<Passenger> getParticipants() {
        return participants;
    }
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }
    public void setActivityPrice(double activityPrice) {
        this.activityPrice = activityPrice;
    }
    public void setActivityCapacity(int activityCapacity) {
        this.activityCapacity = activityCapacity;
    }
    public void setParticipants(HashSet<Passenger> participants) {
        this.participants = participants;
    }
}
