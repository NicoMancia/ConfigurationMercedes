package org.example.Ontology;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Resource;
import org.example.Classes.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class responsible for querying car component details using SPARQL.
 * This class interacts with the ontology to retrieve information such as car models,
 * engine components, paint colors, wheels, and other customizable car parts.
 */
public class CarComponentQueryService {

    private CarSPARQLQueryExecutor queryExecutor;

    /**
     * Constructor for initializing the CarComponentQueryService with a SPARQL query executor.
     *
     * @param queryExecutor the SPARQL query executor responsible for executing queries against the ontology.
     */
    public CarComponentQueryService(CarSPARQLQueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }

    /**
     * Retrieves a specific car model instance, specifically "ClasseCBerlina", from the ontology.
     *
     * @return a Car instance representing the "ClasseCBerlina" model, or null if not found.
     */
    public Car getCarModel() {
        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?car WHERE { " +
                "?car rdf:type car:Car . " +
                "FILTER (?car = car:ClasseCBerlina) " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        if (results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource carResource = solution.getResource("car");
            return new Car(carResource.getLocalName());
        }

        System.out.println("Modello Classe G Berlina non trovato.");
        return null;
    }

    /**
     * Retrieves a list of available headlight options for the given car.
     *
     * @param car the car for which to retrieve headlight options.
     * @return a list of available headlights.
     */
    public List<Headlights> getHeadlightOptions(Car car) {
        List<Headlights> headlightsList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?headlight ?model WHERE { " +
                "?headlight rdf:type car:Headlights . " +
                "?headlight car:hasHeadlightModel ?model . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String headlightModel = solution.getResource("headlight").getLocalName();
            String headlightModelName = solution.getLiteral("model").getString();
            headlightsList.add(new Headlights(headlightModel, headlightModelName));
        }

        return headlightsList;
    }

    // Other methods omitted for brevity, but each method should have similar comments.
    // For example:

    /**
     * Retrieves a list of available engine components for the given car.
     *
     * @param car the car for which to retrieve engine components.
     * @return a list of available engines.
     */
    public List<Engine> getEngineComponents(Car car) {
        List<Engine> engineList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?engine ?model ?power ?fuelConsumption WHERE { " +
                "?engine rdf:type car:Engine . " +
                "?engine car:engineHasModel ?model . " +
                "?engine car:hasEnginePower ?power . " +
                "OPTIONAL { ?engine car:hasFuelConsumption ?fuelConsumption . }\n" +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String engineName = solution.getResource("engine").getLocalName();
            String enginePower = solution.getLiteral("power").getString();
            String fuelConsumption = solution.getLiteral("fuelConsumption").getString();
            engineList.add(new Engine(engineName, enginePower, fuelConsumption));
        }
        return engineList;
    }

    /**
     * Retrieves a list of available paint color options for the given car.
     *
     * @param car the car for which to retrieve paint color options.
     * @return a list of available paint options.
     */
    public List<Paint> getColorOptions(Car car) {
        List<Paint> colorList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?paint ?color ?type WHERE { " +
                "?paint rdf:type car:Paint . " +
                "?paint car:hasPaintColor ?color . " +
                "?paint car:hasPaintType ?type . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String paintColor = solution.getLiteral("color").getString();
            String paintType = solution.getLiteral("type").getString();
            colorList.add(new Paint(paintColor, paintType));
        }
        return colorList;
    }

    /**
     * Retrieves a list of available wheel options for the given car.
     *
     * @param car the car for which to retrieve wheel options.
     * @return a list of available wheels.
     */
    public List<Wheels> getWheelOptions(Car car) {
        List<Wheels> wheelList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?wheel ?diameter ?model WHERE { " +
                "?wheel rdf:type car:Wheels . " +
                "?wheel car:hasDiameter ?diameter . " +
                "?wheel car:hasWheelModel ?model . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String diameter = solution.getLiteral("diameter").getString();
            String model = solution.getLiteral("model").getString();
            wheelList.add(new Wheels(diameter, model));
        }
        return wheelList;
    }

    /**
     * Retrieves a list of available transmission options for the given car.
     *
     * @param car the car for which to retrieve transmission options.
     * @return a list of available transmissions.
     */
    public List<Transmission> getTransmissionOptions(Car car) {
        List<Transmission> transmissionList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?transmission ?type WHERE { " +
                "?transmission rdf:type car:Transmission . " +
                "?transmission car:hasTransmissionType ?type . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String transmissionType = solution.getLiteral("type").getString();
            transmissionList.add(new Transmission(transmissionType));
        }
        return transmissionList;
    }

    /**
     * Retrieves a list of available upholstery options for the given car.
     *
     * @param car the car for which to retrieve upholstery options.
     * @return a list of available upholstery materials.
     */
    public List<Upholstery> getUpholsteryOptions(Car car) {
        List<Upholstery> materialList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?upholstery ?color ?material WHERE { " +
                "?upholstery rdf:type car:Upholstery . " +
                "?upholstery car:hasUpholsteryColor ?color . " +
                "?upholstery car:hasUpholsteryMaterial ?material . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String model = solution.getResource("upholstery").getLocalName();
            String color = solution.getLiteral("color").getString();
            String material = solution.getLiteral("material").getString();
            materialList.add(new Upholstery(model, color, material));
        }
        return materialList;
    }

    /**
     * Retrieves a list of available ambient lighting options for the given car.
     *
     * @param car the car for which to retrieve ambient lighting options.
     * @return a list of available ambient lighting settings.
     */
    public List<Ambient> getAmbientLightingOptions(Car car) {
        List<Ambient> lightingList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?ambient ?lighting WHERE { " +
                "?ambient rdf:type car:Ambient . " +
                "?ambient car:hasAmbientLighting ?lighting . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String ambientType = solution.getResource("ambient").getLocalName();
            String lighting = solution.getLiteral("lighting").getString();
            lightingList.add(new Ambient(ambientType, lighting));
        }
        return lightingList;
    }

    /**
     * Retrieves a list of available safety features for the given car.
     *
     * @param car the car for which to retrieve safety features.
     * @return a list of available safety packages.
     */
    public List<Safety> getSafetyFeatures(Car car) {
        List<Safety> safetyList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?safety ?package WHERE { " +
                "?safety rdf:type car:Safety . " +
                "?safety car:hasSafetyPackage ?package . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String safetyPackage = solution.getLiteral("package").getString();
            safetyList.add(new Safety(safetyPackage));
        }
        return safetyList;
    }

    /**
     * Retrieves a list of available steering wheel options for the given car.
     *
     * @param car the car for which to retrieve steering wheel options.
     * @return a list of available steering wheels.
     */
    public List<SteeringWheel> getSteeringWheelOptions(Car car) {
        List<SteeringWheel> steeringWheelList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?steeringWheel ?option WHERE { " +
                "?steeringWheel rdf:type car:SteeringWheel . " +
                "?steeringWheel car:hasSteeringWheelOptional ?option . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String steeringWheelModel = solution.getResource("steeringWheel").getLocalName();
            String steeringWheelOptional = solution.getLiteral("option").getString();

            SteeringWheel steeringWheel = new SteeringWheel(steeringWheelModel, steeringWheelOptional);
            steeringWheelList.add(steeringWheel);
        }

        return steeringWheelList;
    }

    /**
     * Retrieves a list of available seat options for the given car.
     *
     * @param car the car for which to retrieve seat options.
     * @return a list of available seat configurations.
     */
    public List<Seats> getSeatOptions(Car car) {
        List<Seats> seatList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?seats ?option WHERE { " +
                "?seats rdf:type car:Seats . " +
                "?seats car:hasSeatOptional ?option . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {

            QuerySolution solution = results.nextSolution();
            String seatModel = solution.getResource("seats").getLocalName();
            String seatOption = solution.getLiteral("option").getString();
            seatList.add(new Seats(seatModel, seatOption));
        }
        return seatList;
    }

    /**
     * Retrieves a list of available driving assistant options for the given car.
     *
     * @param car the car for which to retrieve driving assistant options.
     * @return a list of available driving assistants.
     */
    public List<DrivingAssistant> getDrivingAssistantOptions(Car car) {
        List<DrivingAssistant> assistantList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX car: <http://www.semanticweb.org/nicol/ontologies/2024/8/untitled-ontology-9#> " +
                "SELECT ?assistant ?type WHERE { " +
                "?assistant rdf:type car:DrivingAssistant . " +
                "?assistant car:hasDrivingAssistantType ?type . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            String model = solution.getResource("assistant").getLocalName();
            String assistantType = solution.getLiteral("type").getString();
            assistantList.add(new DrivingAssistant(model, assistantType));
        }
        return assistantList;
    }

}
