package org.example.Classes;

/**
 * Represents the safety package of the car, such as airbags or pedestrian protection.
 */
public class Safety {

    private String safetyPackage;

    /**
     * Constructs a Safety object with the specified safety package.
     *
     * @param safetyPackage The type of safety package.
     */
    public Safety(String safetyPackage) {
        this.safetyPackage = safetyPackage;
    }

    /**
     * Gets the safety package type.
     *
     * @return The safety package type.
     */
    public String getSafetyPackage() {
        return safetyPackage;
    }

    /**
     * Sets the safety package type.
     *
     * @param safetyPackage The new safety package type.
     */
    public void setSafetyPackage(String safetyPackage) {
        this.safetyPackage = safetyPackage;
    }

    /**
     * Provides a string representation of the safety feature.
     *
     * @return A string representation of the safety feature.
     */
    @Override
    public String toString() {
        return "Safety{" +
                "safetyPackage='" + safetyPackage + '\'' +
                '}';
    }
}
