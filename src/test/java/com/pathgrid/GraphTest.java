package com.pathgrid;

import com.pathgrid.dsa.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void addEdgeConnectsBothDirections() {
        Graph graph = new Graph();
        graph.addEdge("A", "B");

        assertTrue(graph.getNeighbours("A").contains("B"));
        assertTrue(graph.getNeighbours("B").contains("A"));
    }

    @Test
    void getLocationsReturnsAllAddedNodes() {
        Graph graph = new Graph();
        graph.addLocation("A");
        graph.addEdge("B", "C");

        assertEquals(List.of("A", "B", "C"), graph.getLocations());
    }

    @Test
    void duplicateEdgeIsNotAddedTwice() {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "B");

        assertEquals(1, graph.getNeighbours("A").size());
    }

    @Test
    void unknownLocationHasNoNeighbours() {
        Graph graph = new Graph();
        assertTrue(graph.getNeighbours("Nowhere").isEmpty());
    }
}
