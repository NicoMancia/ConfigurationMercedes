package org.example.Classes;

import java.util.List;

/**
 * Represents the interior configuration of a car.
 * Includes seats, upholstery, ambient lighting, and the steering wheel.
 */
public class Interior {

    private List<Seats> seats;
    private Upholstery upholstery;
    private Ambient ambientLighting;
    private SteeringWheel steeringWheel;

    /**
     * Constructs an Interior object with the specified seats, upholstery, ambient lighting, and steering wheel.
     *
     * @param seats         The list of seats.
     * @param upholstery    The upholstery configuration.
     * @param ambientLighting The ambient lighting configuration.
     * @param steeringWheel The steering wheel configuration.
     */
    public Interior(List<Seats> seats, Upholstery upholstery, Ambient ambientLighting, SteeringWheel steeringWheel) {
        this.seats = seats;
        this.upholstery = upholstery;
        this.ambientLighting = ambientLighting;
        this.steeringWheel = steeringWheel;
    }

    /**
     * Constructs an Interior object with default values.
     */
    public Interior() {
        this.seats = null;
        this.upholstery = null;
        this.ambientLighting = null;
        this.steeringWheel = null;
    }

    /**
     * Gets the list of seats.
     *
     * @return The list of seats.
     */
    public List<Seats> getSeats() {
        return seats;
    }

    /**
     * Sets the list of seats.
     *
     * @param seats The new list of seats.
     */
    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }

    /**
     * Adds a seat to the seat list.
     *
     * @param seats1 The seat to add.
     * @return The updated list of seats.
     */
    public List<Seats> addSeat(Seats seats1) {
        seats.add(seats1);
        return seats;
    }

    /**
     * Gets the steering wheel configuration.
     *
     * @return The steering wheel.
     */
    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    /**
     * Sets the steering wheel configuration.
     *
     * @param steeringWheel The new steering wheel.
     */
    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    /**
     * Gets the upholstery configuration.
     *
     * @return The upholstery configuration.
     */
    public Upholstery getUpholstery() {
        return upholstery;
    }

    /**
     * Sets the upholstery configuration.
     *
     * @param upholstery The new upholstery configuration.
     */
    public void setUpholstery(Upholstery upholstery) {
        this.upholstery = upholstery;
    }

    /**
     * Gets the ambient lighting configuration.
     *
     * @return The ambient lighting configuration.
     */
    public Ambient getAmbientLighting() {
        return ambientLighting;
    }

    /**
     * Sets the ambient lighting configuration.
     *
     * @param ambientLighting The new ambient lighting configuration.
     */
    public void setAmbientLighting(Ambient ambientLighting) {
        this.ambientLighting = ambientLighting;
    }

    /**
     * Provides a string representation of the interior configuration.
     *
     * @return A string representation of the interior.
     */
    @Override
    public String toString() {
        return "Interior{" +
                "seats=" + seats +
                ", upholstery=" + upholstery +
                ", ambientLighting=" + ambientLighting +
                '}';
    }
}
