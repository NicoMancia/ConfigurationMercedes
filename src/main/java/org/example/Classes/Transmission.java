package org.example.Classes;

/**
 * Represents the transmission of a car.
 */
public class Transmission {

    private String transmissionType;

    /**
     * Constructs a Transmission object with the specified type.
     *
     * @param transmissionType The type of the transmission (e.g., manual, automatic).
     */
    public Transmission(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    /**
     * Gets the type of the transmission.
     *
     * @return The transmission type.
     */
    public String getTransmissionType() {
        return transmissionType;
    }

    /**
     * Sets the type of the transmission.
     *
     * @param transmissionType The new transmission type.
     */
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    /**
     * Provides a string representation of the transmission.
     *
     * @return A string representation of the transmission.
     */
    @Override
    public String toString() {
        return "Transmission{" +
                "transmissionType='" + transmissionType + '\'' +
                '}';
    }
}
