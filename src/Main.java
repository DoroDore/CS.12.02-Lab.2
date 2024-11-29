import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        testAddEverything();
    }

    /**
     * Tests the addActivity method in Destination.java
     */
    public static void testAddActivity() {
        Destination destinationTest = new Destination("Destination Test");
        Actor actorTest = new Actor("Actor Test", "Actor Test Role");
        Actor actorTest2 = new Actor("Actor Test 2", "Actor Test Role 2");
        ArrayList<Actor> castTest = new ArrayList<Actor>();
        castTest.add(actorTest);
        castTest.add(actorTest2);
        TheaterActivity theaterTest = new TheaterActivity("Wicked", "Theater Test Description", 10.0, 100, castTest);
        destinationTest.addActivity(theaterTest);
        Passenger passengerTest = new Passenger("Passenger Test", "Standard");
        passengerTest.printPassengerInformation();
        theaterTest.addMember(passengerTest, destinationTest);
        passengerTest.printPassengerInformation();
    }

    /**
     * Tests printing the entire itinerary of a cruise ship with indenting and color coding.
     * Itinerary > Destination > Activity > Name, Description, Cost, Capacity, and Participants
     */
    public static void printItinerary() {
        Destination destinationTest = new Destination("Destination Test");
        Actor actorTest = new Actor("Actor Test", "Actor Test Role");
        Actor actorTest2 = new Actor("Actor Test 2", "Actor Test Role 2");
        Actor actorTest3 = new Actor("Actor Test 3", "Actor Test Role 3");
        Actor actorTest4 = new Actor("Actor Test 4", "Actor Test Role 4");
        ArrayList<Actor> castTest = new ArrayList<Actor>();
        ArrayList<Actor> castTest2 = new ArrayList<Actor>();
        castTest.add(actorTest);
        castTest.add(actorTest2);
        castTest2.add(actorTest3);
        castTest2.add(actorTest4);
        TheaterActivity theaterTest = new TheaterActivity("Wicked", "Theater Test Description", 10.0, 100, castTest);
        TheaterActivity theaterTest2 = new TheaterActivity("Hamilton", "Theater Test Description 2", 20.0, 200, castTest2);
        destinationTest.addActivity(theaterTest);
        destinationTest.addActivity(theaterTest2);
        WalkingActivity walkingTest = new WalkingActivity("Walking Test", "Walking Test Description", 5.0, 50, 5.0);
        destinationTest.addActivity(walkingTest);
        Destination destinationTest2 = new Destination("Destination Test 2");
        destinationTest2.addActivity(theaterTest);
        destinationTest2.addActivity(walkingTest);
        destinationTest2.addActivity(theaterTest2);
        ArrayList<Destination> itineraryTest = new ArrayList<Destination>();
        itineraryTest.add(destinationTest);
        itineraryTest.add(destinationTest2);

        CruiseShip cruiseTest = new CruiseShip("Cruise Test", 100, itineraryTest);
        cruiseTest.printItinerary();
    }

    /**
     * Puts together all the previous tests. Tests destinations and adding participants, creating the
     * itinerary of the cruise ship, and then displaying it alongside all the passengers and their details
     * in the "toString" of the Cruise Ship.
     */
    public static void testAddEverything() {
        Destination destinationTest = new Destination("Destination Test");
        Actor actorTest = new Actor("Actor Test", "Actor Test Role");
        Actor actorTest2 = new Actor("Actor Test 2", "Actor Test Role 2");
        Actor actorTest3 = new Actor("Actor Test 3", "Actor Test Role 3");
        Actor actorTest4 = new Actor("Actor Test 4", "Actor Test Role 4");
        ArrayList<Actor> castTest = new ArrayList<Actor>();
        ArrayList<Actor> castTest2 = new ArrayList<Actor>();
        castTest.add(actorTest);
        castTest.add(actorTest2);
        castTest2.add(actorTest3);
        castTest2.add(actorTest4);
        TheaterActivity theaterTest = new TheaterActivity("Wicked", "Theater Test Description", 10.0, 100, castTest);
        TheaterActivity theaterTest2 = new TheaterActivity("Hamilton", "Theater Test Description 2", 20.0, 200, castTest2);
        destinationTest.addActivity(theaterTest);
        destinationTest.addActivity(theaterTest2);
        WalkingActivity walkingTest = new WalkingActivity("Walking Test", "Walking Test Description", 5.0, 50, 5.0);
        destinationTest.addActivity(walkingTest);
        destinationTest.addActivity(theaterTest);
        destinationTest.addActivity(walkingTest);
        destinationTest.addActivity(theaterTest2);
        ArrayList<Destination> itineraryTest = new ArrayList<Destination>();
        itineraryTest.add(destinationTest);
        Passenger passengerTest = new Passenger("Passenger Test", "Standard");
        Passenger passengerTest2 = new Passenger("Passenger Test 2", "Senior");
        Passenger passengerTest3 = new Passenger("Passenger Test 3", "Premium");
        Passenger passengerTest4 = new Passenger("Passenger Test 4", "Standard");
        CruiseShip cruiseTest = new CruiseShip("Cruise Test", 100, itineraryTest);
        cruiseTest.addPassenger(passengerTest);
        cruiseTest.addPassenger(passengerTest2);
        cruiseTest.addPassenger(passengerTest3);
        cruiseTest.addPassenger(passengerTest4);

        //System.out.println(cruiseTest);
        cruiseTest.printShipInformation();
    }

    /**
     * Tests whether a passenger can join a cruise ship activity.
     */
    public static void testJoinActivity() {
        Destination destinationTest = new Destination("Destination Test");
        Activity activityTest = new Activity("Activity Test", "Activity Test Description", 10.0, 100);
        Passenger passengerTest = new Passenger("Passenger Test", "Standard");
        destinationTest.addActivity(activityTest);
        passengerTest.printPassengerInformation();
        activityTest.addMember(passengerTest, destinationTest);
        passengerTest.printPassengerInformation();
    }
}