import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CruiseShipTest {
    private CruiseShip cruiseShip1;
    private Destination destination1, destination2;
    private WalkingActivity walkingActivity1, walkingActivity2;
    private TheaterActivity theaterActivity1;
    private Passenger passenger1, passenger2, passenger3, passenger4;

    /**
     * Set up the test fixture before each test.
     */
    @BeforeEach
    void setUp() {
        destination1 = new Destination("Destination 1");
        destination2 = new Destination("Destination 2");
        walkingActivity1 = new WalkingActivity("Walking to the Moon",
                "Join tour guide Neil Armstrong to the moon!",
                5.0, 50, 5.0);
        walkingActivity2 = new WalkingActivity("Walking to Mars",
                "Join tour guide Elon Musk to Mars!",
                10.0, 100, 10.0);
        Actor actor1 = new Actor("Cyrus Chan", "CS Nerd");
        Actor actor2 = new Actor("Amboise Hui", "Excalibur Umbra");
        ArrayList<Actor> cast1 = new ArrayList<>();
        cast1.add(actor1);
        cast1.add(actor2);
        theaterActivity1 = new TheaterActivity("Theater of Sneezes",
                "A tale of achoos", 20, 100, cast1);
        passenger1 = new Passenger("Ms. Nahar", "Premium");
        passenger2 = new Passenger("Ethan", "Premium");
        passenger3 = new Passenger("Adam", "Standard");
        passenger4 = new Passenger("Theo 2075", "Senior");
        cruiseShip1 = new CruiseShip("CIS Cruise", 100,
                new ArrayList<>(List.of(destination1, destination2)));

    }

    /**
     * Tear down the test fixture after each test.
     */
    @AfterEach
    void tearDown() {
        cruiseShip1 = null;
        destination1 = null;
        destination2 = null;
        walkingActivity1 = null;
        walkingActivity2 = null;
        theaterActivity1 = null;
    }

    /**
     * Test the constructor and verifies whether passengers are assigned seat numbers accordingly.
     * Also verifies that once added, the amount of passengers
     */
    @Test
    void addPassengersTest() {
        cruiseShip1.addPassenger(passenger1);
        cruiseShip1.addPassenger(passenger2);
        cruiseShip1.addPassenger(passenger3);
        assertEquals(3, cruiseShip1.getPassengerList().size());
        assertEquals(1, passenger1.getSeatNumber());
        assertEquals(2, passenger2.getSeatNumber());
        assertEquals(3, passenger3.getSeatNumber());
    }

    /**
     * Double checks whether the exact same passenger can be added to the ship twice
     * If it does, then the array list's size will be wrong.
     */
    @Test
    void addPassengerTwiceTest() {
        cruiseShip1.addPassenger(passenger1);
        cruiseShip1.addPassenger(passenger1);
        assertEquals(1, cruiseShip1.getPassengerList().size());
    }

    /**
     * Tests whether a passengers can join the activity. Additionally, it checks the passenger's
     * balance to assure it has been altered correctly.
     */
    @Test
    void joinActivity() {
        destination1.addActivity(theaterActivity1);
        cruiseShip1.joinActivity(passenger1, theaterActivity1, destination1);
        cruiseShip1.joinActivity(passenger2, theaterActivity1, destination1);
        cruiseShip1.joinActivity(passenger3, theaterActivity1, destination1);
        assertEquals(3, theaterActivity1.getParticipants().size());
        assertEquals(97, theaterActivity1.getActivityCapacity());
        assertEquals(980 ,passenger3.getBalance());
    }

    /**
     * Verifies whether the description of the activity can be correctly accessed.
     */
    @Test
    void verifyActivityDescription() {
        destination1.addActivity(walkingActivity1);
        destination1.addActivity(theaterActivity1);
        cruiseShip1.addPassenger(passenger1);
        cruiseShip1.addPassenger(passenger2);
        cruiseShip1.addPassenger(passenger3);
        cruiseShip1.joinActivity(passenger1, walkingActivity1, destination1);
        cruiseShip1.joinActivity(passenger2, walkingActivity1, destination1);
        cruiseShip1.joinActivity(passenger3, walkingActivity1, destination1);
        cruiseShip1.joinActivity(passenger1, theaterActivity1, destination1);
        cruiseShip1.joinActivity(passenger2, theaterActivity1, destination1);
        cruiseShip1.joinActivity(passenger3, theaterActivity1, destination1);
        assertEquals("Join tour guide Neil Armstrong to the moon!", walkingActivity1.getActivityDescription());
        assertEquals("A tale of achoos", theaterActivity1.getActivityDescription());
    }

    /**
     * Verifies whether the passenger can be removed from the ship.
     * Additionally, it checks if everyone's seat values shift up by one.
     */
    @Test
    void removePassengerTest() {
        cruiseShip1.addPassenger(passenger1);
        cruiseShip1.addPassenger(passenger2);
        cruiseShip1.addPassenger(passenger3);
        cruiseShip1.removePassenger(passenger1);
        assertEquals(2, cruiseShip1.getPassengerList().size());
        assertEquals(0, passenger1.getSeatNumber());
        assertEquals(1, passenger2.getSeatNumber());
        assertEquals(2, passenger3.getSeatNumber());
    }

    /**
     * Verifies whether a passenger can be removed from the ship when they are not on the ship.
     * If they are not on the ship, then the array list's size will be wrong.
     */
    @Test
    void removePassengerNotOnShipTest() {
        cruiseShip1.addPassenger(passenger1);
        cruiseShip1.addPassenger(passenger2);
        cruiseShip1.removePassenger(passenger3);
        assertEquals(2, cruiseShip1.getPassengerList().size());
    }

    /**
     * Verifies whether a person will be able to join an activity if their balance is insufficient
     * If they can, then the participants size will be incorrect.
     */
    @Test
    void noMoneyForActivity() {
        destination1.addActivity(walkingActivity1);
        cruiseShip1.addPassenger(passenger3);
        passenger3.setBalance(0);
        cruiseShip1.joinActivity(passenger3, walkingActivity1, destination1);
        assertEquals(50, walkingActivity1.getActivityCapacity());
        assertEquals(0, walkingActivity1.getParticipants().size());
    }

    /**
     * Double checks whether a passenger can
     */
    @Test
    void seniorityDiscount() {
        destination1.addActivity(walkingActivity1);
        cruiseShip1.addPassenger(passenger4);
        cruiseShip1.joinActivity(passenger4, walkingActivity1, destination1);
        assertEquals(995.5, passenger4.getBalance());
    }

    /**
     * Tests whether a participant can join two activities from the same destination.
     * Since this shouldn't be allowed, the second activity should have no participants
     */
    @Test
    void joinTwoActivitiesInSameDestination() {
        destination1.addActivity(walkingActivity1);
        destination1.addActivity(theaterActivity1);
        cruiseShip1.addPassenger(passenger1);
        cruiseShip1.joinActivity(passenger1, walkingActivity1, destination1);
        cruiseShip1.joinActivity(passenger1, theaterActivity1, destination1);
        assertEquals(1, walkingActivity1.getParticipants().size());
        assertEquals(0, theaterActivity1.getParticipants().size());
    }
}