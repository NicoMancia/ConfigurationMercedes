package org.example.Classes;

/**
 * Represents an engine in the car configuration system.
 */
public class Engine {

    private final String model;
    private final String power;
    private final String fuelConsumption;

    /**
     * Constructs an Engine object with the specified model, power, and fuel consumption.
     *
     * @param model           The model of the engine.
     * @param power           The power output of the engine.
     * @param fuelConsumption The fuel consumption of the engine.
     */
    public Engine(String model, String power, String fuelConsumption) {
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Gets the model of the engine.
     *
     * @return The engine model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the power output of the engine.
     *
     * @return The power output.
     */
    public String getPower() {
        return power;
    }

    /**
     * Gets the fuel consumption of the engine.
     *
     * @return The fuel consumption.
     */
    public String getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Provides a string representation of the engine configuration.
     *
     * @return A string representation of the engine.
     */
    @Override
    public String toString() {
        return "Engine{" +
                "model='" + model + '\'' +
                ", power='" + power + '\'' +
                ", fuelConsumption='" + fuelConsumption + '\'' +
                '}';
    }
}
