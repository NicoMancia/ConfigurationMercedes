package org.example.Classes;

import java.util.Objects;

/**
 * Represents the exterior features of a car, including paint, headlights, and wheels.
 */
public class Exterior {

    private Paint paint;
    private Headlights headlights;
    private Wheels wheels;

    /**
     * Constructs an Exterior object with default values.
     */
    public Exterior() {
        this.paint = null;
        this.headlights = null;
        this.wheels = null;
    }

    /**
     * Gets the paint configuration.
     *
     * @return The paint configuration.
     */
    public Paint getPaint() {
        return paint;
    }

    /**
     * Sets the paint configuration.
     *
     * @param paint The new paint configuration.
     */
    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    /**
     * Gets the headlights configuration.
     *
     * @return The headlights configuration.
     */
    public Headlights getHeadlights() {
        return headlights;
    }

    /**
     * Sets the headlights configuration.
     *
     * @param headlights The new headlights configuration.
     */
    public void setHeadlights(Headlights headlights) {
        this.headlights = headlights;
    }

    /**
     * Gets the wheels configuration.
     *
     * @return The wheels configuration.
     */
    public Wheels getWheels() {
        return wheels;
    }

    /**
     * Sets the wheels configuration.
     *
     * @param wheels The new wheels configuration.
     */
    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    /**
     * Provides a string representation of the exterior configuration.
     *
     * @return A string representation of the exterior.
     */
    @Override
    public String toString() {
        return "Exterior{" +
                "paint=" + paint +
                ", headlights=" + headlights +
                ", wheels=" + wheels +
                '}';
    }

}
