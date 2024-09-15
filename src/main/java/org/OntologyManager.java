/*package org;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.ModelFactory;

//class that manages the ontology
public class OntologyManager {

    private OntModel ontModel;

    public OntologyManager(String ontologyFilePath) {
        ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        ontModel.read(ontologyFilePath);
    }

    public OntClass getClass(String uri) {
        return ontModel.getOntClass(uri);
    }

}*/
