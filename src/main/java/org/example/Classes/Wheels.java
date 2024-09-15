package org.example.Classes;

/**
 * Represents the wheels of a car, including diameter and model.
 */
public class Wheels {

    private String diameter;
    private String model;

    /**
     * Constructs a Wheels object with the specified diameter and model.
     *
     * @param diameter The diameter of the wheels.
     * @param model    The model of the wheels.
     */
    public Wheels(String diameter, String model) {
        this.diameter = diameter;
        this.model = model;
    }

    /**
     * Gets the diameter of the wheels.
     *
     * @return The wheels' diameter.
     */
    public String getDiameter() {
        return diameter;
    }

    /**
     * Sets the diameter of the wheels.
     *
     * @param diameter The new wheels' diameter.
     */
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    /**
     * Gets the model of the wheels.
     *
     * @return The wheels' model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the wheels.
     *
     * @param model The new wheels' model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Provides a string representation of the wheels configuration.
     *
     * @return A string representation of the wheels.
     */
    @Override
    public String toString() {
        return "Wheels{" +
                "diameter='" + diameter + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
