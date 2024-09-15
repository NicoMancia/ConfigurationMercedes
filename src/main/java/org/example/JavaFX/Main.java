package org.example.JavaFX;

import org.example.Ontology.CarComponentQueryService;
import org.example.Ontology.CarSPARQLQueryExecutor;
import org.apache.jena.ontology.OntModel;
import org.example.Classes.*;
import org.example.Ontology.OntologyLoader;

import java.util.*;

/**
 * Main class for configuring a car using a command-line interface.
 * This class allows the user to load an ontology, select a car model,
 * and configure various aspects of the car such as engine, exterior,
 * interior, transmission, and optional features.
 */
public class Main {

    /**
     * Main method to load the ontology and start the car configuration process.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Load Ontology
        String ontologyFilePath = "OntologiaMercedes.rdf";
        OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
        OntModel model = ontologyLoader.getOntologyModel();

        if (model != null) {
            CarSPARQLQueryExecutor queryExecutor = new CarSPARQLQueryExecutor(model);
            CarComponentQueryService queryService = new CarComponentQueryService(queryExecutor);

            Car car = createCar(queryService);

            if (car != null) {
                Scanner scanner = new Scanner(System.in);
                configureCar(car, queryService, scanner);
                displayFinalConfiguration(car);
                scanner.close();
            } else {
                System.out.println("Errore: il modello dell'auto non è stato trovato.");
            }
        } else {
            System.out.println("Errore durante il caricamento dell'ontologia.");
        }
    }

    /**
     * Creates a car object by querying the ontology for the "ClasseCBerlina" model.
     *
     * @param queryService The service used to query car components.
     * @return A Car object representing the selected car model, or null if not found.
     */
    private static Car createCar(CarComponentQueryService queryService) {
        Car car = queryService.getCarModel();

        if (car != null) {
            System.out.println("Modello di auto selezionato: " + car.getModel());
            return car;
        } else {
            System.out.println("Errore: il modello Classe G Berlina non è stato trovato nell'ontologia.");
            return null;
        }
    }

    /**
     * Configures the car by allowing the user to choose components through the command-line interface.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureCar(Car car, CarComponentQueryService queryService, Scanner scanner) {
        boolean configMenuActive = true;
        while (configMenuActive) {
            int choice = displayMainMenu(scanner);
            switch (choice) {
                case 1:
                    configureEngine(car, queryService, scanner);
                    break;
                case 2:
                    configureExterior(car, queryService, scanner);
                    break;
                case 3:
                    configureInterior(car, queryService, scanner);
                    break;
                case 4:
                    configureOptional(car, queryService, scanner);
                    break;
                case 5:
                    configureTransmission(car, queryService, scanner);
                    break;
                case 0:
                    configMenuActive = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    /**
     * Displays the main menu for car configuration.
     *
     * @param scanner The scanner to read user input.
     * @return The user's menu choice.
     */
    private static int displayMainMenu(Scanner scanner) {
        System.out.println("Che cosa vuoi configurare? Seleziona un'opzione:");
        System.out.println("1. Motore");
        System.out.println("2. Esterni");
        System.out.println("3. Interni");
        System.out.println("4. Optional");
        System.out.println("5. Trasmissioni");
        System.out.println("0. Fine configurazione");

        return getUserChoice(scanner, 5);
    }

    /**
     * Configures the exterior components of the car, such as headlights, paint, and wheels.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureExterior(Car car, CarComponentQueryService queryService, Scanner scanner) {
        boolean esterniMenuActive = true;
        while (esterniMenuActive) {
            int choice = displayExteriorMenu(scanner);
            switch (choice) {
                case 1:
                    configureHeadLight(car, queryService, scanner);
                    break;
                case 2:
                    configurePaint(car, queryService, scanner);
                    break;
                case 3:
                    configureWheels(car, queryService, scanner);
                    break;
                case 0:
                    esterniMenuActive = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    /**
     * Displays the exterior configuration menu.
     *
     * @param scanner The scanner to read user input.
     * @return The user's menu choice for exterior configuration.
     */
    private static int displayExteriorMenu(Scanner scanner) {
        System.out.println("Quale categoria di esterni vuoi configurare? Seleziona un'opzione:");
        System.out.println("1. Fanali");
        System.out.println("2. Verniciatura");
        System.out.println("3. Cerchi");
        System.out.println("0. Torna indietro");

        return getUserChoice(scanner, 3);
    }

    /**
     * Configures the interior components of the car, such as seats, steering wheel, and upholstery.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureInterior(Car car, CarComponentQueryService queryService, Scanner scanner) {
        boolean interniMenuActive = true;
        while (interniMenuActive) {
            int choice = displayInteriorMenu(scanner);
            switch (choice) {
                case 1:
                    configureAmbient(car, queryService, scanner);
                    break;
                case 2:
                    configureSeats(car, queryService, scanner);
                    break;
                case 3:
                    configureSteeringWheel(car, queryService, scanner);
                    break;
                case 4:
                    configureUpholstery(car, queryService, scanner);
                    break;
                case 0:
                    interniMenuActive = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    /**
     * Displays the interior configuration menu.
     *
     * @param scanner The scanner to read user input.
     * @return The user's menu choice for interior configuration.
     */
    private static int displayInteriorMenu(Scanner scanner) {
        System.out.println("Quale categoria di interni vuoi configurare? Seleziona un'opzione:");
        System.out.println("1. Ambiente");
        System.out.println("2. Sedili");
        System.out.println("3. Volante");
        System.out.println("4. Rivestimenti");
        System.out.println("0. Torna indietro");

        return getUserChoice(scanner, 4);
    }

    /**
     * Configures the optional features of the car, such as driving assistant and safety packages.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureOptional(Car car, CarComponentQueryService queryService, Scanner scanner) {
        boolean optionalMenuActive = true;
        while (optionalMenuActive) {
            int choice = displayOptionalMenu(scanner);
            switch (choice) {
                case 1:
                    configureDrivingAssistant(car, queryService, scanner);
                    break;
                case 2:
                    configureSafety(car, queryService, scanner);
                    break;
                case 0:
                    optionalMenuActive = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    /**
     * Displays the optional configuration menu.
     *
     * @param scanner The scanner to read user input.
     * @return The user's menu choice for optional configuration.
     */
    private static int displayOptionalMenu(Scanner scanner) {
        System.out.println("Quale categoria di Optional vuoi configurare? Seleziona un'opzione:");
        System.out.println("1. Assistente di guida");
        System.out.println("2. Sicurezza");
        System.out.println("0. Torna indietro");

        return getUserChoice(scanner, 2);
    }

    /**
     * Configures the car's headlights by allowing the user to choose from available options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureHeadLight(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<Headlights> headlightsOptions = queryService.getHeadlightOptions(car);
        if (headlightsOptions.isEmpty()) {
            System.out.println("Nessun fanale disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona un tipo di fanali:");

            for (int i = 0; i < headlightsOptions.size(); i++) {
                Headlights headlight = headlightsOptions.get(i);
                System.out.printf("%d. Modello: %s, Descrizione: %s%n", i + 1, headlight.getModel(), headlight.getDescr());
            }
            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, headlightsOptions.size());

            if (choice == 0) {
                return;
            }

            car.getExterior().setHeadlights(headlightsOptions.get(choice - 1));
            System.out.println("Fanali configurati correttamente.");
            return;
        }
    }

    /**
     * Configures the car's engine by allowing the user to choose from available engine options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureEngine(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<Engine> engines = queryService.getEngineComponents(car);
        if (engines.isEmpty()) {
            System.out.println("Nessun motore disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona un motore:");

            for (int i = 0; i < engines.size(); i++) {
                Engine engine = engines.get(i);
                System.out.printf("%d. Modello: %s, Potenza: %s, Consumo: %s%n", i + 1, engine.getModel(), engine.getPower(), engine.getFuelConsumption());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, engines.size());

            if (choice == 0) {
                return;
            }

            car.setEngine(engines.get(choice - 1));
            System.out.println(" Motore configurato correttamente!");
            return;
        }
    }

    /**
     * Configures the car's paint by allowing the user to choose from available paint options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configurePaint(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<Paint> paints = queryService.getColorOptions(car);
        if (paints.isEmpty()) {
            System.out.println("Nessun colore disponibile.");
            return;
        }

        if (car.getExterior() == null) {
            car.setExterior(new Exterior());
        }

        while (true) {
            System.out.println("Seleziona un colore di verniciatura:");

            for (int i = 0; i < paints.size(); i++) {
                Paint paint = paints.get(i);
                System.out.printf("%d. Colore: %s, Tipo: %s%n", i + 1, paint.getColor(), paint.getType());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, paints.size());

            if (choice == 0) {
                return;
            }

            car.getExterior().setPaint(paints.get(choice - 1));
            System.out.println("Verniciatura configurata correttamente!");
            return;
        }
    }

    /**
     * Configures the car's wheels by allowing the user to choose from available wheel options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureWheels(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<Wheels> wheels = queryService.getWheelOptions(car);
        if (wheels.isEmpty()) {
            System.out.println("Nessun cerchio disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona un cerchio:");
            for (int i = 0; i < wheels.size(); i++) {
                Wheels wheel = wheels.get(i);
                System.out.printf("%d. Modello: %s, Diametro: %s%n", i + 1, wheel.getModel(), wheel.getDiameter());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, wheels.size());

            if (choice == 0) {
                return;
            }

            car.getExterior().setWheels(wheels.get(choice - 1));
            System.out.println("Cerchi configurati correttamente.");
            return;
        }
    }

    /**
     * Configures the car's transmission by allowing the user to choose from available transmission options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureTransmission(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<Transmission> transmissions = queryService.getTransmissionOptions(car);
        if (transmissions.isEmpty()) {
            System.out.println("Nessuna trasmissione disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona una trasmissione:");
            for (int i = 0; i < transmissions.size(); i++) {
                Transmission transmission = transmissions.get(i);
                System.out.printf("%d. Tipo di trasmissione: %s%n", i + 1, transmission.getTransmissionType());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, transmissions.size());

            if (choice == 0) {
                return;
            }

            car.setTransmission(transmissions.get(choice - 1));
            System.out.println("Trasmissione configurata correttamente.");
            return;
        }
    }

    /**
     * Configures the car's ambient lighting by allowing the user to choose from available options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureAmbient(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<Ambient> ambientOptions = queryService.getAmbientLightingOptions(car);
        if (ambientOptions.isEmpty()) {
            System.out.println("Nessuna opzione di illuminazione ambientale disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona un'illuminazione ambientale:");

            for (int i = 0; i < ambientOptions.size(); i++) {
                Ambient ambient = ambientOptions.get(i);
                System.out.printf("%d. - Modello: %s, Tipo di illuminazione: %s%n", i + 1, ambient.getLightingType(), ambient.getDescr());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, ambientOptions.size());
            if (choice == 0) {
                return;
            }

            car.getInterior().setAmbientLighting(ambientOptions.get(choice - 1));
            System.out.println("Illuminazione ambientale configurata correttamente.");
            return;
        }
    }

    /**
     * Configures the car's seats by allowing the user to choose from available seat options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureSeats(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<Seats> seatOptions = queryService.getSeatOptions(car);
        if (seatOptions.isEmpty()) {
            System.out.println("Nessun sedile disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona un tipo di sedili:");
            for (int i = 0; i < seatOptions.size(); i++) {
                Seats seat = seatOptions.get(i);
                System.out.printf("%d. - Modello: %s, Optional sedili: %s%n", i + 1, seat.getModel(), seat.getSeatOptional());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, seatOptions.size());

            if (choice == 0) {
                return;
            }

            car.getInterior().addSeat(seatOptions.get(choice - 1));
            System.out.println("Sedili configurati correttamente.");
        }
    }

    /**
     * Configures the car's steering wheel by allowing the user to choose from available options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureSteeringWheel(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<SteeringWheel> steeringWheelOptions = queryService.getSteeringWheelOptions(car);
        if (steeringWheelOptions.isEmpty()) {
            System.out.println("Nessun volante disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona un tipo di volante:");

            for (int i = 0; i < steeringWheelOptions.size(); i++) {
                SteeringWheel steeringWheel = steeringWheelOptions.get(i);
                System.out.printf("%d. - Modello: %s, Optional volante: %s%n", i + 1, steeringWheel.getModel(), steeringWheel.getDescr());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, steeringWheelOptions.size());

            if (choice == 0) {
                return;
            }

            car.getInterior().setSteeringWheel(steeringWheelOptions.get(choice - 1));
            System.out.println("Volante configurato correttamente.");
            return;
        }
    }


    /**
     * Configures the car's driving assistant by allowing the user to choose from available options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureDrivingAssistant(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<DrivingAssistant> drivingAssistantOptions = queryService.getDrivingAssistantOptions(car);
        if (drivingAssistantOptions.isEmpty()) {
            System.out.println("Nessun assistente di guida disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona un tipo di assistente di guida:");
            for (int i = 0; i < drivingAssistantOptions.size(); i++) {
                DrivingAssistant drivingAssistant = drivingAssistantOptions.get(i);
                System.out.printf("%d. - Modello: %s, Tipo di assistente di guida: %s%n", i + 1, drivingAssistant.getModel(), drivingAssistant.getAssistantType());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, drivingAssistantOptions.size());
            if (choice == 0) {
                return;
            }

            car.getOptionals().addDrivingAssistant(drivingAssistantOptions.get(choice - 1));
            System.out.println("Assistente di guida configurato correttamente.");
        }
    }

    /**
     * Configures the car's upholstery by allowing the user to choose from available upholstery options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureUpholstery(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<Upholstery> upholsteries = queryService.getUpholsteryOptions(car);
        if (upholsteries.isEmpty()) {
            System.out.println("Nessun materiale per interni disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona un materiale per gli interni:");
            for (int i = 0; i < upholsteries.size(); i++) {
                Upholstery upholstery = upholsteries.get(i);
                System.out.printf("%d. - Model: %s, Colore: %s, Materiale: %s%n", i + 1, upholstery.getModel(), upholstery.getColor(), upholstery.getMaterial());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, upholsteries.size());

            if (choice == 0) {
                return;
            }

            car.getInterior().setUpholstery(upholsteries.get(choice - 1));
            System.out.println("Rivestimenti configurati correttamente.");
            return;
        }
    }

    /**
     * Configures the car's safety features by allowing the user to choose from available options.
     *
     * @param car The car object being configured.
     * @param queryService The service used to query car components.
     * @param scanner The scanner to read user input.
     */
    private static void configureSafety(Car car, CarComponentQueryService queryService, Scanner scanner) {
        List<Safety> safetyFeatures = queryService.getSafetyFeatures(car);
        if (safetyFeatures.isEmpty()) {
            System.out.println("Nessun sistema di sicurezza disponibile.");
            return;
        }

        while (true) {
            System.out.println("Seleziona un sistema di sicurezza:");
            for (int i = 0; i < safetyFeatures.size(); i++) {
                Safety safety = safetyFeatures.get(i);
                System.out.printf("%d. Pacchetto: %s%n", i + 1, safety.getSafetyPackage());
            }

            System.out.println("0. Torna indietro");

            int choice = getUserChoice(scanner, safetyFeatures.size());

            if (choice == 0) {
                return;
            }
            car.getOptionals().setSafety(safetyFeatures.get(choice - 1));
            System.out.println("Sistemi di sicurezza configurati correttamente.");
        }
    }

    /**
     * Displays the final configuration of the car to the user.
     *
     * @param car The car object whose configuration is displayed.
     */
    private static void displayFinalConfiguration(Car car) {
        System.out.println("Configurazione finale della tua Mercedes:");
        System.out.println("Modello: " + car.getModel());

        if (car.getEngine() != null) {
            System.out.println("Motore:");
            System.out.println("- Modello: " + car.getEngine().getModel());
            System.out.println("- Potenza: " + car.getEngine().getPower());
        } else {
            System.out.println("Motore:");
            System.out.println("    - Motore non configurato.");
        }

        if (car.getExterior() != null) {
            System.out.println("Esterni:");
            if (car.getExterior().getPaint() != null) {
                System.out.println("    - Verniciatura: " + car.getExterior().getPaint().getColor() + " (" + car.getExterior().getPaint().getType() + ")");
            } else {
                System.out.println("    - Verniciatura:");
                System.out.println("        - Verniciatura non configurata.");
            }

            if (car.getExterior().getWheels() != null) {
                System.out.println("    - Cerchi: " + car.getExterior().getWheels().getModel() + " (Diametro: " + car.getExterior().getWheels().getDiameter() + ")");
            } else {
                System.out.println("    - Cerchi: ");
                System.out.println("        - Cerchi non configurati.");
            }

            if (car.getExterior().getHeadlights() != null) {
                System.out.println("    - Fanali: " + car.getExterior().getHeadlights().getModel() + " (" + car.getExterior().getHeadlights().getDescr() + ")");
            } else {
                System.out.println("    - Fanali: Non configurati.");
            }
        } else {
            System.out.println("Esterni: ");
            System.out.println("    - Esterni non configurati");
        }

        if (car.getTransmission() != null) {
            System.out.println("Trasmissione:");
            System.out.println("    - Tipo: " + car.getTransmission().getTransmissionType());
        } else {
            System.out.println("Trasmissione:");
            System.out.println("    - Trasmissione Non configurata.");
        }

        if (car.getInterior() != null) {
            System.out.println("Interni:");
            if (car.getInterior().getUpholstery() != null) {
                System.out.println("    - Rivestimenti: Colore: " + car.getInterior().getUpholstery().getColor() + ", Materiale: " + car.getInterior().getUpholstery().getMaterial());
            } else {
                System.out.println("    - Rivestimenti: ");
                System.out.println("        - Rivestimenti non configurati.");
            }

            if (car.getInterior().getSeats() != null) {
                System.out.println("    - Sedili: ");
                for (int i = 0; i < car.getInterior().getSeats().size(); i++) {
                    Seats seats = car.getInterior().getSeats().get(i);
                    System.out.println("        - Optional: " + seats.getSeatOptional());
                }
            } else {
                System.out.println("    - Sedili: ");
                System.out.println("        - Sedili non configurati.");
            }

            if (car.getInterior().getSteeringWheel() != null) {
                System.out.println("    - Volante: " + car.getInterior().getSteeringWheel().getDescr());
            } else {
                System.out.println("    - Volante:");
                System.out.println("        - Volante non configurato.");
            }
            if (car.getInterior().getAmbientLighting() != null) {
                System.out.println("    - Ambiente: " + car.getInterior().getAmbientLighting().getDescr() + ", modello: " + car.getInterior().getAmbientLighting().getLightingType());
            } else {
                System.out.println("    - Ambiente:");
                System.out.println("        - Ambiente non configurato.");
            }
        } else {
            System.out.println("Interni: ");
            System.out.println("    - Interni non configurati");
        }

        if (car.getOptionals() != null) {

            System.out.println("Optional:");
            if (car.getOptionals().getDrivingAssistant() != null) {
                System.out.println("    - Assistente di guida: ");
                for (int i = 0; i < car.getOptionals().getDrivingAssistant().size(); i++) {
                    DrivingAssistant drivingAssistant = car.getOptionals().getDrivingAssistant().get(i);
                    System.out.println("        - Tipo: " + drivingAssistant.getAssistantType());
                }
            } else {
                System.out.println("    - Assistente di guida: Non configurato.");
            }

            if (car.getOptionals().getSafety() != null) {
                System.out.println("    - Sicurezza: ");
                System.out.println("        - Pacchetto: " + car.getOptionals().getSafety().getSafetyPackage());
            } else {
                System.out.println("    - Sicurezza: ");
                System.out.println("        - Sicurezza non configurata.");
            }
        } else {
            System.out.println("Optional: ");
            System.out.println("    - Optional non configurati");
        }

        System.out.println("Configurazione completa.");
    }

    /**
     * Helper method to get and validate the user's menu choice.
     *
     * @param scanner The scanner to read user input.
     * @param maxOptions The maximum number of options available in the menu.
     * @return The validated user choice.
     */
    private static int getUserChoice(Scanner scanner, int maxOptions) {
        int choice = -1;

        while (true) {
            System.out.print("Inserisci la tua scelta: ");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice >= 0 && choice <= maxOptions) {
                    return choice;
                } else {
                    System.out.println("Scelta non valida. Inserisci un numero tra 0 e " + maxOptions + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Inserisci un numero.");
            }
        }
    }

}
