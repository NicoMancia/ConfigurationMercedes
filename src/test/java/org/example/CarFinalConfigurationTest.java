package org.example;

import org.example.Classes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarFinalConfigurationTest {

    @Test
    public void testFinalCarConfiguration() {
        Car car = new Car("ClasseCBerlina");

        Engine engine = new Engine("C220d", "500HP", "12L/100km");
        Seats seats = new Seats("LuxurySeats", "Leather");
        Transmission transmission = new Transmission("Automatic");
        Paint paint = new Paint("Black", "Matte");

        car.setEngine(engine);
        car.getInterior().addSeat(seats);
        car.setTransmission(transmission);
        car.getExterior().setPaint(paint);

        assertEquals("C220d", car.getEngine().getModel(), "The engine model should be C220d");
        assertEquals(1, car.getInterior().getSeats().size(), "There should be 1 seat in the interior");
        assertEquals("Leather", car.getInterior().getSeats().get(0).getSeatOptional(), "The seat material should be Leather");
        assertEquals("Automatic", car.getTransmission().getTransmissionType(), "The transmission type should be Automatic");
        assertEquals("Black", car.getExterior().getPaint().getColor(), "The paint color should be Black");

        assertEquals("ClasseCBerlina", car.getModel(), "The car model should be ClasseCBerlina");

        assertEquals("Matte", car.getExterior().getPaint().getType(), "The paint type should be Matte");
    }

    @Test
    public void testMultipleSeatsAndDrivingAssistantConfiguration() {
        Car car = new Car("ClasseCBerlina");

        Seats seat1 = new Seats("SportSeat", "Fabric");
        Seats seat2 = new Seats("ComfortSeat", "Leather");
        DrivingAssistant assistant1 = new DrivingAssistant("Assistant1", "Lane Assist");
        DrivingAssistant assistant2 = new DrivingAssistant("Assistant2", "Adaptive Cruise Control");

        car.getInterior().addSeat(seat1);
        car.getInterior().addSeat(seat2);
        car.getOptionals().addDrivingAssistant(assistant1);
        car.getOptionals().addDrivingAssistant(assistant2);

        assertEquals(2, car.getInterior().getSeats().size(), "There should be 2 seats in the interior");
        assertTrue(car.getInterior().getSeats().stream().anyMatch(seat -> seat.getSeatOptional().equals("Fabric")),
                "There should be a seat with Fabric material");
        assertTrue(car.getInterior().getSeats().stream().anyMatch(seat -> seat.getSeatOptional().equals("Leather")),
                "There should be a seat with Leather material");

        assertEquals(2, car.getOptionals().getDrivingAssistant().size(), "There should be 2 driving assistants");
        assertTrue(car.getOptionals().getDrivingAssistant().stream().anyMatch(da -> da.getAssistantType().equals("Lane Assist")),
                "There should be a Lane Assist driving assistant");
        assertTrue(car.getOptionals().getDrivingAssistant().stream().anyMatch(da -> da.getAssistantType().equals("Adaptive Cruise Control")),
                "There should be an Adaptive Cruise Control driving assistant");
    }
}
