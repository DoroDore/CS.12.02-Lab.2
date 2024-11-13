import java.util.LinkedHashSet;

public class Passenger {
    private String name, status;
    private int seatNumber;
    private double balance;
    private LinkedHashSet<Activity> activities;
    public Passenger(String name, String status) {
        this.name = name;
        this.status = status;
        this.activities = new LinkedHashSet<Activity>();
        if (status.equalsIgnoreCase("Premium")) {
            this.balance = 0;
        }
        else {
            this.balance = 1000;
        }
        //Seat number is not assigned yet, and can be assigned once the passenger has been added to the cruise
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public double getBalance() {
        return balance;
    }
    public LinkedHashSet<Activity> getActivities() {
        return activities;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void alterBalance(double quantity) {
        this.balance += quantity;
    }
    public void addActivity(Activity activity) {
        activities.add(activity);
    }
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    public void printPassengerInformation() {
        System.out.println("Name: " + name);
        System.out.println("Status: " + status);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Activities: ");
        if (!activities.isEmpty()) {
            for (Activity activity : activities) {
                System.out.println("> " + activity.getActivityName() + " - " + activity.getActivityDescription());
            }
        }
    }
    @Override
    public String toString() {
        return "Seat Number: " + seatNumber + "\nName: " + name + "\nStatus: " + status + "\nBalance: " + balance;
    }
}
