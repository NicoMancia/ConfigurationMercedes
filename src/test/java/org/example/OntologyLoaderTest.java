package org.example;

import org.apache.jena.ontology.OntModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Ontology.OntologyLoader;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

public class OntologyLoaderTest {

    private OntologyLoader ontologyLoader;

    @BeforeEach
    public void setUp() {
        ontologyLoader = new OntologyLoader("testOntology.rdf");
    }

    @Test
    public void testOntologyModelNotNull() {
        OntModel model = ontologyLoader.getOntologyModel();
        assertNotNull(model, "The ontology model should not be null");
    }

    @Test
    public void testOntologyHasStatements() {
        OntModel model = ontologyLoader.getOntologyModel();
        assertNotNull(model, "The ontology model should not be null");
        assertTrue(model.size() > 0, "The ontology model should contain statements");
    }

    @Test
    public void testInvalidFilePath() {
        OntologyLoader loader = new OntologyLoader("invalidFilePath.rdf");
        OntModel model = loader.getOntologyModel();

        assertTrue(model.isEmpty(), "The ontology model should be empty for an invalid file path");
    }


}
