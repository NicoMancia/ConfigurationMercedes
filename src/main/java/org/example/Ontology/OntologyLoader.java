package org.example.Ontology;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.InputStream;
import java.io.FileNotFoundException;

/**
 * Class responsible for loading an ontology from an RDF/OWL file into a Jena model.
 */
public class OntologyLoader {

    private OntModel ontologyModel;

    /**
     * Constructor that loads the ontology from the specified file path.
     *
     * @param filePath the path to the RDF/OWL file containing the ontology.
     */
    public OntologyLoader(String filePath) {
        loadOntology(filePath);
    }

    /**
     * Loads the ontology from the given file path and populates the Jena OntModel.
     * If the file cannot be found or read, the method throws an exception.
     *
     * @param filePath the path to the RDF/OWL file.
     */
    private void loadOntology(String filePath) {
        try {
            ontologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

            InputStream in = getClass().getClassLoader().getResourceAsStream(filePath);
            if (in == null) {
                ontologyModel = null;
                throw new FileNotFoundException("RDF file not found: " + filePath);
            }
            ontologyModel.read(in, null);
        } catch (FileNotFoundException e) {
            System.err.println("RDF file not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error loading the ontology: " + e.getMessage());
            ontologyModel = null;  // Set the model to null in case of an error
        }
    }

    /**
     * Returns the loaded Jena OntModel.
     *
     * @return the loaded OntModel, or null if loading the ontology failed.
     */
    public OntModel getOntologyModel() {
        return ontologyModel;
    }
}
