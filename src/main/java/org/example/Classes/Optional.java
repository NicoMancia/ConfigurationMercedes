package org.example.Classes;

import java.util.List;

/**
 * Represents optional features that can be configured for a car.
 * Includes safety features and driving assistants.
 */
public class Optional {

    private Safety safety;
    private List<DrivingAssistant> drivingAssistant;

    /**
     * Constructs an Optional object with specified safety and driving assistant features.
     *
     * @param safety          The safety feature.
     * @param drivingAssistant The list of driving assistant features.
     */
    public Optional(Safety safety, List<DrivingAssistant> drivingAssistant) {
        this.safety = safety;
        this.drivingAssistant = drivingAssistant;
    }

    /**
     * Constructs an Optional object with default values.
     */
    public Optional() {
        this.safety = null;
        this.drivingAssistant = null;
    }

    /**
     * Gets the safety feature.
     *
     * @return The safety feature.
     */
    public Safety getSafety() {
        return safety;
    }

    /**
     * Sets the safety feature.
     *
     * @param safety The new safety feature.
     */
    public void setSafety(Safety safety) {
        this.safety = safety;
    }

    /**
     * Gets the list of driving assistant features.
     *
     * @return The list of driving assistants.
     */
    public List<DrivingAssistant> getDrivingAssistant() {
        return drivingAssistant;
    }

    /**
     * Sets the list of driving assistant features.
     *
     * @param drivingAssistant The new list of driving assistants.
     */
    public void setDrivingAssistant(List<DrivingAssistant> drivingAssistant) {
        this.drivingAssistant = drivingAssistant;
    }

    /**
     * Adds a driving assistant to the list.
     *
     * @param drivingAssistant1 The driving assistant to add.
     * @return The updated list of driving assistants.
     */
    public List<DrivingAssistant> addDrivingAssistant(DrivingAssistant drivingAssistant1) {
        drivingAssistant.add(drivingAssistant1);
        return drivingAssistant;
    }

    /**
     * Provides a string representation of the optional features.
     *
     * @return A string representation of the optional features.
     */
    @Override
    public String toString() {
        return "Optional{" +
                "safety=" + safety +
                ", drivingAssistant=" + drivingAssistant +
                '}';
    }
}
