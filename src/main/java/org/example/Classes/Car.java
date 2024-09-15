package org.example.Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Car based on the ontology "Car Configuration".
 * Contains various components such as engine, transmission, interior, exterior, and optional features.
 */
public class Car {

    private String model;
    private Engine engine;
    private Transmission transmission;
    private Interior interior;
    private Exterior exterior;
    private Optional optionals;

    /**
     * Constructs a Car with the specified model.
     * Initializes the interior, exterior, and optional components.
     *
     * @param model The model of the car.
     */
    public Car(String model) {
        this.model = model;
        this.engine = null;
        this.transmission = null;
        this.interior = new Interior(new ArrayList<>(), null, null, null);
        this.exterior = new Exterior();
        this.optionals = new Optional(null, new ArrayList<>());
    }

    /**
     * Gets the model of the car.
     *
     * @return The model of the car.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the car.
     *
     * @param model The new model of the car.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the engine of the car.
     *
     * @return The engine of the car.
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Sets the engine of the car.
     *
     * @param engine The new engine of the car.
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * Gets the transmission of the car.
     *
     * @return The transmission of the car.
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     * Sets the transmission of the car.
     *
     * @param transmission The new transmission of the car.
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    /**
     * Gets the interior configuration of the car.
     *
     * @return The interior configuration.
     */
    public Interior getInterior() {
        return interior;
    }

    /**
     * Sets the interior configuration of the car.
     *
     * @param interior The new interior configuration.
     */
    public void setInterior(Interior interior) {
        this.interior = interior;
    }

    /**
     * Gets the exterior configuration of the car.
     *
     * @return The exterior configuration.
     */
    public Exterior getExterior() {
        return exterior;
    }

    /**
     * Sets the exterior configuration of the car.
     *
     * @param exterior The new exterior configuration.
     */
    public void setExterior(Exterior exterior) {
        this.exterior = exterior;
    }

    /**
     * Gets the optional features of the car.
     *
     * @return The optional features.
     */
    public Optional getOptionals() {
        return optionals;
    }

    /**
     * Sets the optional features of the car.
     *
     * @param optionals The new optional features.
     */
    public void setOptionals(Optional optionals) {
        this.optionals = optionals;
    }

    /**
     * Provides a string representation of the car, including all its components.
     *
     * @return A string representation of the car.
     */
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine=" + engine +
                ", transmission=" + transmission +
                ", interior=" + interior +
                ", exterior=" + exterior +
                ", optionals=" + optionals +
                '}';
    }
}
