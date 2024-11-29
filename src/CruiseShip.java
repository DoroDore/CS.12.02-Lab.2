import java.util.ArrayList;
import java.util.LinkedHashSet;

/*
    COLOR CODE FOR LEVELS OF IMPORTANCE
    1. Red = Cruise Ship
    2. Green = Destination
    3. Yellow = Passenger
    4. Purple = Activity
    5. Yellow = Activity Sub Type
    6. Cyan = Divider
 */

public class CruiseShip {
    private String shipName;
    private int passengerCapacity;
    private ArrayList<Destination> itinerary;
    private LinkedHashSet<Passenger> passengerList;
    public CruiseShip(String shipName, int passengerCapacity, ArrayList<Destination> itinerary) {
        this.shipName = shipName;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = itinerary;
        this.passengerList = new LinkedHashSet<Passenger>();
    }
    /**
     * Prints out the Ship name, along with the itinerary and passengers.
     * Within each destination on the itinerary, the activities are detailed too.
     */
    @Override
    public String toString() {
        String thing = ConsoleColors.RED + "Cruise Ship: " + shipName + ConsoleColors.RESET;
        thing += ConsoleColors.BOLD_PURPLE + "\n---------- ITINERARY: ----------" + ConsoleColors.RESET;
        for (Destination destination : itinerary) {
            thing += "\n" + destination + "\n";
        }
        thing += ConsoleColors.BOLD_YELLOW + "\n---------- PASSENGERS: ----------" + ConsoleColors.RESET;
        for (Passenger passenger : passengerList) {
            thing += "\n" + passenger + "\n";
        }
        return thing;
    }
    /**
     * Prints out the itinerary of the cruise ship.
     */
    public void printItinerary() {
        System.out.println(ConsoleColors.BOLD_YELLOW + "Itinerary for " + shipName + ConsoleColors.RESET);
        for (Destination destination : itinerary) {
            System.out.println(destination);
        }
    }
    /**
     * Outputs the basic information of the ship, including the ship name, itinerary, passenger capacity, and passengers.
     */
    public void printShipInformation() {
        System.out.println(ConsoleColors.RED + "Ship Name: " + shipName + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + "Passenger Capacity: " + passengerCapacity + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + "Itinerary: " + ConsoleColors.RESET);
        for (Destination destination : itinerary) {
            System.out.println("- " + destination.getDestinationName());
        }
        System.out.println(ConsoleColors.RED + "Passengers: " + ConsoleColors.RESET);
        for (Passenger passenger : passengerList) {
            System.out.println(passenger);
            System.out.println("---------");
        }
    }
    /**
     * Prints out the passengers on the cruise ship.
     */
    public void addPassenger(Passenger passenger) {
        if (passengerList.contains(passenger)) {
            System.out.println("Passenger is already on the ship");
            return;
        }
        if (passengerCapacity != 0) {
            passengerList.add(passenger);
            passenger.setSeatNumber(passengerList.size());
            passengerCapacity--;
            System.out.println(passenger.getName() + " added to the ship");
        }
        else {
            System.out.println("Ship is full");
        }
    }
    public void removePassenger(Passenger passenger) {
        if (passengerList.contains(passenger)) {
            passengerList.remove(passenger);
            passenger.setSeatNumber(0);
            passengerCapacity++;

            // Shift seat numbers for passengers after the removed passenger
            int seatNumber = 1; // Initialize the seat number counter
            for (Passenger p : passengerList) {
                p.setSeatNumber(seatNumber);
                seatNumber++;
            }

            System.out.println(passenger.getName() + " has been removed from the ship. Passengers reassigned seats.");
        } else {
            System.out.println("Passenger is not on the ship");
        }
    }
    public void joinActivity(Passenger passenger, Activity activity, Destination destination) {
        if (passenger.getActivities().contains(activity)) {
            System.out.println("Passenger is already in the activity");
            return;
        }
        for (Activity a : passenger.getActivities()) {
            if (destination.getActivities().contains(a)) {
                System.out.println("Passenger is already part of another activity in this destination");
                return;
            }
        }
        activity.addMember(passenger, destination);
    }
    public String getShipName() {
        return shipName;
    }
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public ArrayList<Destination> getItinerary() {
        return itinerary;
    }
    public LinkedHashSet<Passenger> getPassengerList() {
        return passengerList;
    }
}
