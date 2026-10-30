package com.pathgrid;

import com.pathgrid.dsa.BFS;
import com.pathgrid.dsa.Graph;
import com.pathgrid.model.BFSStep;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    private Graph campusGraph() {
        Graph graph = new Graph();
        graph.addEdge("Main Gate", "Canteen");
        graph.addEdge("Main Gate", "CSE Block");
        graph.addEdge("Main Gate", "Hostel");
        graph.addEdge("CSE Block", "Library");
        graph.addEdge("CSE Block", "Admin Block");
        return graph;
    }

    @Test
    void findsShortestPathByEdges() {
        BFS.Result result = new BFS().findPath(campusGraph(), "Main Gate", "Library");

        assertEquals(List.of("Main Gate", "CSE Block", "Library"), result.getPath());
        assertEquals(2, result.getPathLength());
        assertEquals(result.getVisited().size(), result.getNodesVisited());
    }

    @Test
    void noPathReturnsEmptyPath() {
        Graph graph = new Graph();
        graph.addLocation("A");
        graph.addLocation("B"); // disconnected

        BFS.Result result = new BFS().findPath(graph, "A", "B");

        assertTrue(result.getPath().isEmpty());
        assertEquals(0, result.getPathLength());
    }

    @Test
    void invalidLocationThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new BFS().findPath(campusGraph(), "Main Gate", "Mars"));
    }

    @Test
    void stepsStartAtSourceAndStayFifoConsistent() {
        BFS.Result result = new BFS().findPath(campusGraph(), "Main Gate", "Library");
        List<BFSStep> steps = result.getSteps();

        assertFalse(steps.isEmpty());

        // Initial step: source queued, nothing visited yet.
        BFSStep first = steps.get(0);
        assertNull(first.getCurrent());
        assertEquals(List.of("Main Gate"), first.getQueue());
        assertTrue(first.getVisited().isEmpty());

        // Final step's visited snapshot matches the overall visited order.
        BFSStep last = steps.get(steps.size() - 1);
        assertEquals(result.getVisited(), last.getVisited());

        // Every queue snapshot is a plain list (front -> rear), never null.
        for (BFSStep step : steps) {
            assertNotNull(step.getQueue());
        }
    }
}
