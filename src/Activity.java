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
        this.participants = new HashSet<>();
    }

    /**
     * Adds a passenger to the activity
     * If the passenger is already in the activity, prints "Passenger is already in the activity"
     * If the activity is full, prints "Activity is full"
     * If the passenger does not have enough funds, prints "Insufficient funds"
     * Otherwise, adds the passenger to the activity, removes the activity price from the passenger's balance,
     * and prints "Passenger added to the activity"
     * Since passenger is a reference variable, I can also use it to reverse add the activity to the passenger's
     * activity list too
     */
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

    /**
     * Calculates the price of the activity for a passenger
     * @param passenger
     * @return
     */
    public double calcActivityPrice(Passenger passenger) {
        if (passenger.getStatus().equals("Premium")) {
            return 0; //Clever way to make the activity free for premium passengers
        }
        else if (passenger.getStatus().equals("Senior")){
            return activityPrice*0.9; //10% discount for seniors
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
