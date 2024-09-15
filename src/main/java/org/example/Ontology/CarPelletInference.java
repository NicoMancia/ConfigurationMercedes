package org.example.Ontology;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.ModelFactory;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.reasoner.Reasoner;

/**
 * This class performs inference on a car ontology model using the Pellet reasoner.
 */
public class CarPelletInference {

    private InfModel inferredModel;

    /**
     * Constructor that accepts an ontology model and creates an inferred model using Pellet.
     *
     * @param ontologyModel The car ontology model to perform inference on.
     */
    public CarPelletInference(OntModel ontologyModel) {
        performInference(ontologyModel);
    }

    /**
     * Performs inference on the given car ontology model using the Pellet reasoner.
     *
     * @param ontologyModel The car ontology model on which to perform the inference.
     */
    private void performInference(OntModel ontologyModel) {
        // Create the reasoner with Pellet
        Reasoner reasoner = PelletReasonerFactory.theInstance().create();

        // Associate the reasoner with the RDF model to create the inferred model
        inferredModel = ModelFactory.createInfModel(reasoner, ontologyModel);

        System.out.println("Inference on car ontology completed.");
    }

    /**
     * Returns the inferred model after the reasoning process.
     *
     * @return The inferred model.
     */
    public InfModel getInferredModel() {
        return inferredModel;
    }
}
