package org.example.Classes;

/**
 * Represents the headlights of a car, including the model and type.
 */
public class Headlights {

    private String model;
    private String descr;

    /**
     * Constructs a Headlights object with the specified model and description.
     *
     * @param model The model of the headlights.
     * @param descr The description of the headlights (e.g., LED, DIGITAL LIGHT).
     */
    public Headlights(String model, String descr) {
        this.model = model;
        this.descr = descr;
    }

    /**
     * Gets the model of the headlights.
     *
     * @return The headlights model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the headlights.
     *
     * @param model The new headlights model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the description of the headlights.
     *
     * @return The headlights description.
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the description of the headlights.
     *
     * @param descr The new description.
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * Provides a string representation of the headlights configuration.
     *
     * @return A string representation of the headlights.
     */
    @Override
    public String toString() {
        return "Headlights{" +
                "model='" + model + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
