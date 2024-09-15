package org.example.Classes;

/**
 * Represents driving assistance options for the car, such as cruise control or parking assist.
 */
public class DrivingAssistant {

    private String model;
    private String assistantType;

    /**
     * Constructs a DrivingAssistant with the specified model and type.
     *
     * @param model The model of the driving assistant.
     * @param assistantType The type of driving assistance system.
     */
    public DrivingAssistant(String model, String assistantType) {
        this.model = model;
        this.assistantType = assistantType;
    }

    /**
     * Gets the model of the driving assistant.
     *
     * @return The model of the driving assistant.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the driving assistant.
     *
     * @param model The new model of the driving assistant.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the type of the driving assistant.
     *
     * @return The driving assistant type.
     */
    public String getAssistantType() {
        return assistantType;
    }

    /**
     * Sets the type of the driving assistant.
     *
     * @param assistantType The new driving assistant type.
     */
    public void setAssistantType(String assistantType) {
        this.assistantType = assistantType;
    }

    /**
     * Provides a string representation of the driving assistant.
     *
     * @return A string representation of the driving assistant.
     */
    @Override
    public String toString() {
        return "DrivingAssistant{" +
                "assistantType='" + assistantType + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
