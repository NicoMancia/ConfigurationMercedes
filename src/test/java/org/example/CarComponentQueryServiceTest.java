package org.example;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;
import org.example.Classes.*;
import org.example.Ontology.CarComponentQueryService;
import org.example.Ontology.CarSPARQLQueryExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarComponentQueryServiceTest {

    private CarComponentQueryService queryService;

    @BeforeEach
    public void setUp() {
        OntModel model = ModelFactory.createOntologyModel();
        model.read(getClass().getClassLoader().getResourceAsStream("OntologiaMercedes.rdf"), null);

        CarSPARQLQueryExecutor queryExecutor = new CarSPARQLQueryExecutor(model);
        queryService = new CarComponentQueryService(queryExecutor);
    }

    @Test
    public void testGetCarModel() {
        Car car = queryService.getCarModel();
        assertNotNull(car, "Car model should not be null");
        assertEquals("ClasseCBerlina", car.getModel(), "Car model name should be ClasseCBerlina");
    }

    @Test
    public void testGetHeadlightOptions() {
        Car car = queryService.getCarModel();
        List<Headlights> headlights = queryService.getHeadlightOptions(car);
        assertNotNull(headlights, "Headlights list should not be null");
        assertFalse(headlights.isEmpty(), "Headlights list should not be empty");
    }

    @Test
    public void testGetEngineComponents() {
        Car car = queryService.getCarModel();
        List<Engine> engines = queryService.getEngineComponents(car);
        assertNotNull(engines, "Engines list should not be null");
        assertFalse(engines.isEmpty(), "Engines list should not be empty");

        Engine engine = engines.get(0);
        assertNotNull(engine.getModel(), "Engine model should not be null");
        assertNotNull(engine.getPower(), "Engine power should not be null");
    }

    @Test
    public void testGetColorOptions() {
        Car car = queryService.getCarModel();
        List<Paint> paints = queryService.getColorOptions(car);
        assertNotNull(paints, "Paints list should not be null");
        assertFalse(paints.isEmpty(), "Paints list should not be empty");
    }

    @Test
    public void testGetSeatOptions() {
        Car car = queryService.getCarModel();
        List<Seats> seats = queryService.getSeatOptions(car);
        assertNotNull(seats, "Seats list should not be null");
        assertFalse(seats.isEmpty(), "Seats list should not be empty");
    }

    @Test
    public void testGetDrivingAssistantOptions() {
        Car car = queryService.getCarModel();
        List<DrivingAssistant> assistants = queryService.getDrivingAssistantOptions(car);
        assertNotNull(assistants, "Driving assistants list should not be null");
        assertFalse(assistants.isEmpty(), "Driving assistants list should not be empty");
    }
}
