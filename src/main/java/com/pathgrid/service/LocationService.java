
package com.pathgrid.service;

import com.pathgrid.dsa.Graph;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocationService {

    private final GraphService graphService;

    public LocationService(GraphService graphService) {
        this.graphService = graphService;
    }

    // Return all campus locations.
    public List<String> getAllLocations() {
        Graph graph = graphService.getGraph();
        return graph.getLocations();
    }

    // Return details about a particular campus location.
    public Map<String, Object> getLocationDetails(String name) {

        Graph graph = graphService.getGraph();

        if (!graph.getLocations().contains(name)) {
            throw new IllegalArgumentException(
                    "Location not found: " + name
            );
        }

        Map<String, Object> details = new LinkedHashMap<>();

        details.put("name", name);
        details.put("neighbours", graph.getNeighbours(name));

        return details;
    }
}
