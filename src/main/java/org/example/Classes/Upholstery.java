package org.example.Classes;

/**
 * Represents the upholstery material and color for the interior of the car.
 */
public class Upholstery {

    private String model;
    private String color;
    private String material;

    /**
     * Constructs an Upholstery object with the specified model, color, and material.
     *
     * @param model    The model of the upholstery.
     * @param color    The color of the upholstery.
     * @param material The material of the upholstery (e.g., leather, fabric).
     */
    public Upholstery(String model, String color, String material) {
        this.model = model;
        this.color = color;
        this.material = material;
    }

    /**
     * Gets the model of the upholstery.
     *
     * @return The model of the upholstery.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the upholstery.
     *
     * @param model The new model of the upholstery.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the color of the upholstery.
     *
     * @return The color of the upholstery.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the upholstery.
     *
     * @param color The new color of the upholstery.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the material of the upholstery.
     *
     * @return The material of the upholstery.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the material of the upholstery.
     *
     * @param material The new material of the upholstery.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Provides a string representation of the upholstery configuration.
     *
     * @return A string representation of the upholstery.
     */
    @Override
    public String toString() {
        return "Upholstery{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
