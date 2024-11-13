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
    public void printItinerary() {
        System.out.println(ConsoleColors.BOLD_YELLOW + "Itinerary for " + shipName + ConsoleColors.RESET);
        for (Destination destination : itinerary) {
            System.out.println(destination);
        }
    }
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
}
