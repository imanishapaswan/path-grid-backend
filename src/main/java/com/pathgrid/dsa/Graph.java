
package com.pathgrid.dsa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    // Each location is connected to a list of neighbouring locations.
    private final Map<String, List<String>> adjacencyList = new LinkedHashMap<>();

    // Add a new campus location.
    public void addLocation(String location) {
        adjacencyList.putIfAbsent(location, new ArrayList<>());
    }

    // Connect two locations in both directions.
    public void addEdge(String location1, String location2) {
        addLocation(location1);
        addLocation(location2);

        if (!adjacencyList.get(location1).contains(location2)) {
            adjacencyList.get(location1).add(location2);
        }

        if (!adjacencyList.get(location2).contains(location1)) {
            adjacencyList.get(location2).add(location1);
        }
    }

    // Return the locations directly connected to a given location.
    public List<String> getNeighbours(String location) {
        if (!adjacencyList.containsKey(location)) {
            return new ArrayList<>();
        }

        return new ArrayList<>(adjacencyList.get(location));
    }

    // Return all campus locations.
    public List<String> getLocations() {
        return new ArrayList<>(adjacencyList.keySet());
    }
}
