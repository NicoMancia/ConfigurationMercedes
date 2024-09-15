package org.example.JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Ontology.CarComponentQueryService;
import org.apache.jena.ontology.OntModel;
import org.example.Classes.*;
import org.example.Ontology.CarSPARQLQueryExecutor;
import org.example.Ontology.OntologyLoader;

import java.util.List;
import java.util.Locale;

/**
 * The CarConfigurationApp class is a JavaFX application that allows users to configure a
 * Mercedes Class C Berlina model by selecting various components such as engine, exterior,
 * interior, and other optional features. The application fetches data from an ontology
 * to provide the available options for each component.
 */
public class CarConfigurationApp extends Application {

    private Car car;
    private CarComponentQueryService queryService;

    /**
     * Starts the JavaFX application, setting up the primary stage and initializing
     * the ontology model to provide car configuration options.
     *
     * @param primaryStage The primary stage for this JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(Locale.ENGLISH);
        primaryStage.setTitle("Mercedes Class C Berlina Configurator");

        // Load ontology
        String ontologyFilePath = "OntologiaMercedes.rdf";
        OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
        OntModel model = ontologyLoader.getOntologyModel();

        if (model != null) {
            CarSPARQLQueryExecutor queryExecutor = new CarSPARQLQueryExecutor(model);
            queryService = new CarComponentQueryService(queryExecutor);
            car = queryService.getCarModel();

            // Main layout
            VBox mainLayout = new VBox(15);
            mainLayout.setPadding(new Insets(20, 40, 20, 40));

            // Title
            Label titleLabel = new Label("Mercedes Class C Berlina Configurator");
            titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");

            // TabPane for component configuration
            TabPane tabPane = new TabPane();
            tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

            // Create tabs for each section of the configuration
            Tab engineTab = createEngineTab();
            Tab exteriorTab = createExteriorTab();
            Tab interiorTab = createInteriorTab();
            Tab optionalTab = createOptionalTab();
            Tab transmissionTab = createTransmissionTab();

            // Add tabs to the TabPane
            tabPane.getTabs().addAll(engineTab, exteriorTab, interiorTab, optionalTab, transmissionTab);

            // Final Configuration button
            Button finalizeButton = new Button("Show Final Configuration");
            finalizeButton.setStyle(
                    "-fx-background-color: #2196F3;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 16px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-border-radius: 10px;" +
                            "-fx-padding: 10 20 10 20;"
            );
            finalizeButton.setOnAction(e -> displayFinalConfiguration());

            mainLayout.getChildren().addAll(titleLabel, tabPane, finalizeButton);
            Scene scene = new Scene(mainLayout, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            showError("Error loading the ontology.");
        }
    }

    /**
     * Creates the tab for selecting the engine of the car. The user can choose
     * from available engine options provided by the ontology.
     *
     * @return The tab for engine configuration.
     */
    private Tab createEngineTab() {
        Tab engineTab = new Tab("Engine");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        List<Engine> engines = queryService.getEngineComponents(car);
        if (engines.isEmpty()) {
            layout.getChildren().add(new Label("No engine options available."));
        } else {
            ChoiceBox<Engine> engineChoice = new ChoiceBox<>();
            engineChoice.getItems().addAll(engines);
            engineChoice.setValue(engines.get(0));

            Button selectEngineButton = new Button("Select Engine");
            selectEngineButton.setOnAction(e -> {
                car.setEngine(engineChoice.getValue());
                showSuccess("Engine selected: " + engineChoice.getValue().getModel());
            });

            layout.getChildren().addAll(new Label("Choose Engine"), engineChoice, selectEngineButton);
        }
        engineTab.setContent(layout);
        return engineTab;
    }

    /**
     * Creates the tab for configuring the exterior of the car. The user can choose
     * from options like paint color, wheels, headlights, and ambient lighting.
     *
     * @return The tab for exterior configuration.
     */
    private Tab createExteriorTab() {
        Tab exteriorTab = new Tab("Exterior");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Paint selection
        List<Paint> paints = queryService.getColorOptions(car);
        if (!paints.isEmpty()) {
            ChoiceBox<Paint> paintChoice = new ChoiceBox<>();
            paintChoice.getItems().addAll(paints);
            paintChoice.setValue(paints.get(0));

            Button selectPaintButton = new Button("Select Paint");
            selectPaintButton.setOnAction(e -> {
                car.getExterior().setPaint(paintChoice.getValue());
                showSuccess("Paint selected: " + paintChoice.getValue().getColor());
            });

            layout.getChildren().addAll(new Label("Choose Paint Color"), paintChoice, selectPaintButton);
        }

        // Wheels selection
        List<Wheels> wheelsOptions = queryService.getWheelOptions(car);
        if (!wheelsOptions.isEmpty()) {
            ChoiceBox<Wheels> wheelsChoice = new ChoiceBox<>();
            wheelsChoice.getItems().addAll(wheelsOptions);
            wheelsChoice.setValue(wheelsOptions.get(0));

            Button selectWheelsButton = new Button("Select Wheels");
            selectWheelsButton.setOnAction(e -> {
                car.getExterior().setWheels(wheelsChoice.getValue());
                showSuccess("Wheels selected: " + wheelsChoice.getValue().getModel());
            });

            layout.getChildren().addAll(new Label("Choose Wheels"), wheelsChoice, selectWheelsButton);
        }

        // Headlights selection
        List<Headlights> headlightsOptions = queryService.getHeadlightOptions(car);
        if (!headlightsOptions.isEmpty()) {
            ChoiceBox<Headlights> headlightsChoice = new ChoiceBox<>();
            headlightsChoice.getItems().addAll(headlightsOptions);
            headlightsChoice.setValue(headlightsOptions.get(0));

            Button selectHeadlightsButton = new Button("Select Headlights");
            selectHeadlightsButton.setOnAction(e -> {
                car.getExterior().setHeadlights(headlightsChoice.getValue());
                showSuccess("Headlights selected: " + headlightsChoice.getValue().getModel());
            });

            layout.getChildren().addAll(new Label("Choose Headlights"), headlightsChoice, selectHeadlightsButton);
        }

        exteriorTab.setContent(layout);
        return exteriorTab;
    }

    /**
     * Creates the tab for configuring the interior of the car, including upholstery, seats,
     * and steering wheel options.
     *
     * @return The tab for interior configuration.
     */
    private Tab createInteriorTab() {
        Tab interiorTab = new Tab("Interior");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Upholstery selection
        List<Upholstery> upholsteries = queryService.getUpholsteryOptions(car);
        if (!upholsteries.isEmpty()) {
            ChoiceBox<Upholstery> upholsteryChoice = new ChoiceBox<>();
            upholsteryChoice.getItems().addAll(upholsteries);
            upholsteryChoice.setValue(upholsteries.get(0));

            Button selectUpholsteryButton = new Button("Select Upholstery");
            selectUpholsteryButton.setOnAction(e -> {
                car.getInterior().setUpholstery(upholsteryChoice.getValue());
                showSuccess("Upholstery selected: " + upholsteryChoice.getValue().getColor());
            });

            layout.getChildren().addAll(new Label("Choose Upholstery"), upholsteryChoice, selectUpholsteryButton);
        }

        // Seats selection (multi-selection)
        List<Seats> seatsOptions = queryService.getSeatOptions(car);
        if (!seatsOptions.isEmpty()) {
            ListView<Seats> seatsListView = new ListView<>();
            seatsListView.getItems().addAll(seatsOptions);
            seatsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);  // Enable multi-selection

            Button selectSeatsButton = new Button("Select Seats");
            selectSeatsButton.setOnAction(e -> {
                List<Seats> selectedSeats = seatsListView.getSelectionModel().getSelectedItems();
                if (!selectedSeats.isEmpty()) {
                    for (Seats seat : selectedSeats) {
                        car.getInterior().addSeat(seat);
                    }
                    showSuccess(selectedSeats.size() + " seat(s) selected.");
                } else {
                    showError("Please select at least one seat.");
                }
            });

            layout.getChildren().addAll(new Label("Choose Seats (multiple selection)"), seatsListView, selectSeatsButton);
        }

        interiorTab.setContent(layout);
        return interiorTab;
    }

    /**
     * Creates the tab for configuring optional features like driving assistants and safety features.
     *
     * @return The tab for optional configuration.
     */
    private Tab createOptionalTab() {
        Tab optionalTab = new Tab("Optional");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Driving assistant selection (multi-selection)
        List<DrivingAssistant> assistants = queryService.getDrivingAssistantOptions(car);
        if (!assistants.isEmpty()) {
            ListView<DrivingAssistant> assistantListView = new ListView<>();
            assistantListView.getItems().addAll(assistants);
            assistantListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);  // Enable multi-selection

            Button selectAssistantButton = new Button("Select Driving Assistants");
            selectAssistantButton.setOnAction(e -> {
                List<DrivingAssistant> selectedAssistants = assistantListView.getSelectionModel().getSelectedItems();
                if (!selectedAssistants.isEmpty()) {
                    for (DrivingAssistant assistant : selectedAssistants) {
                        car.getOptionals().addDrivingAssistant(assistant);
                    }
                    showSuccess(selectedAssistants.size() + " driving assistant(s) selected.");
                } else {
                    showError("Please select at least one driving assistant.");
                }
            });

            layout.getChildren().addAll(new Label("Choose Driving Assistants (multiple selection)"), assistantListView, selectAssistantButton);
        }

        optionalTab.setContent(layout);
        return optionalTab;
    }

    /**
     * Creates the tab for configuring the transmission of the car.
     *
     * @return The tab for transmission configuration.
     */
    private Tab createTransmissionTab() {
        Tab transmissionTab = new Tab("Transmission");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        List<Transmission> transmissions = queryService.getTransmissionOptions(car);
        if (transmissions.isEmpty()) {
            layout.getChildren().add(new Label("No transmission options available."));
        } else {
            ChoiceBox<Transmission> transmissionChoice = new ChoiceBox<>();
            transmissionChoice.getItems().addAll(transmissions);
            transmissionChoice.setValue(transmissions.get(0));

            Button selectTransmissionButton = new Button("Select Transmission");
            selectTransmissionButton.setOnAction(e -> {
                car.setTransmission(transmissionChoice.getValue());
                showSuccess("Transmission selected: " + transmissionChoice.getValue().getTransmissionType());
            });

            layout.getChildren().addAll(new Label("Choose Transmission"), transmissionChoice, selectTransmissionButton);
        }
        transmissionTab.setContent(layout);
        return transmissionTab;
    }

    /**
     * Displays the final car configuration in a popup, summarizing all the selected components.
     */
    private void displayFinalConfiguration() {
        StringBuilder configSummary = new StringBuilder("Final Car Configuration:\n");
        configSummary.append("Model: ").append(car.getModel()).append("\n");

        if (car.getEngine() != null) {
            configSummary.append("Engine: ").append(car.getEngine().getModel()).append("\n");
        }

        if (car.getExterior() != null && car.getExterior().getPaint() != null) {
            configSummary.append("Exterior Paint: ").append(car.getExterior().getPaint().getColor()).append("\n");
        }

        if (car.getInterior() != null && car.getInterior().getUpholstery() != null) {
            configSummary.append("Upholstery: ").append(car.getInterior().getUpholstery().getColor()).append("\n");
        }

        if (car.getInterior() != null && car.getInterior().getSeats() != null) {
            configSummary.append("Seats: ");
            for (Seats seat : car.getInterior().getSeats()) {
                configSummary.append(seat.getModel()).append(", ");
            }
            configSummary.setLength(configSummary.length() - 2);  // Remove trailing comma
            configSummary.append("\n");
        }

        if (car.getTransmission() != null) {
            configSummary.append("Transmission: ").append(car.getTransmission().getTransmissionType()).append("\n");
        }

        if (car.getOptionals() != null && !car.getOptionals().getDrivingAssistant().isEmpty()) {
            configSummary.append("Driving Assistants: ");
            for (DrivingAssistant assistant : car.getOptionals().getDrivingAssistant()) {
                configSummary.append(assistant.getAssistantType()).append(", ");
            }
            configSummary.setLength(configSummary.length() - 2);  // Remove trailing comma
            configSummary.append("\n");
        }

        if (car.getOptionals() != null && car.getOptionals().getSafety() != null) {
            configSummary.append("Safety: ").append(car.getOptionals().getSafety().getSafetyPackage()).append("\n");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Final Configuration");
        alert.setHeaderText("Here is your final car configuration:");
        alert.setContentText(configSummary.toString());
        alert.showAndWait();
    }

    /**
     * Displays an error alert with the specified message.
     *
     * @param message The error message to display.
     */
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Displays a success alert with the specified message.
     *
     * @param message The success message to display.
     */
    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * The main method is the entry point for the JavaFX application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
