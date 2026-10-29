
package com.pathgrid.service;

import com.pathgrid.dsa.Graph;
import org.springframework.stereotype.Service;

@Service
public class GraphService {

    private final Graph graph;

    public GraphService() {
        graph = new Graph();
        initializeGraph();
    }

    // Add campus locations and their connections.
    private void initializeGraph() {

        // Add all campus locations.
        graph.addLocation("Main Gate");
        graph.addLocation("Canteen");
        graph.addLocation("CSE Block");
        graph.addLocation("Library");
        graph.addLocation("Hostel");
        graph.addLocation("Admin Block");
        graph.addLocation("Sports Complex");
        graph.addLocation("Parking");
        graph.addLocation("Medical Centre");

        // Connect the campus locations.
        graph.addEdge("Main Gate", "Canteen");
        graph.addEdge("Main Gate", "CSE Block");
        graph.addEdge("Main Gate", "Hostel");

        graph.addEdge("CSE Block", "Library");
        graph.addEdge("CSE Block", "Admin Block");
        graph.addEdge("CSE Block", "Sports Complex");

        graph.addEdge("Canteen", "Parking");
        graph.addEdge("Hostel", "Medical Centre");
        graph.addEdge("Admin Block", "Medical Centre");
    }

    // Provide access to the initialized graph.
    public Graph getGraph() {
        return graph;
    }
}
