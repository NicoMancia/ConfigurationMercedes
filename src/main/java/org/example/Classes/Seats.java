package org.example.Classes;

/**
 * Represents the seat configuration in a car, including options such as massaging or heated seats.
 */
public class Seats {

    private String seatOptional;
    private String model;

    /**
     * Constructs a Seats object with the specified model and optional feature.
     *
     * @param model        The seat model.
     * @param seatOptional The optional feature of the seat.
     */
    public Seats(String model, String seatOptional) {
        this.seatOptional = seatOptional;
        this.model = model;
    }

    /**
     * Gets the model of the seat.
     *
     * @return The seat model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the seat.
     *
     * @param model The new seat model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the optional feature of the seat.
     *
     * @return The optional feature.
     */
    public String getSeatOptional() {
        return seatOptional;
    }

    /**
     * Sets the optional feature of the seat.
     *
     * @param seatOptional The new optional feature.
     */
    public void setSeatOptional(String seatOptional) {
        this.seatOptional = seatOptional;
    }

    /**
     * Provides a string representation of the seat configuration.
     *
     * @return A string representation of the seat configuration.
     */
    @Override
    public String toString() {
        return "Seats{" +
                "seatOptional='" + seatOptional + '\'' +
                '}';
    }
}
