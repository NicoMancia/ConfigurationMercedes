package org.example.Classes;

/**
 * Represents the ambient lighting configuration inside the car.
 */
public class Ambient {

    private String lightingType;
    private String descr;

    /**
     * Constructs an Ambient object with the specified lighting type and description.
     *
     * @param lightingType The type of ambient lighting (e.g., 3-zone lighting).
     * @param descr A description of the ambient lighting.
     */
    public Ambient(String lightingType, String descr) {
        this.lightingType = lightingType;
        this.descr = descr;
    }

    /**
     * Gets the type of ambient lighting.
     *
     * @return The lighting type.
     */
    public String getLightingType() {
        return lightingType;
    }

    /**
     * Sets the type of ambient lighting.
     *
     * @param lightingType The new lighting type.
     */
    public void setLightingType(String lightingType) {
        this.lightingType = lightingType;
    }

    /**
     * Gets the description of the ambient lighting.
     *
     * @return The description.
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the description of the ambient lighting.
     *
     * @param descr The new description.
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * Provides a string representation of the ambient lighting configuration.
     *
     * @return A string representation of the ambient lighting.
     */
    @Override
    public String toString() {
        return "Ambient{" +
                "lightingType='" + lightingType + '\'' +
                ", description='" + descr + '\'' +
                '}';
    }
}
