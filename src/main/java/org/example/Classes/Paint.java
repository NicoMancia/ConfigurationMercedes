package org.example.Classes;

/**
 * Represents the paint of a car, including the color and type.
 */
public class Paint {

    private String color;
    private String type;

    /**
     * Constructs a Paint object with the specified color and type.
     *
     * @param color The color of the paint.
     * @param type  The type of the paint (e.g., metallic, matte).
     */
    public Paint(String color, String type) {
        this.color = color;
        this.type = type;
    }

    /**
     * Gets the color of the paint.
     *
     * @return The paint color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the paint.
     *
     * @param color The new paint color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the type of the paint.
     *
     * @return The paint type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the paint.
     *
     * @param type The new paint type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Provides a string representation of the paint configuration.
     *
     * @return A string representation of the paint.
     */
    @Override
    public String toString() {
        return "Paint{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
