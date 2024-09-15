package org.example.Classes;

/**
 * Represents the steering wheel in the car's interior.
 */
public class SteeringWheel {

    private String descr;
    private String model;

    /**
     * Constructs a SteeringWheel object with the specified model and description.
     *
     * @param model The model of the steering wheel.
     * @param descr The description of the steering wheel's features.
     */
    public SteeringWheel(String model, String descr) {
        this.descr = descr;
        this.model = model;
    }

    /**
     * Gets the model of the steering wheel.
     *
     * @return The steering wheel model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the steering wheel.
     *
     * @param model The new steering wheel model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the description of the steering wheel's features.
     *
     * @return The description of the steering wheel's features.
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the description of the steering wheel's features.
     *
     * @param descr The new description.
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * Provides a string representation of the steering wheel.
     *
     * @return A string representation of the steering wheel.
     */
    @Override
    public String toString() {
        return "SteeringWheel{" +
                "steeringWheelOptional='" + descr + '\'' +
                ", model='" + descr + '\'' +
                '}';
    }
}
